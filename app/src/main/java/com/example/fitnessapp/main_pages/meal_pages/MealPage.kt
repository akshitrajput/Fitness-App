package com.example.fitnessapp.main_pages.meal_pages

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fitnessapp.ui.theme.AppFonts

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MealPage(mealViewModel: MealViewModel) {
    val mealViewModel: MealViewModel = viewModel(factory = MealViewModelFactory(LocalContext.current))
    val foodList = FoodRepository.foodList
    val drinkList = DrinkRepository.drinkList

    var selectedFood by remember { mutableStateOf<FoodItem?>(null) }
    var foodQuantity by remember { mutableStateOf("") }

    var selectedDrink by remember { mutableStateOf<DrinkItem?>(null) }
    var drinkQuantity by remember { mutableStateOf("") }

    val totalCalories by mealViewModel.totalCalories.collectAsState()
    val totalProtein by mealViewModel.totalProtein.collectAsState()
    val totalFat by mealViewModel.totalFat.collectAsState()
    val totalCarbs by mealViewModel.totalCarbs.collectAsState()

    Scaffold(
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(20.dp))
            Text("Calorie Intake", fontFamily = AppFonts.Poppins, fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(5.dp))
            MealCard(
                title = "🥗 Add Food",
                content = {
                    DropdownSelector(
                        items = foodList,
                        selectedItem = selectedFood,
                        onItemSelected = { selectedFood = it },
                        itemLabel = { it.name }
                    )

                    Spacer(Modifier.height(8.dp))

                    OutlinedTextField(
                        value = foodQuantity,
                        onValueChange = { foodQuantity = it },
                        label = { Text("Quantity (g)") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(Modifier.height(8.dp))

                    Button(
                        onClick = {
                            selectedFood?.let {
                                mealViewModel.addFoodItem(it, foodQuantity.toFloatOrNull() ?: 0f)
                                foodQuantity = ""
                            }
                        },
                        enabled = selectedFood != null && foodQuantity.toFloatOrNull() != null,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Add Food")
                    }
                }
            )

            MealCard(
                title = "🥤 Add Drink",
                content = {
                    DropdownSelector(
                        items = drinkList,
                        selectedItem = selectedDrink,
                        onItemSelected = { selectedDrink = it },
                        itemLabel = { it.name }
                    )

                    Spacer(Modifier.height(8.dp))

                    OutlinedTextField(
                        value = drinkQuantity,
                        onValueChange = { drinkQuantity = it },
                        label = { Text("Quantity (ml)") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(Modifier.height(8.dp))

                    Button(
                        onClick = {
                            selectedDrink?.let {
                                mealViewModel.addDrinkItem(it, drinkQuantity.toFloatOrNull() ?: 0f)
                                drinkQuantity = ""
                            }
                        },
                        enabled = selectedDrink != null && drinkQuantity.toFloatOrNull() != null,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Add Drink")
                    }
                }
            )

            OutlinedButton(
                onClick = { mealViewModel.resetDailyCalories() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("🔁 Reset Daily Totals")
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}


@Composable
fun MealCard(title: String, content: @Composable ColumnScope.() -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(title, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
            content()
        }
    }
}

@Composable
fun <T> DropdownSelector(
    items: List<T>,
    selectedItem: T?,
    onItemSelected: (T) -> Unit,
    itemLabel: (T) -> String
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = selectedItem?.let(itemLabel) ?: "",
            onValueChange = {},
            label = { Text("Select") },
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Dropdown")
                }
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = { Text(itemLabel(item)) },
                    onClick = {
                        onItemSelected(item)
                        expanded = false
                    }
                )
            }
        }
    }
}
