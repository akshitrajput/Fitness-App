package com.example.fitnessapp.main_pages.home_pages.step_counter

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.StateFlow

class StepViewModel(application: Application) : AndroidViewModel(application) {

    private val stepManager = StepCounterManager(application.applicationContext)

    val stepsToday: StateFlow<Int> = stepManager.stepsToday

    override fun onCleared() {
        super.onCleared()
        stepManager.unregister()
    }
}
