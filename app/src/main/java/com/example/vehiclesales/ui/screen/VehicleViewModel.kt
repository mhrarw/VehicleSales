package com.example.vehiclesales.ui.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vehiclesales.model.SaleDetails
import com.example.vehiclesales.model.Vehicle
import com.example.vehiclesales.repositories.VehicleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VehicleViewModel @Inject constructor(
    private val repository: VehicleRepository) :ViewModel() {

    private val _vehicle = MutableStateFlow(emptyList<Vehicle>())
    val vehicles: StateFlow<List<Vehicle>> = _vehicle

    init {
        viewModelScope.launch {
            _vehicle.emit(repository.getAllItems())
        }
    }

    fun insertVehicle(vehicle: Vehicle) {
        viewModelScope.launch {
            repository.insertVehicle(vehicle)
            _vehicle.emit(repository.getAllItems())
        }
    }


}