package com.nikolaenko.playground.auth.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nikolaenko.playground.auth.ui.forgot.ForgotPassword
import com.nikolaenko.playground.auth.ui.login.Login
import com.nikolaenko.playground.auth.ui.register.Register

fun NavGraphBuilder.AuthGraph(
    navController: NavHostController,
    route: String,
    onLoggedIn: () -> Unit
) {
    navigation(startDestination = Screen.Login.route, route = route) {
        composable(Screen.Login.route) {
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
            Register()
        }
        composable(Screen.ForgotPassword.route) {
            ForgotPassword()
        }
    }
}

internal sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object ForgotPassword : Screen("forgot_password")
}
