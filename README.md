# Fitness-App
A smart fitness tracking Android app that helps users manage workouts, monitor diet, track steps, heart points, and body metrics — built using Kotlin, Jetpack, and Firebase.



## 🌐 Socials:
[![LinkedIn](https://img.shields.io/badge/LinkedIn-%230077B5.svg?logo=linkedin&logoColor=white)](https://linkedin.com/in/akshitrajput) [![X](https://img.shields.io/badge/X-black.svg?logo=X&logoColor=white)](https://x.com/akshitrajput_) [![email](https://img.shields.io/badge/Email-D14836?logo=gmail&logoColor=white)](mailto:rajput.akshit0810@gmail.com) 

# 💻 Tech Stack:
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white) ![Firebase](https://img.shields.io/badge/firebase-%23039BE5.svg?style=for-the-badge&logo=firebase) ![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)


Fitness-App 🏋️‍♂️🍽️🚶‍♀️
A smart fitness tracking Android app that helps users manage workouts, monitor diet, track steps, heart points, and body metrics — built using Kotlin, Jetpack, and Firebase.

📱 Overview
Fitness-App is a comprehensive health and wellness Android application designed to help users stay on top of their fitness goals. It allows users to log meals, track workouts and repetitions, monitor step count using sensor data, and get a complete view of their calorie intake vs burn — all with a clean, modern UI powered by Jetpack Compose.

✨ Key Features
🏃 Step Tracking: Real-time pedometer that tracks user steps using sensor and ACTIVITY_RECOGNITION permissions.

🍱 Meal Logging: Add meals and drinks to get automatic calorie and macronutrient calculations (carbs, protein, fat).

💪 Workout Tracker: Choose exercises, enter reps, and calculate calories burned. Includes exercise guides and routine planning.

📊 Home Dashboard:

Total calories consumed and burned

Live step count

Macro breakdown shown with animated progress bars

🔐 Secure Google Sign-In: Firebase Authentication with session state management.

☁️ Persistent Storage:

Firebase Firestore: Cloud storage of user metrics and activity

DataStore: Local state management using ViewModel + ViewModelFactory

🧭 Smooth Navigation: Jetpack Compose Navigation with context and auth-based routing.

⚙️ Tech Stack
Layer	Technology
Language	Kotlin
UI	Jetpack Compose
Architecture	MVVM (Model-View-ViewModel)
Navigation	Jetpack Navigation (Compose Destinations)
Database	Firebase Firestore
Auth	Firebase Auth (Google Sign-In)
Local Storage	DataStore Preferences
Tools	Android Studio, GitHub

📌 Architecture Overview
scss
Copy
Edit
UI Layer (Jetpack Compose Screens)
   ↓
ViewModel (State Handling & Logic)
   ↓
Data Layer (DataStore + Firebase Firestore)
   ↓
Firebase Auth (User Identity & Session)
MVVM Pattern for scalability and testability

AuthViewModel tracks and routes based on login state

Composable Navigation for smooth screen transitions

Sync between cloud and local is seamless and real-time

🔐 Permissions Used
ACTIVITY_RECOGNITION: For detecting steps via the pedometer sensor

Internet & Network Access: For Firebase communication

Sensors: For tracking physical activity

🛠️ Getting Started
Clone the repository

bash
Copy
Edit
git clone https://github.com/your-username/Fitness-App.git
Open in Android Studio

Connect your Firebase project and add your google-services.json

Enable the following in Firebase Console:

Authentication (Google)

Firestore Database

Run the app on a device/emulator with motion sensor support

📸 UI Previews
(Insert screenshots or screen recordings of Home, Meal, Workout, and Profile pages here)

🚀 Future Enhancements
Integration with Google Fit for heart points and deeper activity metrics

AI/ML-based personalized meal and workout suggestions

Notification reminders and goal setting

Wear OS & smartwatch support
