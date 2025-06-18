package com.example.fitnessapp.main_pages.workout_pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RoutineCreationDialog(onDismiss: () -> Unit) {
    val exercises = ExerciseRepository.exerciseList
    val selectedExercises = remember { mutableStateListOf<Exercise>() }
    var routineName by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Create Routine") },
        text = {
            Column {
                OutlinedTextField(
                    value = routineName,
                    onValueChange = { routineName = it },
                    label = { Text("Routine Name") }
                )
                Spacer(Modifier.height(10.dp))
                LazyColumn {
                    items(exercises) { exercise ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    if (selectedExercises.contains(exercise)) {
                                        selectedExercises.remove(exercise)
                                    } else {
                                        selectedExercises.add(exercise)
                                    }
                                }
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = selectedExercises.contains(exercise),
                                onCheckedChange = {
                                    if (it) selectedExercises.add(exercise)
                                    else selectedExercises.remove(exercise)
                                }
                            )
                            Spacer(Modifier.width(8.dp))
                            Text(exercise.name)
                        }
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (routineName.isNotBlank() && selectedExercises.isNotEmpty()) {
                        RoutineRepository.addRoutine(routineName, selectedExercises.toList())
                        onDismiss()
                    }
                }
            ) {
                Text("Save")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
