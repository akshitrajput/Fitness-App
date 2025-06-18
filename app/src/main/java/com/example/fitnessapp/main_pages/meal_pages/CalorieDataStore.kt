package com.example.fitnessapp.main_pages.meal_pages

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "calorie_data")

class CalorieDataStore(private val context: Context) {
    private val totalCaloriesKey = floatPreferencesKey("total_calories")
    private val totalProteinKey = floatPreferencesKey("total_protein")
    private val totalFatKey = floatPreferencesKey("total_fat")
    private val totalCarbsKey = floatPreferencesKey("total_carbs")

    val totalCalories: Flow<Float> = context.dataStore.data.map { it[totalCaloriesKey] ?: 0f }
    val totalProtein: Flow<Float> = context.dataStore.data.map { it[totalProteinKey] ?: 0f }
    val totalFat: Flow<Float> = context.dataStore.data.map { it[totalFatKey] ?: 0f }
    val totalCarbs: Flow<Float> = context.dataStore.data.map { it[totalCarbsKey] ?: 0f }

    suspend fun updateAll(calories: Float, protein: Float, fat: Float, carbs: Float) {
        context.dataStore.edit { prefs ->
            prefs[totalCaloriesKey] = calories
            prefs[totalProteinKey] = protein
            prefs[totalFatKey] = fat
            prefs[totalCarbsKey] = carbs
        }
    }

    suspend fun updateCalories(calories: Float) {
        context.dataStore.edit { prefs ->
            prefs[totalCaloriesKey] = calories
        }
    }

    suspend fun resetCalories() {
        context.dataStore.edit { prefs ->
            prefs[totalCaloriesKey] = 0f
        }
    }


    suspend fun resetAll() {
        context.dataStore.edit { prefs ->
            prefs[totalCaloriesKey] = 0f
            prefs[totalProteinKey] = 0f
            prefs[totalFatKey] = 0f
            prefs[totalCarbsKey] = 0f
        }
    }
}
