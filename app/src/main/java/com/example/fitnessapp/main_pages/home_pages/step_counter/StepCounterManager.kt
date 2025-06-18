package com.example.fitnessapp.main_pages.home_pages.step_counter

import android.content.Context
import android.content.SharedPreferences
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class StepCounterManager(context: Context) : SensorEventListener {

    private val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val stepSensor: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

    private val prefs: SharedPreferences =
        context.getSharedPreferences("step_prefs", Context.MODE_PRIVATE)

    private val _stepsToday = MutableStateFlow(0)
    val stepsToday: StateFlow<Int> get() = _stepsToday

    private var initialSteps: Int
        get() = prefs.getInt("initialSteps", -1)
        set(value) = prefs.edit().putInt("initialSteps", value).apply()

    private var lastResetDay: Int
        get() = prefs.getInt("lastResetDay", -1)
        set(value) = prefs.edit().putInt("lastResetDay", value).apply()

    init {
        val today = getCurrentDayOfYear()
        if (lastResetDay != today) {
            initialSteps = -1
            lastResetDay = today
        }
        registerListener()
    }

    private fun getCurrentDayOfYear(): Int {
        return java.util.Calendar.getInstance().get(java.util.Calendar.DAY_OF_YEAR)
    }

    private fun registerListener() {
        stepSensor?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_UI)
        }
    }

    fun unregister() {
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        val steps = event?.values?.firstOrNull()?.toInt() ?: return

        if (initialSteps == -1) {
            initialSteps = steps
        }

        val todaySteps = steps - initialSteps
        _stepsToday.value = todaySteps
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
}
