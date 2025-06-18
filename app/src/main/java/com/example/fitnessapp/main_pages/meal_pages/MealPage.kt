package com.example.fitnessapp.main_pages.meal_pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun MealPage(mealViewModel: MealViewModel) {
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

    Column(modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.height(30.dp))
        Text("Select Food", style = MaterialTheme.typography.titleMedium)

        DropdownSelector(
            items = foodList,
            selectedItem = selectedFood,
            onItemSelected = { selectedFood = it },
            itemLabel = { it.name }
        )

        OutlinedTextField(
            value = foodQuantity,
            onValueChange = { foodQuantity = it },
            label = { Text("Quantity (g)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(
            onClick = {
                val qty = foodQuantity.toFloatOrNull() ?: 0f
                selectedFood?.let { mealViewModel.addFoodItem(it, qty) }
            },
            enabled = selectedFood != null && foodQuantity.toFloatOrNull() != null
        ) {
            Text("Add Food")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Select Drink", style = MaterialTheme.typography.titleMedium)

        DropdownSelector(
            items = drinkList,
            selectedItem = selectedDrink,
            onItemSelected = { selectedDrink = it },
            itemLabel = { it.name }
        )

        OutlinedTextField(
            value = drinkQuantity,
            onValueChange = { drinkQuantity = it },
            label = { Text("Quantity (ml)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(
            onClick = {
                val qty = drinkQuantity.toFloatOrNull() ?: 0f
                selectedDrink?.let { mealViewModel.addDrinkItem(it, qty) }
            },
            enabled = selectedDrink != null && drinkQuantity.toFloatOrNull() != null
        ) {
            Text("Add Drink")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text("Total Calories: ${totalCalories.toInt()} kcal", style = MaterialTheme.typography.titleMedium)
        Text("Protein: ${totalProtein.toInt()}g", style = MaterialTheme.typography.bodyLarge)
        Text("Fat: ${totalFat.toInt()}g", style = MaterialTheme.typography.bodyLarge)
        Text("Carbs: ${totalCarbs.toInt()}g", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { mealViewModel.resetDailyCalories() }) {
            Text("Reset Daily Totals")
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
    Box {
        OutlinedTextField(
            value = selectedItem?.let { itemLabel(it) } ?: "",
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
