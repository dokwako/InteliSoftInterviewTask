package com.example.intelisoftinterviewtask.presentation.patient_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.intelisoftinterviewtask.data.Patient
import com.example.intelisoftinterviewtask.repository.PatientRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class PatientListViewModel @Inject constructor(
    private val repository: PatientRepository
) : ViewModel() {
    val patientList: StateFlow<List<Patient>> = repository.getAllPatients()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
}