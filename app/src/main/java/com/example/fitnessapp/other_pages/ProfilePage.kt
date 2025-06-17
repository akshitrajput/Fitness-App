package com.example.fitnessapp.other_pages

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fitnessapp.AuthViewModel
import com.example.fitnessapp.Constants
import com.example.fitnessapp.R
import com.example.fitnessapp.Routes
import com.example.fitnessapp.main_pages.SignOut
import com.example.fitnessapp.ui.theme.AppFonts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun ProfilePage(modifier: Modifier = Modifier,navController: NavController,authViewModel: AuthViewModel) {
    val context = LocalContext.current
    Column (
        modifier = Modifier.fillMaxSize().background(Color.White).padding(15.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(Modifier.height(30.dp))
        Row (
            modifier = Modifier.fillMaxWidth().padding(15.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text("Profile Page", fontFamily = AppFonts.Poppins, fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Image(painter = painterResource(R.drawable.settings_icon), contentDescription = "Settings Icon",
                modifier = Modifier.height(40.dp).clip(RoundedCornerShape(50.dp)).clickable {
                    navController.navigate(Routes.settings)
                })
        }
        Image(painter = painterResource(R.drawable.work_inprogress), contentDescription = "Profile Page",Modifier.height(240.dp))
        TextButton(
            onClick = {
                SignOut(context, Constants.WEB_CLIENT_ID) {
                    Toast.makeText(context, "Logout Successful", Toast.LENGTH_SHORT).show()
                }
                authViewModel.signout()
                navController.navigate(Routes.login) {
                    popUpTo(0) { inclusive = true }
                    launchSingleTop = true
                }
            },
            modifier = Modifier.fillMaxWidth().padding(20.dp).background(Color(0xFFBECADD)).clip(
                RoundedCornerShape(8.dp)
            )
        ) {
            Text("Sign Out")
        }

    }
}



