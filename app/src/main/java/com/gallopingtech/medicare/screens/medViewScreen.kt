package com.gallopingtech.medicare.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun medViewScreen(
    navController: NavController,
    drugName: String,
    drugStrength: String,
    drugDose: String
){
    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
        ) {

        Text(text = "View Medicines")
        Text(text = drugName)
        Text(text = drugDose)
        Text(text = drugStrength)
    }
}