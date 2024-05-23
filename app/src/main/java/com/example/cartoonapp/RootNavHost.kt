package com.example.cartoonapp

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cartoonapp.presentation.CharacterDetailsScreen
import com.example.cartoonapp.presentation.HomeScreen
import com.example.cartoonapp.viewmodels.CharacterDetailsViewModel
import com.example.cartoonapp.viewmodels.HomeViewModel
import com.example.domain.model.Result

@Composable
fun RootNavHost() {
    var navController = rememberNavController()

    val viewModel: HomeViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(viewModel.stateOfHomePage.value, navController) {index->
                navController.navigate(Screen.CharacterDetails.route + "/$index")

            }
        }
        composable(
            Screen.CharacterDetails.route + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                },
            ),
        ) {

            CharacterDetailsScreen(
                viewModel.stateOfHomePage.value.result.get(
                    it.arguments!!.getInt(
                        "id"
                    )
                )
            )
        }
    }
}