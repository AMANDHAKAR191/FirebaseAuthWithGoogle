package com.aman.firebaseauthwithgoogle.navigation

import com.aman.firebaseauthwithgoogle.core.Constants.AUTH_SCREEN
import com.aman.firebaseauthwithgoogle.core.Constants.PROFILE_SCREEN

sealed class Screen(val route: String) {
    object AuthScreen: Screen(AUTH_SCREEN)
    object ProfileScreen: Screen(PROFILE_SCREEN)
}