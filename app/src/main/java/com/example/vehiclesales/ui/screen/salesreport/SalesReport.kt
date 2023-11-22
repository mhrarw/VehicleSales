package com.example.vehiclesales.ui.screen.salesreport

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.vehiclesales.ui.theme.VehicleSalesTheme

@Composable
fun SalesReportScreen(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "ini $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun SalesReportScreenReview() {
    VehicleSalesTheme {
        SalesReportScreen("Sales Report Screen")
    }
}