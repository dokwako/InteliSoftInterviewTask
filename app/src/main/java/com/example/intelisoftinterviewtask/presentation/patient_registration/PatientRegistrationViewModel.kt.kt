package com.example.intelisoftinterviewtask.presentation.patient_registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.intelisoftinterviewtask.data.Patient
import com.example.intelisoftinterviewtask.repository.PatientRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class `PatientRegistrationViewModel.kt` @Inject constructor(
    private val repository: PatientRepository
) : ViewModel() {

    fun registerPatient(patient: Patient) {
        viewModelScope.launch {
            try {
                repository.registerPatient(patient)
                // TODO: Add navigation logic here on success
            } catch (e: Exception) {
                // TODO: Show an error to the user
            }
        }
    }
}