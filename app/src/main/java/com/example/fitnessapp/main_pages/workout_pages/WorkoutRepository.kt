package com.example.fitnessapp.main_pages.workout_pages

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import java.text.SimpleDateFormat
import java.util.*

class WorkoutRepository(context: Context) {
    private val dataStore = DataStoreManager(context)
    private val firestore = FirebaseFirestore.getInstance()
    private val userId = FirebaseAuth.getInstance().currentUser?.uid

    private val _totalCaloriesBurned = MutableStateFlow(0f)
    val totalCaloriesBurned: Flow<Float> = _totalCaloriesBurned.asStateFlow()

    init {
        runBlocking {
            _totalCaloriesBurned.value = dataStore.getCaloriesBurned()
        }
    }

    suspend fun addCalories(calories: Float) {
        val newTotal = _totalCaloriesBurned.value + calories
        _totalCaloriesBurned.value = newTotal
        dataStore.saveCalories(newTotal)
        saveToFirestore(newTotal)
    }

    suspend fun resetCalories() {
        _totalCaloriesBurned.value = 0f
        dataStore.resetCalories()
        saveToFirestore(0f)
    }

    private fun saveToFirestore(calories: Float) {
        val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        userId?.let { uid ->
            val data = mapOf(
                "Calories" to calories,
                "Timestamp" to System.currentTimeMillis()
            )
            firestore.collection("Users")
                .document(uid)
                .collection("WorkoutHistory")
                .document(date)
                .set(data)
        }
    }
}
