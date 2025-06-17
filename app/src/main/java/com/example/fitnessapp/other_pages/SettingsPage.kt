package com.example.fitnessapp.other_pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnessapp.R
import com.example.fitnessapp.ui.theme.AppFonts

@Composable
fun SettingsPage(modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier.fillMaxSize().background(Color.White).padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Settings Page", fontSize = 22.sp, fontWeight = FontWeight.Bold, fontFamily = AppFonts.Poppins)
        Image(painter = painterResource(R.drawable.work_inprogress), contentDescription = "Settings Page",Modifier.height(180.dp))
    }
}