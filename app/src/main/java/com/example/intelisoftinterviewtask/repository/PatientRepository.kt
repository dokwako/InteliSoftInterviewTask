package com.example.intelisoftinterviewtask.repository

import com.example.intelisoftinterviewtask.data.Patient
import kotlinx.coroutines.flow.Flow

//a ViewModel can use this to get data.
interface PatientRepository {
    fun getAllPatients(): Flow<List<Patient>>

    // Our command to register a new patient
    suspend fun registerPatient(patient: Patient)
}