package com.example.fitnessapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fitnessapp.pages.HomePage
import com.example.fitnessapp.pages.LoginPage
import com.example.fitnessapp.pages.SignupPage
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.pages.GetStartedPage


@Composable
fun AppNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "getStarted", builder = {
        composable("login") {
            LoginPage(modifier,navController,authViewModel)
        }
        composable("signup") {
            SignupPage(modifier,navController,authViewModel)
        }
        composable("home") {
            HomePage(modifier,navController,authViewModel)
        }
        composable("getStarted") {
            GetStartedPage(modifier,navController,authViewModel)
        }
    }
    )
}