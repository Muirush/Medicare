package com.gallopingtech.medicare.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.gallopingtech.medicare.model.ProblemsResponse
import com.gallopingtech.medicare.navigation.Routes
import com.gallopingtech.medicare.viewmodel.Result
import com.gallopingtech.medicare.viewmodel.medicineViewModel

@Composable
fun medicationListScreen(navController: NavController) {
    val viewModel: medicineViewModel = viewModel()
    val problemsResponse = viewModel.ProblemsResponse.collectAsState()

    Column (modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally

        ) {
        when(val state = problemsResponse.value){
            is Result.Loading -> CircularProgressIndicator()
            is Result.Success ->
                LazyColumn {
                state.data?.problems?.forEach { problem ->
                    problem.Diabetes?.forEach { diabetes ->
                        diabetes.medications?.forEach { medication ->
                            medication.medicationsClasses?.forEach { medClass ->
                                medClass.className.forEach { drugDetail ->
                                    drugDetail.associatedDrug?.forEach { drug ->
                                        item {
                                            val paddingCommon = Modifier.padding(10.dp)
                                            val drugName = drug.name
                                            val drugDose = drug.dose
                                            val drugStrength = drug.strength
                                            Card(elevation = CardDefaults.cardElevation(10.dp), modifier = paddingCommon,
                                                onClick = {
                                                    navController.navigate(Routes.medViewScreen
                                                            +"/"+drugName  +"/"+drugStrength )

                                                }
                                            ) {
                                                Column (modifier = Modifier.fillMaxWidth()) {
                                                    Text(text = "Medication: ${drug.name}", modifier = paddingCommon)
                                                    Text(text = " Dose: ${drug.dose}", modifier = paddingCommon)
                                                    Text(text = " Strength: ${drug.strength}", modifier = paddingCommon)

                                                }


                                            }
//

                                        }
                                    }

                                }
                                medClass.className2.forEach { drugDetail ->
                                    drugDetail.associatedDrug2.forEach {
                                            drug -> item {
                                        val paddingCommon = Modifier.padding(10.dp)
                                        val drugName = drug.name
                                        val drugDose = drug.dose
                                        val drugStrength = drug.strength
                                        Card(elevation = CardDefaults.cardElevation(10.dp), modifier = paddingCommon,
                                            onClick = {
//                                                navController.navigate(Routes.medViewScreen
//                                                       +"/"+drugName  +"/"+drugStrength )

                                                navController.navigate(Routes.medViewScreen + "/"+drugName)


                                            }
                                            ) {
                                            Column (modifier = Modifier.fillMaxWidth()) {
                                                Text(text = "Medication: ${drug.name}", modifier = paddingCommon)
                                                Text(text = " Dose: ${drug.dose}", modifier = paddingCommon)
                                                Text(text = " Strength: ${drug.strength}", modifier = paddingCommon)

                                            }

                                        }

                                    }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            is Result.Error -> Text("Error: ${state.message}")

        }

    }
}
