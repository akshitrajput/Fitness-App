package com.example.fitnessapp.main_pages.meal_pages

import kotlinx.coroutines.flow.*

class MealRepository(private val dataStore: CalorieDataStore) {

    val totalCalories: Flow<Float> = dataStore.totalCalories
    val totalProtein: Flow<Float> = dataStore.totalProtein
    val totalFat: Flow<Float> = dataStore.totalFat
    val totalCarbs: Flow<Float> = dataStore.totalCarbs

    suspend fun addCalories(cal: Float, protein: Float, fat: Float, carbs: Float) {
        // capture current
        val current = totalCalories.first()
        val p = totalProtein.first()
        val f = totalFat.first()
        val c = totalCarbs.first()
        dataStore.updateAll(current + cal, p + protein, f + fat, c + carbs)
    }

    suspend fun resetAll() = dataStore.resetAll()
}
