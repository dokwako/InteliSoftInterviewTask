package com.example.intelisoftinterviewtask.presentation.patient_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.intelisoftinterviewtask.data.Patient

@Composable
fun PatientListScreen(
    viewModel: PatientListViewModel = hiltViewModel()
) {
    // Collect the list from the ViewModel as state
    val patients by viewModel.patientList.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Patient List", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        // list
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(patients) { patient ->
                PatientListItem(patient = patient)
                Divider()
            }
        }
    }
}

@Composable
fun PatientListItem(patient: Patient) {
    // This is one row in the list
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                "${patient.firstName} ${patient.lastName}",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                "ID: ${patient.uniqueId}",
                style = MaterialTheme.typography.bodySmall
            )
        }
        // TODO: Add BMI status
        Text("BMI: N/A")
    }
}