package com.example.fitnessapp.main_pages.workout_pages

data class Exercise(
    val id: Int,
    val name: String,
    val videoPath: String,
    val description: String,
    val caloriesPerRep: Float
)