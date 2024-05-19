package com.example.cartoonapp.presentation

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.cartoonapp.results
import com.example.cartoonapp.ui.theme.CartoonAppTheme
import com.example.cartoonapp.viewmodels.CharacterDetailsViewModel
import com.example.cartoonapp.viewmodels.HomeViewModel
import com.example.domain.model.Episode
import com.example.domain.model.Result

@Composable
fun CharacterDetailsScreen(result: List<Result>){



//    val viewModel  : HomeViewModel = viewModel()
//
//    val resultState = viewModel.stateOfHomePage.value
//    var results =resultState.result
    Log.d("TAG1000", "CharacterDetailsScreen: results = "+results)

//    val result : Result = results[1]

    val characterDetailsViewModel : CharacterDetailsViewModel = viewModel()

    val episodes = characterDetailsViewModel.stateOfCharacterDetailsPage.value
    Log.d("TAG1000", "CharacterDetailsScreen: episodes = "+episodes)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(50.dp)
                )
                .background(color = Color.Gray)
                .size(200.dp),
        ){
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = result.get(1).image,
                contentDescription = "character's image"
            )
//            Image(imageVector = Icons.Filled.Email, contentDescription = "",
//                modifier = Modifier.fillMaxSize())
        }
        Box(
            modifier = Modifier
//                .clip(
//                    RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
//                )
//                .weight(0.70f),
        ){
            Column (

            ){

                Text(
                    text = result.get(1).name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomRowForTwoElements(Icons.Filled.LocationOn,result.get(1).location.name, Color.Red)

                Spacer(modifier = Modifier.height(10.dp))
                Row (
                    modifier = Modifier.padding(start = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    Box(modifier = Modifier
                        .size(18.dp)
                        .clip(CircleShape)
                        .background(
                            color = Color.Green
//                            color = if (result.status.equals("Alive")) Color.Green
//                            else if (result.status.equals("Dead")) Color.Red else Color.Gray
                        )
                        .fillMaxSize()
                        .padding(top = 2.dp),
                    )

                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "${result.get(1).status} - ",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(text = result.get(1).species,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold

                        )
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
                CustomRowForTwoElements(Icons.Filled.Face, result.get(1).gender, Color.Black)

                Spacer(modifier = Modifier.height(10.dp))
                CustomRowForTwoElements(Icons.Filled.Face, "Female", Color.Black)

                Spacer(modifier = Modifier.height(10.dp))
                EpisodesItems(episodes.episodes)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun _PreviewCharacterDetailsScreen(){
    CartoonAppTheme {
        CharacterDetailsScreen(results)
    }
}

@Composable
fun CustomRowForTwoElements(imageVector: ImageVector, text: String, colorList:Color){
    Row (
        modifier = Modifier.padding(start = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(imageVector = imageVector,
            contentDescription = "character's location",
            modifier = Modifier.padding(top = 2.dp),
            tint = colorList

        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = text,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            ),
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EpisodesItems(episodes: List<Episode>){
    Box (
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.LightGray)
    ){
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Episodes:",
                color = Color.Black,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                ),
                fontSize = 20.sp,
            )
            LazyColumn (
                modifier = Modifier.fillMaxSize()
            ){
                val episodesSize = 5
                items(episodes){
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                                .clip(RoundedCornerShape(5.dp))
                        ) {
                            Row (
                                modifier = Modifier.fillMaxWidth()
                            ){
                                Text(
                                    text = "Episode Name:",
                                    color = Color.Black,
                                    modifier = Modifier,
                                    style = TextStyle(
                                        fontWeight = FontWeight.Bold,
                                    ),
                                    fontSize = 20.sp,
                                )
                                Spacer(modifier = Modifier.padding(2.dp))
                                Text(
                                    text = it.name,
                                    color = Color.Black,
                                    modifier = Modifier,
                                    fontSize = 20.sp,
                                )
                            }
                            Spacer(modifier = Modifier
                                .fillMaxHeight()
                                .padding(5.dp))
                            Row (
                                modifier = Modifier.fillMaxWidth()
                            ){
                                Text(
                                    text = "Episode Date:",
                                    color = Color.Black,
                                    modifier = Modifier,
                                    style = TextStyle(
                                        fontWeight = FontWeight.Bold,
                                    ),
                                    fontSize = 20.sp,
                                )
                                Spacer(modifier = Modifier.padding(2.dp))
                                Text(
                                    text = it.air_date,
                                    color = Color.Black,
                                    modifier = Modifier,
                                    fontSize = 20.sp,
                                )
                            }
                        }
//                    if(episodes < episodes.size){
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxWidth(),
                        ){
                            Text(
                                text = "-----------------------------------------------------------------",
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
//                    }
                }
            }
        }
    }
}