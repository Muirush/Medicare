package com.gallopingtech.medicare.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.gallopingtech.medicare.model.Drug
import com.gallopingtech.medicare.viewmodel.Result
import com.gallopingtech.medicare.viewmodel.modicinesViewModel
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable

//fun homeScreen(userName:String,viewModel: modicinesViewModel){

fun homeScreen(viewModel: modicinesViewModel){
    Column (modifier = Modifier.fillMaxSize() .padding(0.dp,40.dp,0.dp, 0.dp),
//        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        val currentTime = LocalTime.now().hour
        val greetings = when(currentTime){
            in 5..11 -> "Good Morning"
            in 12..16 -> "Good Afternoon"
            in 17..21 ->"Good Evening"
            else -> "Good Night"
        }
//        Text(text = "$greetings  $userName" )

        val problemsState = viewModel.problemsState.collectAsState()

        when (val state = problemsState.value) {
            is Result.Loading -> CircularProgressIndicator()
            is Result.Success -> LazyColumn {
                state.data.problems.forEach { problem ->
                    problem.Diabetes.forEach { condition ->
                        condition.medications.forEach { medication ->
                            medication.medicationsClasses.forEach { medicationClass ->
                                medicationClass.className.forEach { drugClass ->
                                    items(drugClass.associatedDrug) { drug ->
                                        DrugItem(drug)
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
//@Composable
//fun ProblemsScreen(viewModel: modicinesViewModel) {
//
//}

@Composable
fun DrugItem(drug: Drug) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = "Name: ${drug.name}")
        Text(text = "Dose: ${drug.dose}")
        Text(text = "Strength: ${drug.strength}")
    }
}
