package com.example.fitnessapp.view_models


import android.content.Context
import androidx.lifecycle.*
import com.example.fitnessapp.main_pages.meal_pages.CalorieDataStore
import com.example.fitnessapp.main_pages.meal_pages.MealRepository

class MealViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val ds = CalorieDataStore(context)
        val repo = MealRepository(ds)
        @Suppress("UNCHECKED_CAST")
        return MealViewModel(repo) as T
    }
}
