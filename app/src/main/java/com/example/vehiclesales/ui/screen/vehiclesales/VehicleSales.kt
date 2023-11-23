package com.example.vehiclesales.ui.screen.vehiclesales

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.vehiclesales.model.Vehicle
import com.example.vehiclesales.ui.screen.VehicleViewModel

enum class VehicleType {
    MOTOR, MOBIL
}
@Composable
fun VehicleSalesScreen(navController: NavHostController, viewModel: VehicleViewModel = hiltViewModel()) {

    val vehicleType = remember { mutableStateOf("") }
    val year = remember { mutableIntStateOf(0) }
    val color = remember { mutableStateOf("") }
    val price = remember { mutableLongStateOf(0) }
    val engine = remember { mutableStateOf("") }
    val suspensionType = remember { mutableStateOf("") }
    val transmissionType = remember { mutableStateOf("") }
    val passengerCapacity = remember { mutableIntStateOf(0) }
    val type = remember { mutableStateOf("") }

    LazyColumn(modifier = Modifier.padding(10.dp)) {
        item {
            androidx.compose.material3.Text(
                text = "Vehicle Sales",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(12.dp)
            )
            Column {
                Column(
                    modifier = Modifier.padding(10.dp).fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(value = vehicleType.value, onValueChange = { vehicleType.value = it },
                        label = { Text(text = "Vehicle Type") })

                    OutlinedTextField(value = year.value.toString(), onValueChange = {
                        try {
                            year.value = it.toInt()
                        } catch (e: NumberFormatException) {
                            println("Invalid input for year: $it")
                        }
                    }, label = {Text(text = "Year") })

                    OutlinedTextField(value = color.value, onValueChange = { color.value = it },
                        label = { Text(text = "Color") })

                    OutlinedTextField(value = price.value.toString(), onValueChange = {
                        try {
                            price.value = it.toLong()
                        } catch (e: NumberFormatException) {
                            println("Invalid input for price: $it")
                        }
                    }, label = { Text(text = "Price") })

                    Button(onClick = {
                        viewModel.insertVehicle(
                            Vehicle(vehicleType= vehicleType.value ,year = year.value, color = color.value, price = price.value)
                        )
                        navController.navigate("home")
                    }) {
                        Text(text = "Add Vehicle")
                    }

                }
            }
        }
    }
}
