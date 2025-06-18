package com.example.fitnessapp.main_pages.workout_pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun RoutinePage(navController: NavController) {
    val allRoutines by RoutineRepository.routines.collectAsState()
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(Modifier.height(20.dp))
        Text("My Routines", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { showDialog = true }) {
            Text("Add New Routine")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(allRoutines) { routine ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(routine.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Spacer(Modifier.height(4.dp))
                        Text("Exercises: ${routine.exercises.joinToString { it.name }}")
                    }
                }
            }
        }

        if (showDialog) {
            RoutineCreationDialog(onDismiss = { showDialog = false })
        }
    }
}
