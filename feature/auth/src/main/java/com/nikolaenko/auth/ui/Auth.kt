package com.nikolaenko.auth.ui

import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nikolaenko.auth.ui.forgot.ForgotPassword
import com.nikolaenko.auth.ui.login.Login
import com.nikolaenko.auth.ui.register.Register
import com.nikolaenko.utils.logger.Logger

fun NavGraphBuilder.AuthGraph(
    navController: NavHostController,
    onLoggedIn: () -> Unit
) {
    navigation(startDestination = Screen.Login.route, route = "auth") {
        Logger.d("navigation Auth")
        composable(Screen.Login.route) {
            Logger.d("composable Login ${LocalLifecycleOwner.current}")
            Login(
                onLoggedIn = onLoggedIn,
                goToRegister = {
                    navController.navigate(Screen.Register.route)
                },
                goToResetPassword = {
                    navController.navigate(Screen.ForgotPassword.route)
                }
            )
        }
        composable(Screen.Register.route) {
            Logger.d("composable Register ${LocalLifecycleOwner.current}")
            Register()
        }
        composable(Screen.ForgotPassword.route) {
            Logger.d("composable ForgotPassword ${LocalLifecycleOwner.current}")
            ForgotPassword()
        }
    }
}

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object ForgotPassword : Screen("forgot_password")
}
