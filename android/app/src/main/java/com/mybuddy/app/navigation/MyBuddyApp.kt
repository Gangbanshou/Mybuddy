package com.mybuddy.app.navigation

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mybuddy.app.ui.screens.BuddyScreen
import com.mybuddy.app.ui.screens.PersonalScreen
import com.mybuddy.app.ui.screens.ShopScreen

@Composable
fun MyBuddyApp() {
    val navController = rememberNavController()
    val tabs = listOf("personal" to "个人页", "buddy" to "学伴", "shop" to "商城")

    Scaffold(
        bottomBar = {
            val current by navController.currentBackStackEntryAsState()
            NavigationBar {
                tabs.forEach { (route, title) ->
                    NavigationBarItem(
                        selected = current?.destination?.route == route,
                        onClick = { navController.navigate(route) },
                        icon = {},
                        label = { Text(title) }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(navController = navController, startDestination = "personal", modifier = androidx.compose.ui.Modifier.padding(padding)) {
            composable("personal") { PersonalScreen() }
            composable("buddy") { BuddyScreen() }
            composable("shop") { ShopScreen() }
        }
    }
}
