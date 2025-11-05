package com.example.intelisoftinterviewtask.data.remote

// Holds the data for both login and signup
data class AuthRequest(
    val email: String,
    val password: String,
    val name: String? = null
)