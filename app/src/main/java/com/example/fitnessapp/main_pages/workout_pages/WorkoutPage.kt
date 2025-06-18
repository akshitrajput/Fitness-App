package com.example.fitnessapp.main_pages.workout_pages

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.fitnessapp.Routes

@Composable
fun WorkoutPage(navController: NavController) {
    val context = LocalContext.current
    val application = context.applicationContext as Application
    val viewModelFactory = remember { WorkoutViewModelFactory(application) }
    val viewModel: WorkoutViewModel = viewModel(factory = viewModelFactory)

    WorkoutPageContent(viewModel = viewModel,navController)
}

@Composable
fun WorkoutPageContent(viewModel: WorkoutViewModel,navController: NavController) {
    val exercises = ExerciseRepository.exerciseList
    var selectedExercise by remember { mutableStateOf(exercises[0]) }
    var repsInput by remember { mutableStateOf("") }

    val caloriesBurned by viewModel.totalCaloriesBurned.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Workout Page", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(10.dp))

        // Exercise Dropdown
        var expanded by remember { mutableStateOf(false) }
        Box {
            Button(onClick = { expanded = true }) {
                Text(selectedExercise.name)
            }
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                exercises.forEach { exercise ->
                    DropdownMenuItem(
                        text = { Text(exercise.name) },
                        onClick = {
                            selectedExercise = exercise
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Reps Input
        OutlinedTextField(
            value = repsInput,
            onValueChange = { repsInput = it.filter { it.isDigit() } },
            label = { Text("Number of Reps") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                val reps = repsInput.toIntOrNull()
                if (reps != null && reps > 0) {
                    viewModel.addWorkout(selectedExercise, reps)
                    repsInput = ""
                }
            }
        ) {
            Text("Add Workout")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text("Calories Burned Today: ${caloriesBurned.toInt()} kcal", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            viewModel.resetWorkout()
        }, colors = ButtonDefaults.buttonColors(containerColor = Color.Red)) {
            Text("Reset Today", color = Color.White)
        }

        Button(
            onClick = { navController.navigate(Routes.routines) },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("My Routines")
        }
        Spacer(Modifier.height(20.dp))
        Button(
            onClick = { navController.navigate(Routes.exploreExercises) },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Explore Exercises")
        }
    }
}
