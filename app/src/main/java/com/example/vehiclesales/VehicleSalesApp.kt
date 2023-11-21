package com.example.vehiclesales

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.vehiclesales.ui.navigation.Screen
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.vehiclesales.ui.navigation.NavigationItem
import com.example.vehiclesales.ui.screen.HomeScreen
import com.example.vehiclesales.ui.screen.SalesReportScreen
import com.example.vehiclesales.ui.screen.VehicleSalesScreen
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem

@Composable
fun VehicleSalesApp() {
    val navController = rememberNavController()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            bottomBar = {
                BottomBar(navController = navController)
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Screen.Home.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(Screen.Home.route) {
                    HomeScreen("Home", Modifier.fillMaxSize())
                }
                composable(Screen.VehicleSales.route) {
                    VehicleSalesScreen("Vehicle Sales", Modifier.fillMaxSize())
                }
                composable(Screen.SalesReport.route) {
                    SalesReportScreen("Sales Report", Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavController,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val navigationItems = listOf(
        NavigationItem(
            title = "Home",
            screen = Screen.Home
        ),
        NavigationItem(
            title = "Vehicle Sales",
            screen = Screen.VehicleSales
        ),
        NavigationItem(
            title = "Sales Report",
            screen = Screen.SalesReport
        )
    )

    BottomNavigation {
        navigationItems.forEach { item ->
            BottomNavigationItem(
                icon = {
                    when (item.screen) {
                        Screen.Home -> Icon(imageVector = Icons.Default.Home, contentDescription = null)
                        Screen.VehicleSales -> Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null)
                        Screen.SalesReport -> Icon(imageVector = Icons.Default.Notifications, contentDescription = null)
                    }
                },
                label = { Text(item.title) },
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewVehicleSalesApp() {
    VehicleSalesApp()
}