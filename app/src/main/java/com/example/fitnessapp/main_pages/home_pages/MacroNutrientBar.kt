package com.example.fitnessapp.main_pages.home_pages


import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.min

@Composable
fun MacroNutrientBar(
    label: String,
    amount: Int,
    goal: Int,
    color: Color
) {
    val percentage = min(amount / goal.toFloat(), 1f)
    val animatedWidth by animateDpAsState(
        targetValue = (percentage * 200).dp, // bar max width = 200dp
        animationSpec = tween(durationMillis = 1000),
        label = "Animated Macro Width"
    )

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 6.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "$label:",
                fontSize = 16.sp,
                modifier = Modifier.width(70.dp)
            )
            Box(
                modifier = Modifier
                    .height(20.dp)
                    .width(animatedWidth)
                    .clip(RoundedCornerShape(8.dp))
                    .background(color)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "$amount g", fontSize = 14.sp)
        }
    }
}
