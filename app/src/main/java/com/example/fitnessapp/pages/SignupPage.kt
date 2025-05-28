package com.example.fitnessapp.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.fitnessapp.AuthViewModel
import com.example.fitnessapp.R
import com.example.fitnessapp.poppinsFontFamily


@Composable
fun SignupPage(modifier: Modifier = Modifier,navController: NavController,authViewModel: AuthViewModel) {
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxHeight()
            .fillMaxWidth()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(180.dp),
            painter = painterResource(R.drawable.signin_image),
            contentDescription = "Image Bg",
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Sign up with our App",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = poppinsFontFamily
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text("Enter email Address", fontFamily = poppinsFontFamily)
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text("Create Password", fontFamily = poppinsFontFamily)
            }, visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = {
                Log.d("MainActivity.kt", "Login Successful\nEmail-id : $email\nPassword : $password")
            },
            modifier = Modifier.fillMaxWidth(0.4f),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C7894))
        ) {
            Text(
                text = "Sign In",
                fontSize = 20.sp,
                fontFamily = poppinsFontFamily,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(2.dp))

        TextButton(
            onClick = {
                navController.navigate("login")
            }
        ) {
            Text(text = "Already have an account, Login", fontFamily = poppinsFontFamily)
        }
        Spacer(modifier = Modifier.height(80.dp))
        Text(text = "Or sign in with", fontSize = 16.sp, fontFamily = poppinsFontFamily)
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(.8f).padding(horizontal = 25.dp)
        ) {
            Image(
                modifier = Modifier.size(40.dp).clickable { },
                painter = painterResource(R.drawable.google_logo),
                contentDescription = "With Google",
                contentScale = ContentScale.Fit
            )
            Image(
                modifier = Modifier.size(40.dp).clickable { },
                painter = painterResource(R.drawable.facebook_logo),
                contentDescription = "With Facebook",
                contentScale = ContentScale.Fit
            )
            Image(
                modifier = Modifier.size(40.dp).clickable { },
                painter = painterResource(R.drawable.chrome_logo),
                contentDescription = "With Chrome",
                contentScale = ContentScale.Fit
            )
            Image(
                modifier = Modifier.size(50.dp).clickable { },
                painter = painterResource(R.drawable.twitter_logo),
                contentDescription = "With Twitter",
                contentScale = ContentScale.Fit)
        }

    }

}