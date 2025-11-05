package com.example.intelisoftinterviewtask.data.remote

import com.google.gson.annotations.SerializedName

// response from the server after login
data class AuthResponse(
    val user: User,
    @SerializedName("access_token") // Match the JSON from Postman
    val accessToken: String
)

// A helper class for the 'user' object inside the response
data class User(
    val id: Int,
    val name: String,
    val email: String
)