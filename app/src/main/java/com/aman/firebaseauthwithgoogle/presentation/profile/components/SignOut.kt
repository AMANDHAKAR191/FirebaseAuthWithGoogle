package com.aman.firebaseauthwithgoogle.presentation.profile.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.aman.firebaseauthwithgoogle.components.ProgressBar
import com.aman.firebaseauthwithgoogle.core.Utils.Companion.print
import com.aman.firebaseauthwithgoogle.domain.model.Response.*
import com.aman.firebaseauthwithgoogle.presentation.profile.ProfileViewModel

@Composable
fun SignOut(
    viewModel: ProfileViewModel = hiltViewModel(),
    navigateToAuthScreen: (signedOut: Boolean) -> Unit
) {
    when(val signOutResponse = viewModel.signOutResponse) {
        is Loading -> ProgressBar()
        is Success -> signOutResponse.data?.let { signedOut ->
            LaunchedEffect(signedOut) {
                navigateToAuthScreen(signedOut)
            }
        }
        is Failure -> LaunchedEffect(Unit) {
            print(signOutResponse.e)
        }
    }
}