package com.example.intelisoftinterviewtask.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "patients")
class Patient (
    @PrimaryKey(autoGenerate = true)
    val localId: Int = 0, // ID for local Room database

    val id: String?, // ID from the server

    @SerializedName("unique")
    val uniqueId: String,

    @SerializedName("firstname")
    val firstName: String,

    @SerializedName("lastname")
    val lastName: String,

    @SerializedName("dob")
    val dateOfBirth: String,

    val gender: String,

    @SerializedName("reg_date")
    val registrationDate: String
)