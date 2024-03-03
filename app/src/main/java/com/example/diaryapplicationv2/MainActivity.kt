package com.example.diaryapplicationv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.diaryapplicationv2.ui.theme.DiaryApplicationV2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiaryApplicationV2Theme {

            }
        }
    }
}


