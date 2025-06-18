package com.example.fitnessapp.main_pages.workout_pages

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import java.text.SimpleDateFormat
import java.util.*

private val Context.dataStore by preferencesDataStore("workout_prefs")

class DataStoreManager(private val context: Context) {

    companion object {
        val CALORIES_KEY = floatPreferencesKey("calories_burned")
        val DATE_KEY = stringPreferencesKey("last_updated_date")
    }

    suspend fun getCaloriesBurned(): Float {
        val prefs = context.dataStore.data.first()
        val today = getCurrentDate()

        val lastSavedDate = prefs[DATE_KEY]
        if (lastSavedDate != today) {
            saveCalories(0f) // reset for new day
            return 0f
        }

        return prefs[CALORIES_KEY] ?: 0f
    }

    suspend fun saveCalories(calories: Float) {
        val today = getCurrentDate()
        context.dataStore.edit { prefs ->
            prefs[CALORIES_KEY] = calories
            prefs[DATE_KEY] = today
        }
    }

    suspend fun resetCalories() {
        saveCalories(0f)
    }

    private fun getCurrentDate(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return sdf.format(Date())
    }
}
