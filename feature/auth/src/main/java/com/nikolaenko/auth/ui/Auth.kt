package com.nikolaenko.auth.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nikolaenko.auth.ui.forgot.ForgotPassword
import com.nikolaenko.auth.ui.login.Login
import com.nikolaenko.auth.ui.register.Register
import com.nikolaenko.utils.logger.Logger

@Composable
fun Auth() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Login.route) {
        Logger.d("Auth NavHost")
        composable(Screen.Login.route) {
            Logger.d("composable Login")
            Login()
        }
        composable(Screen.Register.route) {
            Logger.d("composable Register")
            Register()
        }
        composable(Screen.ForgotPassword.route) {
            Logger.d("composable ForgotPassword")
            ForgotPassword()
        }
    }
}

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object ForgotPassword : Screen("forgot_password")
}
