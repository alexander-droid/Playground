package com.nikolaenko.playground.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.nikolaenko.playground.R

sealed class Screen(val route: String, val image: ImageVector, @StringRes val titleId: Int) {
    object Feed : Screen("feed", Icons.Filled.List, R.string.bottom_tab_feed)
    object Profile : Screen("profile", Icons.Filled.Person, R.string.bottom_tab_profile)
    object Settings : Screen("settings", Icons.Filled.Settings, R.string.bottom_tab_settings)
}
