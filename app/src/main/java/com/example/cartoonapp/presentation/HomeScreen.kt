package com.example.cartoonapp.presentation

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.cartoonapp.AnimatedLoadingGradient
import com.example.cartoonapp.Screen
import com.example.cartoonapp.ui.theme.CartoonAppTheme
import com.example.cartoonapp.viewmodels.HomeViewModel
import com.example.domain.model.Result
import androidx.activity.viewModels


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel, onClickItem: ()->Unit = {}){
//    val viewModel  : HomeViewModel by viewModels()

    val resultState = viewModel.stateOfHomePage.value

    LazyColumn(

    ) {
        Log.d("TAG1000", "HomeScreen: "+resultState.result)

        items(resultState.result){
            CharacterItem(it){
//                CharacterDetailsScreen(resultState.result.get(it.id-1))

                navController.navigate(Screen.CharacterDetails.route)
            }
        }
        if(resultState.isLoading){
            items(6){
                AnimatedLoadingGradient()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterItem(result: Result, onClickItem: ()->Unit = {}){
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .size(150.dp),

        onClick = onClickItem
    ) {
        Row(){
            Box(
                modifier = Modifier
                    .weight(0.40f)
                    .fillMaxSize()

            ) {
                AsyncImage(
                    model = result.image,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Box (
                modifier = Modifier
                    .weight(0.60f)
                    .fillMaxSize(),
            ){
                Column (
                    modifier = Modifier
                        .padding(10.dp),
                ){
                    Text(text = result.name,
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(
                            fontSize = 16.sp
                        )
                    )
                    Row (
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Box(modifier = Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(
                                color = if (result.status.equals("Alive")) Color.Green
                                else if (result.status.equals("Dead")) Color.Red else Color.Gray
                            ),
                        )
                        Spacer(modifier = Modifier.padding(3.dp))
                        Text(text = "${result.status} - ",
                            style = TextStyle(
                                fontSize = 14.sp
                            )
                        )
                        Text(text = result.species,
                            style = TextStyle(
                                fontSize = 14.sp
                            )
                        )
                    }
                    Spacer(modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth())
                    Text(text = "Last Known Location:",
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.Gray,
                        style = TextStyle(
                            fontSize = 16.sp
                        )
                    )
                    Text(text = result.location.name,
                        modifier = Modifier
                            .fillMaxWidth(),
                        style = TextStyle(
                            fontSize = 14.sp
                        )
                    )
                    Spacer(modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth())
                    Text(text = "Last seen in:",
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.Gray,
                        style = TextStyle(
                            fontSize = 16.sp
                        )
                    )
                    Text(text = "Pet Shop Employee",
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(
                            fontSize = 14.sp
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun _HomeScreenPreview(){
    CartoonAppTheme {
//        HomeScreen()
    }
}