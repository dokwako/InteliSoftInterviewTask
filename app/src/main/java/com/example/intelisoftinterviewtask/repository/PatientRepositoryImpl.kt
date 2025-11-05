package com.example.intelisoftinterviewtask.repository

import com.example.intelisoftinterviewtask.data.Patient
import com.example.intelisoftinterviewtask.data.local.PatientDao
import com.example.intelisoftinterviewtask.data.remote.ApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PatientRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: PatientDao
) : PatientRepository {
    private val TEMP_AUTH_TOKEN = "Bearer 354|rKbBQhRnXhkvd1oUjJv5KyxEY9vEgVs22BSWAIue"

    override fun getAllPatients(): Flow<List<Patient>> {
        return dao.getAllPatients()
    }

    override suspend fun registerPatient(patient: Patient) {
        try {
            // save to the remote API first
            val response = api.registerPatient(TEMP_AUTH_TOKEN, patient)

            if (response.isSuccessful) {
                // If API is successful, save to our local Room database
                // get the patient back from the API, which might have the server ID
                response.body()?.let { serverPatient ->
                    dao.insertPatient(serverPatient)
                }
            } else {
                // Handle API error
                throw Exception("API Error: ${response.message()}")
            }
        } catch (e: Exception) {
            // Handle network err
            throw e
        }
    }
}