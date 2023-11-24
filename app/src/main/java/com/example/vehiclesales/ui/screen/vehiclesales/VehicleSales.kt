package com.example.vehiclesales.ui.screen.vehiclesales

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.vehiclesales.model.Vehicle
import com.example.vehiclesales.ui.screen.VehicleViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun VehicleSalesScreen(navController: NavHostController, viewModel: VehicleViewModel = hiltViewModel()) {
    val vehicleType = remember { mutableStateOf("") }
    val year = remember { mutableIntStateOf(0) }
    val color = remember { mutableStateOf("") }
    val price = remember { mutableLongStateOf(0) }
    val engineMobil = remember { mutableStateOf("") }
    val passengerCapacity = remember { mutableIntStateOf(0) }
    val type = remember { mutableStateOf("") }
    val engineMotor = remember { mutableStateOf("") }
    val suspensionType = remember { mutableStateOf("") }
    val transmissionType = remember { mutableStateOf("") }

    var expanded by remember { mutableStateOf(false) }
    var showErrorSnackbar by remember { mutableStateOf(false) }

    fun isDataValid(): Boolean {
        return vehicleType.value.isNotEmpty() && year.value > 0 && color.value.isNotEmpty() && price.value > 0
    }

    LazyColumn(modifier = Modifier.padding(10.dp)) {
        item {
            androidx.compose.material3.Text(
                text = "Vehicle Sales",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(12.dp)
            )
            Column {
                Column( modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    //drop down list tipe kendaraan
                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = { expanded = it }
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { expanded = true }
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .border(1.dp, Color.Gray)
                                    .padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Select Vehicle Type: ${vehicleType.value}",
                                    modifier = Modifier
                                        .weight(1f)
                                )
                                Icon(
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(24.dp)
                                )
                            }
                            DropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                            ) {
                                DropdownMenuItem(onClick = {
                                    vehicleType.value = "Motor"
                                    expanded = false
                                }) {
                                    Text(text = "Motor") }
                                DropdownMenuItem(onClick = {
                                    vehicleType.value = "Mobil"
                                    expanded = false
                                }) {
                                    Text(text = "Mobil") }
                            }
                        }
                    }

                    //tahun kendaraan
                    OutlinedTextField(value = year.value.toString(), onValueChange = {
                        try {
                            year.value = it.toInt()
                        } catch (e: NumberFormatException) {
                            println("Invalid input for year: $it")
                        }
                    }, label = {Text(text = "Year") },
                        modifier = Modifier
                            .fillMaxWidth()
                    )

                    //warna kendaraan
                    OutlinedTextField(value = color.value, onValueChange = { color.value = it },
                        label = { Text(text = "Color") }, modifier = Modifier.fillMaxWidth())

                    //harga kendaraan
                    OutlinedTextField(value = price.value.toString(), onValueChange = {
                        try {
                            price.value = it.toLong()
                        } catch (e: NumberFormatException) {
                            println("Invalid input for price: $it")
                        }
                    }, label = { Text(text = "Price") },
                        modifier = Modifier
                            .fillMaxWidth())

                    //add vehicle
                    Button(
                        onClick = {
                            if (isDataValid()) {
                                viewModel.insertVehicle(
                                    Vehicle(vehicleType = vehicleType.value, year = year.value, color = color.value, price = price.value)
                                )
                                navController.navigate("home")
                            } else {
                                showErrorSnackbar = true
                            }
                        },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    ) {
                        Text(text = "Add Vehicle", fontSize = 16.sp)
                    }
                }

                if (showErrorSnackbar) {
                    Snackbar(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        action = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ) {
                                Button(onClick = { showErrorSnackbar = false }) {
                                    Text("OK")
                                }
                            }
                        }
                    ) { Text("Please fill out all the required fields.") }
                }
            }
        }
    }
}

