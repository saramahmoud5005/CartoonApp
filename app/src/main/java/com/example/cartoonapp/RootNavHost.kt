package com.example.cartoonapp

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cartoonapp.presentation.CharacterDetailsScreen
import com.example.cartoonapp.presentation.CharactersScreen
import com.example.cartoonapp.presentation.HomeScreen
import com.example.cartoonapp.viewmodels.HomeViewModel

@Composable
fun RootNavHost(activity: Activity) {
    var navController = rememberNavController()

    val viewModel: HomeViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.Characters.route) {
            CharactersScreen(viewModel.stateOfHomePage.value, navController, activity) { index->
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