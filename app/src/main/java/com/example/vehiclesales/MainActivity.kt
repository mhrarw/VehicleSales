package com.example.vehiclesales

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.vehiclesales.repositories.VehicleRepository
import com.example.vehiclesales.room.VehicleDatabase
import com.example.vehiclesales.ui.screen.VehicleSalesApp
import com.example.vehiclesales.ui.theme.VehicleSalesTheme
import com.example.vehiclesales.ui.screen.VehicleViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VehicleSalesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val database = VehicleDatabase.getDatabase(applicationContext)
                    val vehicleDao = database.vehicleDao()
                    val vehicleRepository = VehicleRepository(vehicleDao)
                    val viewModel = VehicleViewModel(vehicleRepository)
                    VehicleSalesApp (viewModel = viewModel)
                }
            }
        }
    }
}
