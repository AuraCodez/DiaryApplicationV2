package com.example.diaryapplicationv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.diaryapplicationv2.navigation.SetupNavGraph
import com.example.diaryapplicationv2.ui.theme.DiaryApplicationV2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            DiaryApplicationV2Theme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}


