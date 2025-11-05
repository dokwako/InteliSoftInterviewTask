package com.example.intelisoftinterviewtask.data.remote

import com.example.intelisoftinterviewtask.data.Patient
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("user/signup")
    suspend fun signupUser(
        @Body request: AuthRequest
    ): Response<AuthResponse>

    @POST("user/login")
    suspend fun loginUser(
        @Body request: AuthRequest
    ): Response<AuthResponse>

    @POST("patients/register")
    suspend fun registerPatient(
        @Header("Authorization") token: String,
        @Body patient: Patient
    ): Response<Patient> // Assumes it returns the patient
}