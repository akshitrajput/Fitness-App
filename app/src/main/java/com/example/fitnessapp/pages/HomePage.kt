package com.example.fitnessapp.pages

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.fitnessapp.AuthState
import com.example.fitnessapp.AuthViewModel
import com.example.fitnessapp.Constants
import com.example.fitnessapp.NavBar_Items
import com.example.fitnessapp.Routes
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


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
        NavBar_Items("Home", Icons.Default.Home),
        NavBar_Items("WorkOut", Icons.Default.Home),
        NavBar_Items("Meal", Icons.Default.Home),
    )

    Scaffold (
        modifier = Modifier.fillMaxSize()
    , bottomBar = {
        NavigationBar {
            navItemsList.forEachIndexed { index, navItem ->
                NavigationBarItem(selected = true, onClick = {}, icon = { Icon(imageVector = navItem.icon, contentDescription = "Icon") },
                    label = { Text(navItem.label) })
            }
        }
        }){ innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding),authViewModel)
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier,authViewModel: AuthViewModel) {
    val context = LocalContext.current
    val authState = authViewModel.authState.observeAsState()
    Column (
        modifier = Modifier.fillMaxSize().background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        TextButton(
            onClick = {
                SignOut(context, Constants.WEB_CLIENT_ID) {
                    Toast.makeText(context,"Logout Successful",Toast.LENGTH_SHORT).show()
                }
                authViewModel.signout()

            }
        ) {
            Text("SignOut")
        }
    }
}

fun SignOut(context: Context, webClientId: String, onComplete: () -> Unit) {
    Firebase.auth.signOut()
    val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(webClientId)
        .requestEmail()
        .build()
    val googleSignInClient = GoogleSignIn.getClient(context, googleSignInOptions)
    googleSignInClient.signOut().addOnCompleteListener{
        onComplete()
    }
}




