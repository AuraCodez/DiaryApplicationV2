package com.example.diaryapplicationv2.navigation.screens.authentication

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.diaryapplicationv2.R
import com.example.diaryapplicationv2.constants.Constant.CLIENT_ID
import com.example.diaryapplicationv2.navigation.component.GoogleLogo
import com.stevdzasan.onetap.OneTapSignInState
import com.stevdzasan.onetap.OneTapSignInWithGoogle

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AuthScreen(loadingState: Boolean,
               oneTapState: OneTapSignInState,
               onButtonClicked: () -> Unit) {
    Scaffold(
        content = {
            AuthContent(loadingState, onButtonClicked)
        }
    )
    OneTapSignInWithGoogle(
        state = oneTapState,
        clientId = CLIENT_ID,
        onTokenIdReceived = {tokenId ->
                            Log.d("AuthStuff", tokenId)
        },
        onDialogDismissed = {message ->
            Log.d("AuthStuff", message)
        }
    )
}

@Composable
fun AuthContent(
    loadingState: Boolean,
    onButtonClicked: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .weight(9f)
                .fillMaxWidth()
                .padding(all = 40.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .weight(10f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.size(120.dp),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Google Logo"
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Authentication",
                    fontSize = MaterialTheme.typography.titleLarge.fontSize
                )
                Text(
                    text = "Diary Application",
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                )
            }

            Column(
                modifier = Modifier.weight(weight = 3f),
                verticalArrangement = Arrangement.Bottom
            ) {
                GoogleLogo(
                    loadingState = loadingState,
                    onClick = onButtonClicked
                )
            }
        }

    }
}