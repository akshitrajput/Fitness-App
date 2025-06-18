package com.example.fitnessapp.main_pages.workout_pages


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fitnessapp.Routes

@Composable
fun ExploreExercisesPage(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }
    val allExercises = ExerciseRepository.exerciseList

    val filteredExercises = allExercises.filter {
        it.name.contains(searchQuery, ignoreCase = true)
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search exercises") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(filteredExercises) { exercise ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clickable {
                            navController.navigate("${Routes.exerciseDetail}/${exercise.id}")
                        }
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(text = exercise.name, style = MaterialTheme.typography.titleMedium)
                    }
                }
            }
        }
    }
}
