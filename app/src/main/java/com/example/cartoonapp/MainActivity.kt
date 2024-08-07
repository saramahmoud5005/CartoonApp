package com.example.cartoonapp

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
 import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )
        setContent {
            val navController = rememberNavController()
//            HomeScreen(navController)
//            val viewModel  : HomeViewModel by viewModels()
//            val characterDetailsViewModel : CharacterDetailsViewModel by viewModels()
            RootNavHost(this)
        }
    }
}