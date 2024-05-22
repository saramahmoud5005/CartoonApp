package com.example.cartoonapp

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cartoonapp.presentation.CharacterDetailsScreen
import com.example.cartoonapp.presentation.HomeScreen
import com.example.cartoonapp.viewmodels.HomeViewModel
import com.example.domain.model.Result

@Composable
fun RootNavHost(viewModel: HomeViewModel){
    var navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(Screen.Home.route){
            HomeScreen(navController, viewModel){
//                navController.currentBackStackEntry?.arguments =
//                    Bundle().apply {
//                        putParcelable("result", Result)
//                    }
            }
        }
        composable(Screen.CharacterDetails.route,
            arguments = listOf(navArgument("result") { type = NavType.ParcelableType(Result::class.java)})){
//            var resultModel = navController.previousBackStackEntry?.arguments?.getParcelable<Result>("result")
//            val result = navController.currentBackStackEntry?.arguments?.putParcelable("result",Result)
//            navController.navigate(Screen.CharacterDetails.route)
            var resultModel = it.arguments?.getParcelable<Result>("result")
            CharacterDetailsScreen(resultModel!!)
        }
    }
}