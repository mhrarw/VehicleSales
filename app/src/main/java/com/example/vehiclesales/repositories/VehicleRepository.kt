package com.example.vehiclesales.repositories

import com.example.vehiclesales.model.DeletionHistory
import com.example.vehiclesales.model.Mobil
import com.example.vehiclesales.model.Motor
import com.example.vehiclesales.model.Vehicle
import com.example.vehiclesales.room.VehicleDao
import kotlinx.coroutines.Dispatchers
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
    suspend fun deleteVehicleWithHistory(vehicle: Vehicle) {
        withContext(Dispatchers.IO) {
            val deletionHistory = DeletionHistory(
                vehicleType = vehicle.vehicleType,
                year = vehicle.year,
                color = vehicle.color,
                price = vehicle.price,
                deletionTimestamp = System.currentTimeMillis()
            )
            vehicleDao.insertDeletionHistory(deletionHistory)
            vehicleDao.deleteVehicle(vehicle)
        }
    }

    suspend fun deleteMotorWithHistory(motor: Motor) {
        withContext(Dispatchers.IO) {
            val deletionHistory = DeletionHistory(
                vehicleType = motor.vehicleType,
                year = motor.year,
                color = motor.color,
                price = motor.price,
                deletionTimestamp = System.currentTimeMillis()
            )
            vehicleDao.insertDeletionHistory(deletionHistory)
            vehicleDao.deleteMotor(motor)
        }
    }

    suspend fun deleteMobilWithHistory(mobil: Mobil) {
        withContext(Dispatchers.IO) {
            val deletionHistory = DeletionHistory(
                vehicleType = mobil.vehicleType,
                year = mobil.year,
                color = mobil.color,
                price = mobil.price,
                deletionTimestamp = System.currentTimeMillis()
            )
            vehicleDao.insertDeletionHistory(deletionHistory)
            vehicleDao.deleteMobil(mobil)
        }
    }

    suspend fun getAllDeletionHistory(): List<DeletionHistory> {
        return vehicleDao.getAllDeletionHistory()
    }
}