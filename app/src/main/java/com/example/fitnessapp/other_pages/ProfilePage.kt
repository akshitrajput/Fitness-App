package com.example.fitnessapp.other_pages

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.fitnessapp.view_models.AuthViewModel
import com.example.fitnessapp.Constants
import com.example.fitnessapp.R
import com.example.fitnessapp.Routes
import com.example.fitnessapp.main_pages.home_pages.SignOut
import com.example.fitnessapp.ui.theme.AppFonts
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
@Composable
fun ProfilePage(
    modifier: Modifier = Modifier,
    navController: NavController,
    authViewModel: AuthViewModel
) {
    val context = LocalContext.current
    val userId = Firebase.auth.currentUser?.uid ?: return
    val db = Firebase.firestore

    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var isEditing by remember { mutableStateOf(false) }

    LaunchedEffect(userId) {
        db.collection("Users").document(userId).get().addOnSuccessListener { document ->
            name = document.getString("User Name") ?: ""
            age = document.getString("Date-of-Birth") ?: ""
            weight = document.get("Weight")?.toString() ?: ""
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Column {
            Text(
                text = "Profile Page",
                fontSize = 30.sp,
                fontFamily = AppFonts.Poppins,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 20.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.account),
                contentDescription = "Profile Image",
                modifier = Modifier.height(200.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

        }
        Column {
            Text(
                text = "Hello, $name",
                fontSize = 28.sp,
                fontFamily = AppFonts.Poppins,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            if (isEditing) {
                EditableTextField(label = "Your Age", value = age) { age = it }
                EditableTextField(label = "Current Weight", value = weight) { weight = it }

                Spacer(modifier = Modifier.height(10.dp))

                TextButton(
                    onClick = {
                        if (age.isNotEmpty() && weight.isNotEmpty()) {
                            db.collection("Users").document(userId)
                                .update(mapOf("Date-of-Birth" to age, "Weight" to weight.toInt()))
                                .addOnSuccessListener {
                                    Toast.makeText(context, "Profile updated!", Toast.LENGTH_SHORT).show()
                                    isEditing = false
                                }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFBEE3D5))
                        .clip(RoundedCornerShape(8.dp))
                        .padding(vertical = 10.dp)
                ) {
                    Text("Save", fontSize = 18.sp,fontFamily = AppFonts.Poppins,)
                }
            } else {
                Text(text = "Age: $age", fontSize = 21.sp, fontFamily = AppFonts.Poppins, modifier = Modifier.fillMaxWidth(),)
                Text(text = "Body Weight: $weight kg", fontSize = 21.sp,fontFamily = AppFonts.Poppins,modifier = Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(10.dp))

                TextButton(
                    onClick = { isEditing = true },
                    modifier = Modifier
                        .fillMaxWidth().clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFD3E3FC))
                        .padding(vertical = 10.dp)
                ) {
                    Text("Edit Details", fontWeight = FontWeight.Bold,fontSize = 18.sp,fontFamily = AppFonts.Poppins,)
                }
            }
        }

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
            modifier = Modifier
                .fillMaxWidth().clip(RoundedCornerShape(12.dp))
                .background(Color(0xFFBECADD))
                .padding(vertical = 10.dp)
        ) {
            Text("Sign Out", fontSize = 18.sp,fontWeight = FontWeight.Bold,fontFamily = AppFonts.Poppins,)
        }
    }
}

@Composable
fun EditableTextField(label: String, value: String, onValueChange: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
        Text(text = label, fontWeight = FontWeight.Medium, fontSize = 16.sp,fontFamily = AppFonts.Poppins,)
        androidx.compose.material3.OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
    }
}
