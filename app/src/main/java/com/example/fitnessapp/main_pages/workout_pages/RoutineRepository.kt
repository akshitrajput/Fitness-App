package com.example.fitnessapp.main_pages.workout_pages

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object RoutineRepository {
    private val _routines = MutableStateFlow<List<Routine>>(emptyList())
    val routines: StateFlow<List<Routine>> = _routines

    private val firestore = FirebaseFirestore.getInstance()
    private val userId = FirebaseAuth.getInstance().currentUser?.uid

    fun addRoutine(name: String, exercises: List<Exercise>) {
        val newRoutine = Routine(name, exercises)
        _routines.value = _routines.value + newRoutine
        saveRoutineToFirestore(newRoutine)
    }

    private fun saveRoutineToFirestore(routine: Routine) {
        userId?.let { uid ->
            val routineData = mapOf(
                "Name" to routine.name,
                "Exercises" to routine.exercises.map {
                    mapOf(
                        "name" to it.name
                    )
                }
            )
            firestore.collection("Users")
                .document(uid)
                .collection("Routines")
                .document(routine.name)
                .set(routineData)
        }
    }
}
