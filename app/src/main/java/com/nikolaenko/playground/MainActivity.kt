package com.nikolaenko.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nikolaenko.core.theme.PlaygroundTheme
import com.nikolaenko.feed.ui.Feed
import com.nikolaenko.playground.Screen.Feed
import com.nikolaenko.playground.Screen.Profile
import com.nikolaenko.playground.Screen.Settings
import com.nikolaenko.playground.ui.main.BottomBar
import com.nikolaenko.playground.ui.main.DrawerContent
import com.nikolaenko.profile.ui.Profile
import com.nikolaenko.settings.ui.Settings
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContent {

            val viewModel = viewModel<MainViewModel>(factory = factory)

            val state = viewModel.state.collectAsState()

            ProvideWindowInsets {
                PlaygroundTheme(darkTheme = state.value.isDarkTheme) {

                    val systemUiController = rememberSystemUiController()
                    systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = MaterialTheme.colors.isLight)
                    systemUiController.setNavigationBarColor(
                        color = Color.Transparent,
                        darkIcons = MaterialTheme.colors.isLight,
                        navigationBarContrastEnforced = false
                    )

                    val navController = rememberNavController()
                    val screens = listOf(Feed, Profile, Settings)

                    Surface(color = MaterialTheme.colors.background) {
                        Scaffold(
                            bottomBar = { BottomBar(navController, screens) },
                            drawerContent = { DrawerContent(viewModel::toggleDarkMode) }
                        ) { innerPadding ->
                            NavHost(navController, startDestination = Feed.route, Modifier.padding(innerPadding)) {
                                composable(Feed.route) { Feed(navController) }
                                composable(Profile.route) { Profile(navController) }
                                composable(Settings.route) { Settings(navController) }
                            }
                        }
                    }
                }
            }
        }
    }
}

sealed class Screen(val route: String, val image: ImageVector, @StringRes val titleId: Int) {
    object Feed : Screen("feed", Icons.Filled.List, R.string.bottom_tab_feed)
    object Profile : Screen("profile", Icons.Filled.Person, R.string.bottom_tab_profile)
    object Settings : Screen("settings", Icons.Filled.Settings, R.string.bottom_tab_settings)
}
