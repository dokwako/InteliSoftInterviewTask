package com.example.intelisoftinterviewtask.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.intelisoftinterviewtask.data.Patient
import com.example.intelisoftinterviewtask.data.Vitals

@Database(
    entities = [Patient::class, Vitals::class], // Lists all tables
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    // Connects the database to our DAO
    abstract fun patientDao(): PatientDao

}