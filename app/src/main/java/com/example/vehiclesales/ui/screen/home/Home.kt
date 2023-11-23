package com.example.vehiclesales.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.vehiclesales.ui.screen.VehicleViewModel

@Composable
fun HomeScreen(navController: NavHostController, viewModel: VehicleViewModel = hiltViewModel()) {
    val vehicles = viewModel.vehicles.collectAsState(initial = emptyList())

    LazyColumn(modifier = Modifier.padding(10.dp)) {
        item {
            Text(
                text = "Vehicle Stock",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(12.dp)
            )
        }
        items(vehicles.value.reversed()) { checkIn ->
            Card(
                modifier = Modifier.padding(10.dp).fillMaxWidth(),
                elevation = 8.dp,
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    androidx.compose.material.Text(text = "Vehicle Type: " +checkIn.vehicleType)
                    androidx.compose.material.Text(text = "Year: " + checkIn.year.toString())
                    androidx.compose.material.Text(text = "Color: " +checkIn.color)
                    androidx.compose.material.Text(text = "Price: Rp." +checkIn.price.toString())
                }
            }
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    VehicleSalesTheme {
        HomeScreen()
    }
}
 */


