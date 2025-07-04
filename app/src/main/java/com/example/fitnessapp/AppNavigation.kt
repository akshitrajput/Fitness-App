package com.example.fitnessapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fitnessapp.main_pages.HomePage
import com.example.fitnessapp.intro_pages.LoginPage
import com.example.fitnessapp.intro_pages.SignupPage
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp.intro_pages.AskMetricsPage
import com.example.fitnessapp.intro_pages.GetStartedPage
import com.example.fitnessapp.intro_pages.SplashScreen
import com.example.fitnessapp.main_pages.workout_pages.ExerciseDetailPage
import com.example.fitnessapp.main_pages.workout_pages.ExploreExercisesPage
import com.example.fitnessapp.main_pages.workout_pages.RoutinePage
import com.example.fitnessapp.main_pages.workout_pages.WorkoutPage
import com.example.fitnessapp.other_pages.ProfilePage
import com.example.fitnessapp.view_models.AuthViewModel
import androidx.navigation.NavType
import androidx.navigation.navArgument



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
        composable(Routes.profile) {
            ProfilePage(modifier,navController,authViewModel)
        }
        composable(Routes.metrics) {
            AskMetricsPage(navController)
        }
        composable(Routes.routines) {
            RoutinePage(navController)
        }
        composable(Routes.exploreExercises) {
            ExploreExercisesPage(navController)
        }
        composable(Routes.workout) {
            WorkoutPage(navController)
        }
        composable(
            route = "${Routes.exerciseDetail}/{exerciseId}",
            arguments = listOf(navArgument("exerciseId") { type = NavType.IntType })
        ) { backStackEntry ->
            ExerciseDetailPage(backStackEntry)
        }
    }
    )
}