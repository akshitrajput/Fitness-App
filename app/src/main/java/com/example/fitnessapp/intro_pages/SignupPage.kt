package com.example.fitnessapp.intro_pages

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextButton
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.fitnessapp.view_models.AuthState
import com.example.fitnessapp.view_models.AuthViewModel
import com.example.fitnessapp.Constants
import com.example.fitnessapp.R
import com.example.fitnessapp.Routes
import com.example.fitnessapp.ui.theme.AppFonts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun SignupPage(modifier: Modifier = Modifier,navController: NavController,authViewModel: AuthViewModel) {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }
    fun validateInputs(email: String, password: String): Boolean {
        emailError = if (email.isBlank()) "Email cannot be empty"
        else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) "Invalid email address"
        else null

        passwordError = if (password.isBlank()) "Password cannot be empty"
        else if (password.length < 6) "Password must be at least 6 characters"
        else null

        return emailError == null && passwordError == null
    }

    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current
    val googleSignInOptions = remember {
        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(Constants.WEB_CLIENT_ID)
            .requestEmail()
            .build()
    }
    val googleSignInClient = remember {
        GoogleSignIn.getClient(context,googleSignInOptions)
    }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try{
            val account = task.result
            val credential = GoogleAuthProvider.getCredential(account.idToken,null)
            Firebase.auth.signInWithCredential(credential)
                .addOnCompleteListener { task->
                    if (task.isSuccessful) {
                        Toast.makeText(context,"Google Sign-in Successful",Toast.LENGTH_SHORT).show()
                        authViewModel.checkAuthState()
                        navController.navigate(Routes.home) {
                            popUpTo(Routes.login) {inclusive = true}
                        }
                    } else{
                        Toast.makeText(context,"Google Sign-in Failed",Toast.LENGTH_SHORT).show()
                    }
                }
        } catch (e: Exception) {
            Toast.makeText(context,"Google Sign-in Failed: ${e.message}",Toast.LENGTH_SHORT).show()
        }
    }

    LaunchedEffect(authState.value) {
        when(authState.value) {
            is AuthState.Authenticated -> {
                val userId = Firebase.auth.currentUser?.uid ?: return@LaunchedEffect
                authViewModel.checkIfMetricsExist(userId) { exists ->
                    if (exists) {
                        navController.navigate(Routes.home) {
                            popUpTo(Routes.signup) { inclusive = true }
                        }
                    } else {
                        navController.navigate(Routes.metrics) {
                            popUpTo(Routes.signup) { inclusive = true }
                        }
                    }
                }
            }
            is AuthState.Error -> Toast.makeText(context,
                (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }
    if (authState.value is AuthState.Loading) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator()
            Spacer(modifier = Modifier.height(16.dp))
            Text("Signing in...", fontFamily = AppFonts.Poppins)
        }
        return
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
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = AppFonts.Poppins
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                emailError = null
            },
            label = {
                Text("Enter email Address", fontFamily = AppFonts.Poppins)
            },
            isError = emailError != null,
            supportingText = {
                if(emailError != null) Text(emailError ?: "", color = Color.Red)
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                passwordError = null
            },
            label = {
                Text("Create Password", fontFamily = AppFonts.Poppins)
            },
            isError = passwordError != null,
            supportingText = {
                if(passwordError != null) Text(passwordError ?: "",color = Color.Red)
            },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = {
                if (validateInputs(email, password)) {
                    authViewModel.signup(email, password)
                }
            },
            modifier = Modifier.fillMaxWidth(0.4f),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C7894))
        ) {
            Text(
                text = "Sign In",
                fontSize = 20.sp,
                fontFamily = AppFonts.Poppins,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(2.dp))

        TextButton(
            onClick = {
                navController.navigate(Routes.login) {
                    popUpTo(Routes.signup) { inclusive = true}
                }
            }
        ) {
            Text(text = "Already have an account, Login", fontFamily = AppFonts.Poppins)
        }
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Or", fontSize = 15.sp, fontFamily = AppFonts.Poppins)
        Spacer(modifier = Modifier.height(12.dp))

        GoogleSignInButton(googleSignInClient,launcher)
    }
}

@Composable
fun GoogleSignInButton(googleSignInClient: GoogleSignInClient,launcher: ActivityResultLauncher<Intent>) {
    AndroidView(modifier = Modifier.fillMaxWidth(0.6f).height(48.dp),
        factory = { context->
            SignInButton(context).apply {
                setSize(SignInButton.SIZE_WIDE)
                setOnClickListener{
                    val signInIntent = googleSignInClient.signInIntent
                    launcher.launch(signInIntent)
                }
            }

        })
}