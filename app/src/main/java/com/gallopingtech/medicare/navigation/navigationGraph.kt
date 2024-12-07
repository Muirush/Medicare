package com.gallopingtech.medicare.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gallopingtech.medicare.screens.homeScreen
import com.gallopingtech.medicare.screens.loginScreen
import com.gallopingtech.medicare.screens.medViewScreen


@Composable
fun navigationGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.loginScreen){
        composable(Routes.loginScreen){
            loginScreen(navController)
        }
        composable(Routes.homeScreen +"/{userName}"){
            var userName = it.arguments?.getString("userName")
            if (userName != null) {
//                homeScreen(userName, viewModel = viewModel())
                homeScreen( viewModel = viewModel())
            }
        }
        composable(Routes.medViewScreen){
            medViewScreen(navController)
        }
    }
}