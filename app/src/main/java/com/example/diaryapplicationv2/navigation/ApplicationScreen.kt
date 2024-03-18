package com.example.diaryapplicationv2.navigation

import com.example.diaryapplicationv2.constants.Constant.WRITE_SCREEN_PARAM_KEY

sealed class ApplicationScreen(val route: String) {
    object Authentication: ApplicationScreen(route="auth_screen")
    object Home: ApplicationScreen(route="home_screen")
    object Write: ApplicationScreen(route="write_screen?$WRITE_SCREEN_PARAM_KEY={$WRITE_SCREEN_PARAM_KEY}") {
        fun sendDiaryId(diaryId: String) = "write_screen?$WRITE_SCREEN_PARAM_KEY=$diaryId"
    }

}