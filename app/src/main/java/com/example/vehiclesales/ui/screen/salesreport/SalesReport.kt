package com.example.vehiclesales.ui.screen.salesreport

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.vehiclesales.model.DeletionHistory
import com.example.vehiclesales.ui.screen.VehicleViewModel
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SalesReportScreen(navController: NavHostController, viewModel: VehicleViewModel = hiltViewModel()) {
    val deletionHistory = viewModel.deletionHistory.collectAsState(initial = emptyList()).value

    LazyColumn (modifier = Modifier.padding(10.dp)) {
        item {
            Text(
                text = "Vehicle Sales Report",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(12.dp)
            )
        }
        items(deletionHistory) { history ->
            DeletionHistoryItem(history)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DeletionHistoryItem(history: DeletionHistory) {

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault())
    val formattedTimestamp = formatter.format(Instant.ofEpochMilli(history.deletionTimestamp))

    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        elevation = 8.dp,
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(
                text = "Type: ${history.vehicleType}",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "Year: ${history.year}",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "Color: ${history.color}",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "Price: ${history.price}",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "Order Time: $formattedTimestamp",
                style = MaterialTheme.typography.body1
            )
        }
    }
}



