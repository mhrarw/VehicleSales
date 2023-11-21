package com.example.vehiclesales.repositories

import androidx.lifecycle.LiveData
import com.example.vehiclesales.model.SaleDetails
import com.example.vehiclesales.model.Vehicle
import com.example.vehiclesales.model.VehicleDao

class VehicleRepository (private val vehicleDao: VehicleDao) {

    val allVehicles: LiveData<List<Vehicle>> = vehicleDao.getAllVehicles()
    //stok kendaraan

    suspend fun insertVehicle(vehicle: Vehicle) {
        vehicleDao.insertVehicle(vehicle)
        //penjualan kendaraan
    }

    fun getSalesReportByVehicleType(vehicleType: String): LiveData<List<SaleDetails>> {
        return vehicleDao.getSalesReportByVehicleType(vehicleType)
        //laporan penjualan per kendaraan
    }

}