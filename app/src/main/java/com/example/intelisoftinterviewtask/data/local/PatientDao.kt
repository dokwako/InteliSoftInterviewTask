package com.example.intelisoftinterviewtask.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.intelisoftinterviewtask.data.Patient
import kotlinx.coroutines.flow.Flow

@Dao
interface PatientDao {

    // insert one patient
    @Insert
    suspend fun insertPatient(patient: Patient)

    // get all
    // 'Flow' makes this list automatically update in the UI
    @Query("SELECT * FROM patients")
    fun getAllPatients(): Flow<List<Patient>>

}