package com.example.fitnessapp.main_pages

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.fitnessapp.view_models.AuthState
import com.example.fitnessapp.view_models.AuthViewModel
import com.example.fitnessapp.main_pages.home_pages.HomeScreenContent
import com.example.fitnessapp.NavBar_Items
import com.example.fitnessapp.R
import com.example.fitnessapp.Routes
import com.example.fitnessapp.main_pages.meal_pages.MealPage
import com.example.fitnessapp.main_pages.meal_pages.MealViewModel
import com.example.fitnessapp.main_pages.meal_pages.MealViewModelFactory
import com.example.fitnessapp.main_pages.workout_pages.WorkoutPage
import com.example.fitnessapp.ui.theme.AppFonts


@Composable
fun HomePage(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {
    val context = LocalContext.current
    val activity = context as? Activity
    val authState = authViewModel.authState.observeAsState()

    BackHandler {
        activity?.finish()
    }
    LaunchedEffect(authState.value) {
        when(authState.value) {
            is AuthState.Unauthenticated -> {
                navController.navigate(Routes.login) {
                    popUpTo(Routes.home) { inclusive = true }
                    launchSingleTop = true
                }
            }
            else -> Unit
        }
    }
    val navItemsList = listOf(
        NavBar_Items("Home", painterResource(id = R.drawable.app_home_icon)),
        NavBar_Items("WorkOut", painterResource(id = R.drawable.app_workout_icon)),
        NavBar_Items("Meal", painterResource(id = R.drawable.app_meal_icon)),
    )
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold (
        modifier = Modifier.fillMaxSize()
        , bottomBar = {
        NavigationBar (
            modifier = Modifier.height(100.dp),
            tonalElevation = 1.dp,
            containerColor = Color(0xFFBECADD)
        ) {
            navItemsList.forEachIndexed {index,navItem ->
                NavigationBarItem(
                    selected = selectedIndex == index,
                    onClick = {selectedIndex = index},
                    icon = {
                        BounceIcon(
                            painter = navItem.icon,
                            selected = selectedIndex == index
                        )
                    },
                    label = {
                        Text(text = navItem.label, fontFamily = AppFonts.Poppins, fontSize = 14.sp)
                    }
                )
            }
        }
    }
    ){ innerPadding ->
        ContentScreen(
            modifier = Modifier.padding(innerPadding)
            ,authViewModel = authViewModel
            ,selectedIndex = selectedIndex,
            navController = navController)
    }
}



@Composable
fun ContentScreen(modifier: Modifier = Modifier, authViewModel: AuthViewModel, selectedIndex: Int, navController: NavController) {
    val context = LocalContext.current
    val authState = authViewModel.authState.observeAsState()
    val mealViewModel: MealViewModel = viewModel(factory = MealViewModelFactory(context))
    when (selectedIndex) {
        0 -> HomeScreenContent(modifier, authViewModel, navController,mealViewModel)
        1 -> WorkoutPage(navController)
        2 -> MealPage(mealViewModel)
    }
}

@Composable
fun BounceIcon(painter: Painter, selected: Boolean) {
    val scale = remember { Animatable(1f) }
    LaunchedEffect(selected) {
        if (selected) {
            scale.animateTo(
                targetValue = 1.2f,
                animationSpec = tween(150, easing = FastOutLinearInEasing)
            )
            scale.animateTo(
                targetValue = 1f,
                animationSpec = tween(150, easing = LinearOutSlowInEasing)
            )
        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(48.dp)
            .scale(scale.value)
            .clip(RoundedCornerShape(50))
            .then(
                if (selected) Modifier
                    .shadow(2.dp, RoundedCornerShape(50))
                    .border(1.dp, Color.LightGray, RoundedCornerShape(50))
                    .background(Color.White)
                else Modifier
            )
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.size(32.dp)
        )
    }
}
