package com.gallopingtech.medicare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gallopingtech.medicare.navigation.navigationGraph
import com.gallopingtech.medicare.screens.loginScreen
import com.gallopingtech.medicare.screens.medicationListScreen
import com.gallopingtech.medicare.ui.theme.MediCareTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           navigationGraph()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}