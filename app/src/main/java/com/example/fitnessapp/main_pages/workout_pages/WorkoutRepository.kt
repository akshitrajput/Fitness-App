package com.example.fitnessapp.main_pages.workout_pages

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class WorkoutRepository {
    private val _totalCaloriesBurned = MutableStateFlow(0f)
    val totalCaloriesBurned: StateFlow<Float> = _totalCaloriesBurned

    fun calculateCalories(exercise: Exercise, reps: Int) {
        val total = exercise.caloriesPerRep * reps
        _totalCaloriesBurned.value += total
    }

    fun resetCalories() {
        _totalCaloriesBurned.value = 0f
    }
}