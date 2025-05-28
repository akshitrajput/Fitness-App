package com.example.fitnessapp.pages

import android.net.Uri
import android.util.Log
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.navigation.NavController
import com.example.fitnessapp.AuthViewModel
import com.example.fitnessapp.poppinsFontFamily


@Composable
fun GetStartedPage(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {
    val context = LocalContext.current

    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            val videoUri = Uri.parse("asset:///video4.mp4")
            val mediaItem = MediaItem.fromUri(videoUri)
            setMediaItem(mediaItem)
            playWhenReady = true
            repeatMode = ExoPlayer.REPEAT_MODE_ALL
            prepare()
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize().background(Color.White)
            .padding(45.dp).offset(y = 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Fitness App",
            fontSize = 50.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp)
        )

        // ExoPlayer Composable
        AndroidView(
            factory = {
                PlayerView(it).apply {
                    player = exoPlayer
                    useController = false
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        700
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
        Button(
            onClick = { navController.navigate("signup") },
            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(100.dp)),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF6C7894))
        ) {
            Text(text = "Get Started ➝", fontSize = 28.sp, fontFamily = poppinsFontFamily, color = Color.White)
        }
    }
}