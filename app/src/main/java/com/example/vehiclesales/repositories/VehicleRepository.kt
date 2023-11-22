package com.example.vehiclesales.repositories

import androidx.lifecycle.LiveData
import com.example.vehiclesales.model.SaleDetails
import com.example.vehiclesales.model.Vehicle
import com.example.vehiclesales.room.VehicleDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class VehicleRepository @Inject constructor (private val vehicleDao: VehicleDao) {
    val allVehicles: LiveData<List<Vehicle>> = vehicleDao.getAllVehicles()
    //stok kendaraan

    suspend fun insertVehicle(vehicle: Vehicle) {
        withContext(Dispatchers.IO) {
            vehicleDao.insertVehicle(vehicle)
            //penjualan kendaraan
        }
    }

    fun getSalesReportByVehicleType(vehicleType: String): LiveData<List<SaleDetails>> {
        return vehicleDao.getSalesReportByVehicleType(vehicleType)
        //laporan penjualan per kendaraan
    }

    suspend fun insertSaleDetails(saleDetails: SaleDetails) {
        vehicleDao.insertSaleDetails(saleDetails)
    }
    //detail penjual
}