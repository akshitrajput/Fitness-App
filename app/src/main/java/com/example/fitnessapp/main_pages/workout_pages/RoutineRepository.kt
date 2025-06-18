package com.example.fitnessapp.main_pages.workout_pages

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object RoutineRepository {
    private val _routines = MutableStateFlow<List<Routine>>(emptyList())
    val routines: StateFlow<List<Routine>> = _routines

    fun addRoutine(name: String, exercises: List<Exercise>) {
        val newRoutine = Routine(name, exercises)
        _routines.value = _routines.value + newRoutine
    }
}