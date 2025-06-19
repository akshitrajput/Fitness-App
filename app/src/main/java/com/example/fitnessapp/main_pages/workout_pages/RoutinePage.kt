package com.example.fitnessapp.main_pages.workout_pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fitnessapp.ui.theme.AppFonts

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoutinePage(navController: NavController) {
    val allRoutines by RoutineRepository.routines.collectAsState()
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog = true }) {
                Icon(Icons.Default.Add, contentDescription = "Add Routine")
            }
        },
        topBar = {
            TopAppBar(
                title = { Text("My Routines", modifier = Modifier.padding(10.dp),fontSize = 22.sp, fontWeight = FontWeight.SemiBold,) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFBECADD)
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            if (allRoutines.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No routines found. Click + to add.", style = MaterialTheme.typography.bodyMedium)
                }
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(bottom = 80.dp)
                ) {
                    items(allRoutines) { routine ->
                        RoutineCard(routine)
                    }
                }
            }

            if (showDialog) {
                RoutineCreationDialog(onDismiss = { showDialog = false })
            }
        }
    }
}

@Composable
fun RoutineCard(routine: Routine) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFBECADD))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                routine.name,
                fontFamily = AppFonts.Poppins,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(Modifier.height(6.dp))
            Text(
                text = "Exercises: ${routine.exercises.joinToString { it.name }}",
                fontFamily = AppFonts.Poppins
            )
        }
    }
}

