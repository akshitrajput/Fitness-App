package com.example.fitnessapp.view_models

import androidx.lifecycle.*
import com.example.fitnessapp.main_pages.meal_pages.DrinkItem
import com.example.fitnessapp.main_pages.meal_pages.FoodItem
import com.example.fitnessapp.main_pages.meal_pages.MealRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MealViewModel(private val repo: MealRepository) : ViewModel() {

    val totalCalories = repo.totalCalories.stateIn(
        viewModelScope, SharingStarted.Eagerly, 0f
    )
    val totalProtein = repo.totalProtein.stateIn(
        viewModelScope, SharingStarted.Eagerly, 0f
    )
    val totalFat = repo.totalFat.stateIn(
        viewModelScope, SharingStarted.Eagerly, 0f
    )
    val totalCarbs = repo.totalCarbs.stateIn(
        viewModelScope, SharingStarted.Eagerly, 0f
    )

    fun addFoodItem(food: FoodItem, qty: Float) {
        val nutrients = food.calculateMacros(qty)
        viewModelScope.launch {
            repo.addCalories(nutrients.calories, nutrients.protein, nutrients.fat, nutrients.carbs)
        }
    }

    fun addDrinkItem(drink: DrinkItem, qty: Float) {
        val nutrients = drink.calculateMacros(qty)
        viewModelScope.launch {
            repo.addCalories(nutrients.calories, nutrients.protein, nutrients.fat, nutrients.carbs)
        }
    }

    fun resetDailyCalories() {
        viewModelScope.launch { repo.resetAll() }
    }
}
