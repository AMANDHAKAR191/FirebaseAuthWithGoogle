package com.aman.firebaseauthwithgoogle.presentation.auth.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.aman.firebaseauthwithgoogle.components.ProgressBar
import com.aman.firebaseauthwithgoogle.core.Utils.Companion.print
import com.aman.firebaseauthwithgoogle.domain.model.Response.*
import com.aman.firebaseauthwithgoogle.presentation.auth.AuthViewModel

@Composable
fun SignInWithGoogle(
    viewModel: AuthViewModel = hiltViewModel(),
    navigateToHomeScreen: (signedIn: Boolean) -> Unit
) {
    when(val signInWithGoogleResponse = viewModel.signInWithGoogleResponse) {
        is Loading -> ProgressBar()
        is Success -> signInWithGoogleResponse.data?.let { signedIn ->
            LaunchedEffect(signedIn) {
                navigateToHomeScreen(signedIn)
            }
        }
        is Failure -> LaunchedEffect(Unit) {
            print(signInWithGoogleResponse.e)
        }
    }
}