package com.example.cartoonapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.cartoonapp.model.Location
import com.example.cartoonapp.model.Origin
import com.example.cartoonapp.model.Result
import com.example.cartoonapp.ui.theme.CartoonAppTheme

@Composable
fun HomeScreen(){
    val viewModel  : HomeViewModel = viewModel()

    val results : List<Result> = viewModel.results.value
//    var results : List<Result>  = listOf(
//        Result(
//            " ",
//            listOf(""),
//            "",
//            1,
//            "",
//            Location(name = "", url = ""),
//            "",
//            Origin("", ""),
//            "",
//            "", "", ""
//        ), Result(
//            " ",
//            listOf(""),
//            "",
//            1,
//            "",
//            Location("", ""),
//            "",
//            Origin("", ""),
//            "",
//            "", "", ""
//        )
//    )
    LazyColumn(

    ) {
        items(results){
            CharacterItem(it)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterItem(result: Result){
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize().size(160.dp),

        onClick = {}
    ) {
        Row(
//            modifier = Modifier.fillMaxSize(),
//            verticalAlignment = Alignment.CenterVertically
        ){
//            val imageView : ImageView? =null
//            Image(
//                painter = rememberAsyncImagePainter(result.image),
//                contentDescription = "character's image",
//                modifier = Modifier.weight(0.30f)
//            )
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
//                Image(
//                imageVector = Icons.Filled.Info,
//                contentDescription = "character's image",
//                modifier = Modifier.fillMaxSize().size(150.dp)
//                )
            }
//            Spacer(modifier = Modifier.padding(5.dp).align(Alignment.CenterVertically).fillMaxHeight())
            Box (
                modifier = Modifier
                    .weight(0.60f)
                    .fillMaxSize(),
//                contentAlignment = Alignment.Center
            ){
                Column (
                    modifier = Modifier
                        .padding(10.dp),
//                    verticalArrangement = Arrangement.Center
                ){
                    Text(text = result.name,
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(
                            fontSize = 16.sp
                        )
                    )
                    Row (){
                        Icon(
                            imageVector = Icons.Filled.Face,
                            contentDescription = "character's status",
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text(text = "${result.status} - ",
                            style = TextStyle(
                                fontSize = 14.sp
                            ))
                        Text(text = result.species,
                            style = TextStyle(
                                fontSize = 14.sp
                            ))
                    }
                    Spacer(modifier = Modifier.padding(5.dp).fillMaxWidth())
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
//                            .padding(bottom = 10.dp),
                        style = TextStyle(
                            fontSize = 14.sp)
                    )
                    Spacer(modifier = Modifier.padding(5.dp).fillMaxWidth())
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
                        ))
                }
            }
            }
    }
}

@Preview(showBackground = true)
@Composable
fun _HomeScreenPreview(){
    CartoonAppTheme {
        HomeScreen()
    }
}