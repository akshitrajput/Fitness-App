package com.example.fitnessapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fitnessapp.IntroPages.HomePage
import com.example.fitnessapp.IntroPages.LoginPage
import com.example.fitnessapp.IntroPages.SignupPage
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.IntroPages.GetStartedPage
import com.example.fitnessapp.IntroPages.SplashScreen


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