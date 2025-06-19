package com.example.fitnessapp.main_pages.workout_pages

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavBackStackEntry
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.fitnessapp.ui.theme.AppFonts
import java.io.File

@Composable
fun ExerciseDetailPage(backStackEntry: NavBackStackEntry) {
    val exerciseId = backStackEntry.arguments?.getInt("exerciseId")
    val exercise = ExerciseRepository.exerciseList.find { it.id == exerciseId }

    if (exercise == null) {
        Text("Exercise not found")
        return
    }

    val context = LocalContext.current
    val videoPath = exercise.videoPath

    // Cache the video from assets
    val cachedVideoFile = remember {
        val afd = context.assets.openFd(exercise.videoPath)
        val tempFile = File.createTempFile("exo_video", ".mp4", context.cacheDir)
        tempFile.outputStream().use { output ->
            afd.createInputStream().copyTo(output)
        }
        tempFile
    }

    val player = remember {
        ExoPlayer.Builder(context).build().apply {
            val uri = Uri.fromFile(cachedVideoFile)
            val mediaItem = MediaItem.fromUri(uri)
            setMediaItem(mediaItem)
            repeatMode = ExoPlayer.REPEAT_MODE_ONE // Looping
            prepare()
            playWhenReady = true
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            player.release()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize().background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AndroidView(factory = {
            PlayerView(it).apply {
                useController = false
                this.player = player
            }
        }, modifier = Modifier
            .fillMaxWidth()
            .height(250.dp))


        Spacer(modifier = Modifier.height(16.dp))
        Text(exercise.name, fontFamily = AppFonts.Poppins, fontWeight = FontWeight.Bold, fontSize = 24.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Text(exercise.description, fontFamily = AppFonts.Poppins, fontWeight = FontWeight.SemiBold, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text("Calories per rep: ${exercise.caloriesPerRep}", fontFamily = AppFonts.Poppins, fontWeight = FontWeight.Normal, fontSize = 18.sp)
    }
}
