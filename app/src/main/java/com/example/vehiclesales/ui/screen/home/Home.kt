package com.example.vehiclesales.ui.screen.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.vehiclesales.model.Vehicle
import com.example.vehiclesales.ui.screen.VehicleViewModel

@Composable
fun HomeScreen(viewModel: VehicleViewModel, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
    ) {
        LazyColumn {
            val vehicles = viewModel.allVehicles.value ?: emptyList()

            item {
                Text(
                    text = "Vehicle Stock",
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(14.dp)
                )
            }

            items(vehicles) { vehicle ->
                VehicleItem(vehicle = vehicle)
            }
        }
    }
}

@Composable
fun VehicleItem(vehicle: Vehicle) {
    Text(
        text = "Tahun: ${vehicle.year}, Warna: ${vehicle.color}, Harga: ${vehicle.price}",
        style = MaterialTheme.typography.body1,
        modifier = Modifier.padding(12.dp)
    )
}

/*
@Preview(showBackground = true)
@Composable
fun HomeScreenReview() {
    VehicleSalesTheme {
        val database = VehicleDatabase.getDatabase()
        val vehicleDao = database.vehicleDao()
        val vehicleRepository = VehicleRepository(vehicleDao)
        val viewModel = VehicleViewModel(vehicleRepository)
        HomeScreen(viewModel = viewModel)
    }
}

 */