package com.example.vehiclesales.repositories

import com.example.vehiclesales.model.Mobil
import com.example.vehiclesales.model.Motor
import com.example.vehiclesales.model.Vehicle
import com.example.vehiclesales.room.VehicleDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class VehicleRepository @Inject constructor (private val vehicleDao: VehicleDao) {

    fun getAllItems(): List<Vehicle> {
        return vehicleDao.getAllVehicles()
    }

    fun getAllMotor(): List<Motor> {
        return vehicleDao.getAllMotor()
    }

    fun getAllMobil(): List<Mobil> {
        return vehicleDao.getAllMobil()
    }

    suspend fun insertVehicle(vehicle: Vehicle) {
        withContext(Dispatchers.IO) {
            vehicleDao.insertVehicle(vehicle)
        }
    }

    suspend fun insertMotor(motor: Motor) {
        withContext(Dispatchers.IO) {
            vehicleDao.insertVehicle(motor)
            vehicleDao.insertMotor(motor)
        }
    }

    suspend fun insertMobil(mobil: Mobil) {
        withContext(Dispatchers.IO) {
            vehicleDao.insertVehicle(mobil)
            vehicleDao.insertMobil(mobil)
        }
    }
}