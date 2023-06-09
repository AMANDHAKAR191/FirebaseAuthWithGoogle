package com.aman.firebaseauthwithgoogle.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.aman.firebaseauthwithgoogle.navigation.Screen.AuthScreen
import com.aman.firebaseauthwithgoogle.navigation.Screen.ProfileScreen
import com.aman.firebaseauthwithgoogle.presentation.auth.AuthScreen
import com.aman.firebaseauthwithgoogle.presentation.profile.ProfileScreen

@Composable
@ExperimentalAnimationApi
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AuthScreen.route,
        enterTransition = {EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        composable(
            route = AuthScreen.route
        ) {
            AuthScreen(
                navigateToProfileScreen = {
                    navController.navigate(ProfileScreen.route)
                }
            )
        }
        composable(
            route = ProfileScreen.route
        ) {
            ProfileScreen(
                navigateToAuthScreen = {
                    navController.popBackStack()
                    navController.navigate(AuthScreen.route)
                }
            )
        }
    }
}