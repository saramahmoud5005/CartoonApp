package com.example.cartoonapp

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

private object Routes{
    const val HOME = "home"
    const val CHARACTERS = "characters"
//    const val CHARACTER_DETAILS = "characters_details"
    const val CHARACTER_DETAILS = "characterDetail/{${ArgParams.CHARACTER_ID}}"
}

private object ArgParams {
    const val CHARACTER_ID = "characterId"

    fun toPath(param: String) = "{${param}}"
}

sealed class Screen(val route : String, val navArguments : List<NamedNavArgument> = emptyList()){
    object CharacterDetails : Screen(Routes.CHARACTER_DETAILS)
    object Home : Screen(Routes.HOME)
    object Characters : Screen(Routes.CHARACTERS)
    object CharacterDetail : Screen(
        route = Routes.CHARACTER_DETAILS,
        navArguments = listOf(navArgument(ArgParams.CHARACTER_ID){
            type = NavType.StringType
        })
    ){
        fun createRoute(productId : String) = Routes.CHARACTER_DETAILS.replace(ArgParams.toPath(ArgParams.CHARACTER_ID),productId)
    }
}