package com.example.fitnessapp.main_pages.home_pages

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fitnessapp.main_pages.workout_pages.WorkoutViewModel
import androidx.navigation.NavController
import com.example.fitnessapp.view_models.AuthViewModel
import com.example.fitnessapp.R
import com.example.fitnessapp.Routes
import com.example.fitnessapp.ui.theme.AppFonts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    authViewModel: AuthViewModel,
    navController: NavController
) {
    val context = LocalContext.current
    val workoutViewModel: WorkoutViewModel = viewModel()
    val caloriesBurned by workoutViewModel.totalCaloriesBurned.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Text(
                "Keep the Hunger,\nStay fit!",
                fontFamily = AppFonts.Poppins,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
            )
            Box(modifier = Modifier.padding(top = 5.dp)) {
                Image(
                    painter = painterResource(R.drawable.account),
                    contentDescription = "User Image",
                    modifier = Modifier
                        .height(50.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .clickable { navController.navigate(Routes.profile) }
                        .background(color = Color.Transparent)
                )
            }
        }
        Spacer(Modifier.height(50.dp))
        Text(text = "Welcome to Home Page", color = Color.Black)
        Spacer(Modifier.height(20.dp))

        Text(
            text = "Total Calories Burned: ${caloriesBurned.toInt()} kcal",
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFF3A7D44)
        )
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


