package com.example.fitnessapp.main_pages.meal_pages

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first


class MealRepository(private val calorieDataStore: CalorieDataStore) {

    val totalCalories: Flow<Float> = calorieDataStore.totalCalories

    // New function
    suspend fun addCalories(amount: Float) {
        val current = calorieDataStore.totalCalories.first()
        calorieDataStore.updateCalories(current + amount)
    }

    // Rename for clarity or add this alias
    suspend fun resetCalories() {
        calorieDataStore.resetCalories()
    }
}
