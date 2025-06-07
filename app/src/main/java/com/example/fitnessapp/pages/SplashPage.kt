package com.example.fitnessapp.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fitnessapp.AuthState
import com.example.fitnessapp.AuthViewModel
import com.example.fitnessapp.Routes
import com.example.fitnessapp.ui.theme.AppFonts
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, authViewModel: AuthViewModel) {
    val authState = authViewModel.authState.observeAsState()
    val isNavigated = remember { mutableStateOf(false) }

    LaunchedEffect(authState.value) {
        delay(600)

        if (!isNavigated.value) {
            when (authState.value) {
                is AuthState.Authenticated -> {
                    navController.navigate(Routes.home) {
                        popUpTo(Routes.splash) { inclusive = true }
                        launchSingleTop = true
                    }
                }
                else -> {
                    navController.navigate(Routes.getStarted) {
                        popUpTo(Routes.splash) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            }
            isNavigated.value = true
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF6C7894))
            .padding(26.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Fitness App",
            fontFamily = AppFonts.Poppins,
            fontSize = 42.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}
