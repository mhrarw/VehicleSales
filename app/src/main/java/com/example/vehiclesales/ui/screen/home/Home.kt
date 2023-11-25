package com.example.vehiclesales.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.vehiclesales.model.Mobil
import com.example.vehiclesales.model.Motor
import com.example.vehiclesales.model.Vehicle
import com.example.vehiclesales.ui.screen.VehicleViewModel

@Composable
fun HomeScreen(navController: NavHostController, viewModel: VehicleViewModel = hiltViewModel()) {
    val vehicles = viewModel.vehicles.collectAsState(initial = emptyList())
    val vehiclesMotor = viewModel.vehiclesMotor.collectAsState(initial = emptyList())
    val vehiclesMobil = viewModel.vehiclesMobil.collectAsState(initial = emptyList())

    val allVehicles = (vehiclesMotor.value + vehiclesMobil.value).sortedByDescending { it.id }

    LazyColumn(modifier = Modifier.padding(10.dp)) {
        item {
            Text(
                text = "All Vehicle Stock",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(12.dp)
            )
            allVehicles.forEach { checkIn ->
                VehicleCard(navController, checkIn)
            }
        }
    }
}

@Composable
fun VehicleCard(navController: NavHostController, checkIn: Vehicle, viewModel: VehicleViewModel = hiltViewModel()) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        elevation = 8.dp,
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = "Vehicle Type: ${checkIn.vehicleType}")
            Text(text = "Year: ${checkIn.year}")
            Text(text = "Color: ${checkIn.color}")
            Text(text = "Price: Rp. ${checkIn.price}")


            when (checkIn) {
                is Motor -> {
                    Text(text = "Engine: ${checkIn.engineMotor}")
                    Text(text = "Suspension Type: ${checkIn.suspensionType}")
                    Text(text = "Transmission Type: ${checkIn.transmissionType}")
                }
                is Mobil -> {
                    Text(text = "Engine: ${checkIn.engineMobil}")
                    Text(text = "Passenger Capacity: ${checkIn.passengerCapacity}")
                    Text(text = "Type: ${checkIn.type}")
                }
            }
            Button(
                onClick = {
                    viewModel.deleteVehicle(checkIn)
                    navController.navigate("sales_report")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Text(text = "Order Now")
            }
        }
    }
}


