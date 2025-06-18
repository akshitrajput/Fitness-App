package com.example.fitnessapp.main_pages.meal_pages

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MealViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val dataStore = CalorieDataStore(context)
        val repository = MealRepository(dataStore)
        return MealViewModel(repository) as T
    }
}
