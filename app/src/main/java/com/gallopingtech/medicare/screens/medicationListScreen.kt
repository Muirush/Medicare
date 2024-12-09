package com.gallopingtech.medicare.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gallopingtech.medicare.model.ProblemsResponse
import com.gallopingtech.medicare.viewmodel.medicineViewModel

@Composable
fun medicationListScreen() {
    // Using ViewModel to get the data
    val viewModel: medicineViewModel = viewModel()
    val problemsResponse by viewModel.ProblemsResponse.collectAsState()
//    val medicationData by ProblemsResponse.collectAsState()

    Column (modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

        ) {
        LazyColumn {
        problemsResponse?.problems?.forEach { problem ->
            problem.Diabetes?.forEach { diabetes ->
                diabetes.medications?.forEach { medication ->
                    medication.medicationsClasses?.forEach { medClass ->
                        medClass.className.forEach { drugDetail ->
                            drugDetail.associatedDrug?.forEach { drug ->
                                item {
                                    Text(text = "Medication: ${drug.name}")
                                    Text(text = " Dose: ${drug.dose}")
                                    Text(text = " Strength: ${drug.strength}")
                                }
                            }

                        }
                        medClass.className2.forEach { drugDetail ->
                            drugDetail.associatedDrug2.forEach {
                                drug -> item {
                                Text(text = "Medication: ${drug.name}")
                                Text(text = " Dose: ${drug.dose}")
                                Text(text = " Strength: ${drug.strength}")

                            }
                            }
                        }
                    }
                }
            }
            // You can add more logic to display other problems like Asthma if needed
        }
    }

    }
}
