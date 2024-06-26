package com.example.diaryapplicationv2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.diaryapplicationv2.constants.Constant.WRITE_SCREEN_PARAM_KEY
import com.example.diaryapplicationv2.navigation.screens.authentication.AuthScreen
import com.stevdzasan.onetap.rememberOneTapSignInState

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = ApplicationScreen.Authentication.route) {
        composable(route = ApplicationScreen.Authentication.route) {
            val oneTapState = rememberOneTapSignInState()

            AuthScreen(
                oneTapState = oneTapState,
                loadingState = oneTapState.opened,
                onButtonClicked = {
                    oneTapState.open()
                }
            )
        }

        composable(route = ApplicationScreen.Home.route) {

        }

        composable(
            route = ApplicationScreen.Write.route,
            arguments = listOf(navArgument(name= WRITE_SCREEN_PARAM_KEY) {
                type = NavType.StringType
                nullable = true
                defaultValue = null
            })) {

        }
    }
}