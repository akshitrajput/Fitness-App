package com.example.fitnessapp.intro_pages

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
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fitnessapp.R
import com.example.fitnessapp.Routes
import com.example.fitnessapp.ui.theme.AppFonts
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun AskMetricsPage(navController: NavController) {
    val context = LocalContext.current
    val userId = Firebase.auth.currentUser?.uid

    var selectedGender by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(14.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(R.drawable.img_5),
            modifier = Modifier.height(250.dp).width(250.dp),
            contentDescription = "Complete Profile Image"
        )
        Text(
            "Let's complete your profile",
            fontWeight = FontWeight.Bold,
            fontFamily = AppFonts.Poppins,
            fontSize = 22.sp,
            color = Color.Black
        )
        Spacer(Modifier.height(2.dp))
        Text(
            "It will help us to know more about you!",
            fontFamily = AppFonts.Poppins,
            fontSize = 14.sp,
            color = Color.DarkGray
        )
        Spacer(Modifier.height(20.dp))

        Column (
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            GenderSelection(
                selectedGender = selectedGender,
                onGenderSelected = { selectedGender = it }
            )
            Spacer(Modifier.height(15.dp))
            CustomTextFieldWithUnit(
                value = name,
                onValueChange = { name = it },
                placeholder = "Your First Name",
                leadingIcon = {
                    Icon(painter = painterResource(R.drawable.account), contentDescription = null, tint = Color.Gray, modifier = Modifier.height(20.dp))
                },
            )
            Spacer(Modifier.height(15.dp))
            CustomTextFieldWithUnit(
                value = age,
                onValueChange = { age = it },
                placeholder = "Your Age in years",
                leadingIcon = {
                    Icon(painter = painterResource(R.drawable.calendar_icon), contentDescription = null, tint = Color.Gray, modifier = Modifier.height(20.dp))
                }
            )
            Spacer(Modifier.height(15.dp))
            CustomTextFieldWithUnit(
                value = height,
                onValueChange = { height = it },
                placeholder = "Height (centimeters)",
                leadingIcon = {
                    Icon(painter = painterResource(R.drawable.height_icon), contentDescription = null, tint = Color.Gray, modifier = Modifier.height(20.dp))
                }
            )
            Spacer(Modifier.height(15.dp))
            CustomTextFieldWithUnit(
                value = weight,
                onValueChange = { weight = it },
                placeholder = "Weight (Kilograms)",
                leadingIcon = {
                    Icon(painter = painterResource(R.drawable.weight_icon), contentDescription = null, tint = Color.Gray, modifier = Modifier.height(20.dp))
                }
            )
        }

        Spacer(Modifier.height(30.dp))
        Button(onClick = {
            if (name.isNotEmpty() && age.isNotEmpty() && weight.isNotEmpty() && height.isNotEmpty() && userId != null) {
                val db = Firebase.firestore
                db.collection("Users").document(userId).set(
                    hashMapOf(
                        "User Name" to name,
                        "Gender" to selectedGender,
                        "Date-of-Birth" to age,
                        "Weight" to weight.toInt(),
                        "Height" to height.toInt()
                    )
                ).addOnSuccessListener {
                    Toast.makeText(context, "Metrics saved!", Toast.LENGTH_SHORT).show()
                    navController.navigate(Routes.home) {
                        popUpTo(Routes.metrics) { inclusive = true }
                    }
                }.addOnFailureListener {
                    Toast.makeText(context, "Failed to save metrics", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        },
            modifier = Modifier.fillMaxWidth(0.9f),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF8697b2))) {
            Text("Save Details", fontFamily = AppFonts.Poppins, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}


@Composable
fun CustomTextFieldWithUnit(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    unitLabel: String? = null,
    leadingIcon: @Composable (() -> Unit)
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder, fontFamily = AppFonts.Poppins, fontSize = 15.sp, fontWeight = FontWeight.Normal) },
        leadingIcon = leadingIcon,
        trailingIcon = unitLabel?.let {
            {
                Text(
                    text = it,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        },
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFF2F2F2),
            unfocusedContainerColor = Color(0xFFF2F2F2),
            disabledContainerColor = Color(0xFFF2F2F2),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            cursorColor = Color.Black,
            focusedTextColor = Color.Black
        ),
        modifier = Modifier.fillMaxWidth()
    )
}


@Composable
fun GenderSelection(
    selectedGender: String,
    onGenderSelected: (String) -> Unit
) {
    val genders = listOf("Male", "Female")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF2F2F2), shape = RoundedCornerShape(8.dp))
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        genders.forEach { gender ->
            val isSelected = gender == selectedGender

            Text(
                text = gender,
                fontFamily = AppFonts.Poppins,
                fontSize = 16.sp,
                color = if (isSelected) Color.White else Color.Gray,
                modifier = Modifier
                    .background(
                        color = if (isSelected) Color(0xFF8697b2) else Color.Transparent,
                        shape = RoundedCornerShape(6.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clickable { onGenderSelected(gender) }
            )
        }
    }
}