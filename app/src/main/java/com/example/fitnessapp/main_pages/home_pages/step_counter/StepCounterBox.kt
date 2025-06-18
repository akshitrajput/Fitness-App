package com.example.fitnessapp.main_pages.home_pages.step_counter

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.min

@Composable
fun StepCounterBox(currentSteps: Int, goal: Int = 10000) {
    val progress = min(currentSteps / goal.toFloat(), 1f)
    val animatedProgress by animateFloatAsState(targetValue = progress, label = "step_progress")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp).clip(RoundedCornerShape(12.dp)).background(Color.LightGray).padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Daily Steps", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))
        CircularProgressIndicator(
            progress = animatedProgress,
            strokeWidth = 10.dp,
            modifier = Modifier.size(120.dp),
            color = Color(0xFF3F51B5),
            trackColor = Color.DarkGray
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text("$currentSteps / $goal", fontSize = 18.sp, color = Color.DarkGray)
    }
}
