package com.example.fitnessapp.main_pages.home_pages

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalorieIntakeProgressBox(
    modifier: Modifier = Modifier,
    caloriesIntake: Int,
    goal: Int = 2000
) {
    val animatedProgress by animateFloatAsState(
        targetValue = (caloriesIntake / goal.toFloat()).coerceIn(0f, 1f),
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing),
        label = "Calories Intake Progress"
    )

    Box(
        modifier = modifier
            .size(160.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFe8f5e9))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            progress = animatedProgress,
            strokeWidth = 10.dp,
            color = Color(0xFF43A047),
            modifier = Modifier.fillMaxSize()
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "$caloriesIntake kcal",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black
            )
            Text(
                text = "Consumed",
                fontSize = 14.sp,
                color = Color.DarkGray
            )
        }
    }
}
