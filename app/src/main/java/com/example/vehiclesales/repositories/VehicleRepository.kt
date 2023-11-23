package com.example.vehiclesales.repositories

import com.example.vehiclesales.model.Vehicle
import com.example.vehiclesales.room.VehicleDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class VehicleRepository @Inject constructor (private val vehicleDao: VehicleDao) {

    fun getAllItems(): List<Vehicle> {
        return vehicleDao.getAllVehicles()
    }

    suspend fun insertVehicle(vehicle: Vehicle) {
        withContext(Dispatchers.IO) {
            vehicleDao.insertVehicle(vehicle)
        }
    }


}