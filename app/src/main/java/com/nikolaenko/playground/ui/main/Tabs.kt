package com.nikolaenko.playground.ui.main

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AreaChart
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nikolaenko.playground.R
import com.nikolaenko.playground.ui.tab1.Tab1
import com.nikolaenko.playground.ui.tab2.Tab2
import com.nikolaenko.playground.ui.tab3.Tab3

@Composable
fun Tabs() {
    val screens = listOf(TabScreen.Tab1, TabScreen.Tab2, TabScreen.Tab3)
    val navController = rememberNavController()

    ConstraintLayout {
        val (containerRef, bottomRef) = createRefs()
        Column(
            modifier = Modifier
                .constrainAs(containerRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(bottomRef.top)
                },
        ) {
            NavHost(
                navController = navController,
                startDestination = TabScreen.Tab1.route
            ) {
                composable(TabScreen.Tab1.route) {
                    Tab1()
                }
                composable(TabScreen.Tab2.route) {
                    Tab2()
                }
                composable(TabScreen.Tab3.route) {
                    Tab3()
                }
            }
        }
        Column(
            modifier = Modifier
                .constrainAs(bottomRef) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        ) {
            BottomBar(navController, screens)
        }
    }
}

sealed class TabScreen(val route: String, val image: ImageVector, @StringRes val titleId: Int) {
    object Tab1 : TabScreen("tab1", Icons.Filled.List, R.string.tab1)
    object Tab2 : TabScreen("tab2", Icons.Filled.Chat, R.string.tab2)
    object Tab3 : TabScreen("tab3", Icons.Filled.AreaChart, R.string.tab3)
}