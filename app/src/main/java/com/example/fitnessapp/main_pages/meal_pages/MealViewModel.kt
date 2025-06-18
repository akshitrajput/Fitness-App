package com.example.fitnessapp.main_pages.meal_pages

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.launch

class MealViewModel(private val mealRepository: MealRepository) : ViewModel() {

    private val _totalCalories = MutableStateFlow(0f)
    val totalCalories: StateFlow<Float> = _totalCalories

    private val _totalProtein = MutableStateFlow(0f)
    val totalProtein: StateFlow<Float> = _totalProtein

    private val _totalFat = MutableStateFlow(0f)
    val totalFat: StateFlow<Float> = _totalFat

    private val _totalCarbs = MutableStateFlow(0f)
    val totalCarbs: StateFlow<Float> = _totalCarbs

    fun addFoodItem(foodItem: FoodItem, quantity: Float) {
        val nutrients = foodItem.calculateMacros(quantity)
        viewModelScope.launch {
            mealRepository.addCalories(nutrients.calories)
            // update local totals
            _totalCalories.value += nutrients.calories
            _totalProtein.value += nutrients.protein
            _totalFat.value += nutrients.fat
            _totalCarbs.value += nutrients.carbs
        }
    }

    fun addDrinkItem(drinkItem: DrinkItem, quantity: Float) {
        val nutrients = drinkItem.calculateMacros(quantity)
        viewModelScope.launch {
            mealRepository.addCalories(nutrients.calories)
            _totalCalories.value += nutrients.calories
            _totalProtein.value += nutrients.protein
            _totalFat.value += nutrients.fat
            _totalCarbs.value += nutrients.carbs
        }
    }

    fun resetDailyCalories() {
        viewModelScope.launch {
            mealRepository.resetCalories()
            _totalCalories.value = 0f
            _totalProtein.value = 0f
            _totalFat.value = 0f
            _totalCarbs.value = 0f
        }
    }
}
