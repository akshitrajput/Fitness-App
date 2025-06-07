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
import com.example.fitnessapp.pages.SplashScreen


@Composable
fun AppNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.splash, builder = {
        composable(Routes.login) {
            LoginPage(modifier,navController,authViewModel)
        }
        composable(Routes.signup) {
            SignupPage(modifier,navController,authViewModel)
        }
        composable(Routes.home) {
            HomePage(modifier,navController,authViewModel)
        }
        composable(Routes.getStarted) {
            GetStartedPage(modifier,navController,authViewModel)
        }
        composable(Routes.splash) {
            SplashScreen(navController,authViewModel)
        }
    }
    )
}