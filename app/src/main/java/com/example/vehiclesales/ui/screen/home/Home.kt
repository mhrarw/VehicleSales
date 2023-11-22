package com.example.vehiclesales.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vehiclesales.model.Vehicle
import com.example.vehiclesales.ui.screen.VehicleViewModel
import com.example.vehiclesales.ui.theme.VehicleSalesTheme
import dagger.hilt.android.lifecycle.HiltViewModel
import java.text.NumberFormat
import java.util.Locale

@Composable
fun HomeScreen(viewModel: VehicleViewModel = hiltViewModel(),modifier: Modifier = Modifier) {

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
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Text(
            text = "Tahun: ${vehicle.year}",
            style = MaterialTheme.typography.h6
        )
        Text(
            text = "Warna: ${vehicle.color}",
            style = MaterialTheme.typography.body1
        )
        Text(
            text = "Harga: ${vehicle.price}",
            style = MaterialTheme.typography.body1
        )
    }
}
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    VehicleSalesTheme {
        HomeScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun VehicleItemPreview() {
    VehicleSalesTheme {
        VehicleItem(
            vehicle = Vehicle(id = 1, year = 2022, color = "Red", price = 25000.0)
        )
    }
}

