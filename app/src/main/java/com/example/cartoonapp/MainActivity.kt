package com.example.cartoonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.cartoonapp.presentation.HomeScreen
import com.example.cartoonapp.viewmodels.CharacterDetailsViewModel
import com.example.cartoonapp.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
//            HomeScreen(navController)
//            val viewModel  : HomeViewModel by viewModels()
//            val characterDetailsViewModel : CharacterDetailsViewModel by viewModels()
            RootNavHost()
        }
    }
}