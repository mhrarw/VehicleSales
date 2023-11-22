package com.example.vehiclesales.ui.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vehiclesales.model.SaleDetails
import com.example.vehiclesales.model.Vehicle
import com.example.vehiclesales.repositories.VehicleRepository
import kotlinx.coroutines.launch

class VehicleViewModel(private val repository: VehicleRepository):ViewModel() {

    val allVehicles: LiveData<List<Vehicle>> = repository.allVehicles
    //lihat stok kendaraan

    fun insertVehicle(vehicle: Vehicle) {
        viewModelScope.launch {
            repository.insertVehicle(vehicle)
        }
        //penjualan kendaraan
    }

    fun getSalesReportByVehicleType(vehicleType: String): LiveData<List<SaleDetails>> {
        return repository.getSalesReportByVehicleType(vehicleType)
        //laporan penjualan per kendaraan
    }

}