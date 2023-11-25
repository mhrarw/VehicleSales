package com.example.vehiclesales.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vehiclesales.model.Mobil
import com.example.vehiclesales.model.Motor
import com.example.vehiclesales.model.Vehicle
import com.example.vehiclesales.repositories.VehicleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VehicleViewModel @Inject constructor(
    private val repository: VehicleRepository) :ViewModel() {

    private val _vehicle = MutableStateFlow(emptyList<Vehicle>())
    private val _motor = MutableStateFlow(emptyList<Motor>())
    private val _mobil = MutableStateFlow(emptyList<Mobil>())

    val vehicles: StateFlow<List<Vehicle>> = _vehicle
    val vehiclesMotor: StateFlow<List<Motor>> = _motor
    val vehiclesMobil: StateFlow<List<Mobil>> = _mobil


    init {
        viewModelScope.launch {
            _vehicle.emit(repository.getAllItems())
            _motor.emit(repository.getAllMotor())
            _mobil.emit(repository.getAllMobil())
        }
    }

    fun insertVehicle(vehicle: Vehicle) {
        viewModelScope.launch {
            when (vehicle) {

                is Motor -> repository.insertMotor(vehicle)
                is Mobil -> repository.insertMobil(vehicle)
                else -> repository.insertVehicle(vehicle)
            }
            _vehicle.emit(repository.getAllItems())
            _motor.emit(repository.getAllMotor())
            _mobil.emit(repository.getAllMobil())
        }
    }
}