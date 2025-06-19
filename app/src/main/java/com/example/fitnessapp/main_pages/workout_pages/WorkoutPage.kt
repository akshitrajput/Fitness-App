package com.example.fitnessapp.main_pages.workout_pages

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.fitnessapp.Routes
import com.example.fitnessapp.ui.theme.AppFonts
import com.example.fitnessapp.view_models.WorkoutViewModel
import com.example.fitnessapp.view_models.WorkoutViewModelFactory

@Composable
fun WorkoutPage(navController: NavController) {
    val context = LocalContext.current
    val application = context.applicationContext as Application
    val viewModelFactory = remember { WorkoutViewModelFactory(application) }
    val viewModel: WorkoutViewModel = viewModel(factory = viewModelFactory)

    WorkoutPageContent(viewModel = viewModel, navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkoutPageContent(viewModel: WorkoutViewModel, navController: NavController) {
    val exercises = ExerciseRepository.exerciseList
    var selectedExercise by remember { mutableStateOf(exercises[0]) }
    var repsInput by remember { mutableStateOf("") }
    val caloriesBurned by viewModel.totalCaloriesBurned.collectAsState()
    var dropdownExpanded by remember { mutableStateOf(false) }

    Scaffold(
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Spacer(Modifier.height(20.dp))
            Text("Calorie Burn", fontFamily = AppFonts.Poppins, fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(15.dp))
            // --- Exercise Card ---
            WorkoutCard(title = "🏋️‍♂️ Add an Exercise") {
                Text("Choose Exercise", fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(4.dp))

                Box {
                    OutlinedButton(
                        onClick = { dropdownExpanded = true },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(selectedExercise.name)
                    }

                    DropdownMenu(
                        expanded = dropdownExpanded,
                        onDismissRequest = { dropdownExpanded = false }
                    ) {
                        exercises.forEach { exercise ->
                            DropdownMenuItem(
                                text = { Text(exercise.name) },
                                onClick = {
                                    selectedExercise = exercise
                                    dropdownExpanded = false
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(6.dp))

                OutlinedTextField(
                    value = repsInput,
                    onValueChange = { repsInput = it.filter(Char::isDigit) },
                    label = { Text("Number of Reps") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {
                        repsInput.toIntOrNull()?.let {
                            viewModel.addWorkout(selectedExercise, it)
                            repsInput = ""
                        }
                    },
                    enabled = repsInput.isNotBlank(),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("✅ Log Workout")
                }
            }

            // --- Calories Summary Card ---
            WorkoutCard(title = "🔥 Calories Burned Today") {
                Text(
                    text = "${caloriesBurned.toInt()} kcal",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            // --- Reset Button ---
            OutlinedButton(
                onClick = { viewModel.resetWorkout() },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
            ) {
                Text("🔁 Reset Today")
            }

            // --- Navigation Section ---
            Text(
                "More Options",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.align(Alignment.Start)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = { navController.navigate(Routes.routines) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("📋 My Routines")
                }

                Button(
                    onClick = { navController.navigate(Routes.exploreExercises) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("🔍 Explore")
                }
            }
        }
    }
}

@Composable
fun WorkoutCard(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            content()
        }
    }
}
