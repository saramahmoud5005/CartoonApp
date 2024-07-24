package com.example.cartoonapp.presentation

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.cartoonapp.AnimatedLoadingGradient
import com.example.cartoonapp.HomeState
import com.example.cartoonapp.ui.theme.CartoonAppTheme
import com.example.domain.model.Result


@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun CharactersScreen(
    state: HomeState,
    navController: NavController,
    activity: Activity,
    onClickItem: (id: Int) -> Unit = {}
) {

    val resultState = state
    val windowClass = calculateWindowSizeClass(activity = activity)
    val showNavigationRail = windowClass.widthSizeClass == androidx.compose.material3.windowsizeclass.WindowWidthSizeClass.Compact
    var selectedIndexItem by rememberSaveable {
        mutableStateOf(0)
    }
    Row(){
        if(showNavigationRail){
            NavigationSideBar(
                items = items,
                selectedIndexItem = selectedIndexItem,
                onNavigate = {
                    println(items.get(selectedIndexItem).title)
                }
            )
        }
        LazyColumn() {
            Log.d("TAG1000", "HomeScreen: " + resultState.result)

            itemsIndexed(resultState.result) { index, item ->

                CharacterItem(index, item, onClickCard = { onClickItem(it) })
//            {
//                CharacterDetailsScreen(resultState.result.get(it.id-1))

//                navController.navigate(Screen.CharacterDetails.route)
//            }
            }
            if (resultState.isLoading) {
                items(6) {
                    AnimatedLoadingGradient()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterItem(index: Int, result: Result, onClickCard: (id: Int) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),

        onClick = {
            onClickCard(index)
            Log.d("TAG1000", "CharacterItem: "+index)
        }
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = result.image,
                contentDescription = null,
                modifier = Modifier.fillMaxSize().weight(0.40f)
            )
            Box(
                modifier = Modifier
                    .weight(0.60f)
                    .fillMaxSize(),
            ) {
                Column(
                    modifier = Modifier
                        .padding(10.dp),
                ) {
                    Text(
                        text = result.name,
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(
                            fontSize = 16.sp
                        )
                    )
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(10.dp)
                                .clip(CircleShape)
                                .background(
                                    color = if (result.status.equals("Alive")) Color.Green
                                    else if (result.status.equals("Dead")) Color.Red else Color.Gray
                                ),
                        )
                        Spacer(modifier = Modifier.padding(3.dp))
                        Text(
                            text = "${result.status} - ",
                            style = TextStyle(
                                fontSize = 14.sp
                            )
                        )
                        Text(
                            text = result.species,
                            style = TextStyle(
                                fontSize = 14.sp
                            )
                        )
                    }
                    Spacer(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth()
                    )
                    Text(
                        text = "Last Known Location:",
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.Gray,
                        style = TextStyle(
                            fontSize = 16.sp
                        )
                    )
                    Text(
                        text = "result.location.name",
                        modifier = Modifier
                            .fillMaxWidth(),
                        style = TextStyle(
                            fontSize = 14.sp
                        )
                    )
                    Spacer(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth()
                    )
                    Text(
                        text = "Last seen in:",
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.Gray,
                        style = TextStyle(
                            fontSize = 16.sp
                        )
                    )
                    Text(
                        text = "Pet Shop Employee",
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
fun _HomeScreenPreview() {
    CartoonAppTheme {
//        HomeScreen()
    }
}