package com.example.fitnessapp.main_pages.workout_pages


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WorkoutViewModel(application: Application) : AndroidViewModel(application) {

    private val dataStoreManager = DataStoreManager(application)
    private val _totalCaloriesBurned = MutableStateFlow(0f)
    val totalCaloriesBurned: StateFlow<Float> = _totalCaloriesBurned

    init {
        viewModelScope.launch {
            _totalCaloriesBurned.value = dataStoreManager.getCaloriesBurned()
        }
    }

    fun addWorkout(exercise: Exercise, reps: Int) {
        viewModelScope.launch {
            val newCalories = exercise.caloriesPerRep * reps
            val updated = _totalCaloriesBurned.value + newCalories
            _totalCaloriesBurned.value = updated
            dataStoreManager.saveCalories(updated)
        }
    }

    fun resetWorkout() {
        viewModelScope.launch {
            dataStoreManager.resetCalories()
            _totalCaloriesBurned.value = 0f
        }
    }
}
