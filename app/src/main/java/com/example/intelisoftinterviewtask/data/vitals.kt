package com.example.intelisoftinterviewtask.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vitals")
data class Vitals(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val patientId: String, // To link this to a Patient
    val visitDate: String,
    val height: String,
    val weight: String,
    val bmi: String
)