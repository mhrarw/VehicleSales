package com.example.vehiclesales.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object VehicleSales : Screen("vehicle_sales")
    object SalesReport : Screen("sales_report")
}