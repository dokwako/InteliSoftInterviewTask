package com.example.intelisoftinterviewtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.intelisoftinterviewtask.presentation.patient_list.PatientListScreen
import com.example.intelisoftinterviewtask.presentation.patient_registration.PatientRegistrationScreen
import com.example.intelisoftinterviewtask.ui.theme.InteliSoftInterviewTaskTheme
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InteliSoftInterviewTaskTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val navController = rememberNavController()

                    //Navigation Host
                    NavHost(
                        navController = navController,
                        startDestination = "register", // Start on the register screen
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("register") {
                            PatientRegistrationScreen()
                            // TODO: Add navigation to list screen
                        }

                        composable("patient_list") {
                            PatientListScreen()
                            // TODO: Add navigation back to register
                        }
                    }
                }
            }
        }
    }
}