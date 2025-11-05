package com.example.intelisoftinterviewtask.presentation.patient_registration

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.intelisoftinterviewtask.data.Patient

@Composable
fun PatientRegistrationScreen(
    viewModel: `PatientRegistrationViewModel.kt` = hiltViewModel()
) {
    // This statewill hold the text from the TextFields
    var uniqueId by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var regDate by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Text("Patient Registration", style = MaterialTheme.typography.headlineSmall)

        OutlinedTextField(
            value = uniqueId,
            onValueChange = { uniqueId = it },
            label = { Text("Patient ID (Unique)") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text("First Name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Last Name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = dob,
            onValueChange = { dob = it },
            label = { Text("Date of Birth (YYYY-MM-DD)") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = gender,
            onValueChange = { gender = it },
            label = { Text("Gender") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = regDate,
            onValueChange = { regDate = it },
            label = { Text("Registration Date (YYYY-MM-DD)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        //  Save Btn
        Button(
            onClick = {
                // When clicked creates the Patient object
                val patient = Patient(
                    id = null, // outo generated this
                    uniqueId = uniqueId,
                    firstName = firstName,
                    lastName = lastName,
                    dateOfBirth = dob,
                    gender = gender,
                    registrationDate = regDate
                )
                // Tell the ViewModel to save
                viewModel.registerPatient(patient)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("REGISTER PATIENT")
        }
    }
}