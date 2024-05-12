package com.example.cartoonapp

import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
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
import com.example.cartoonapp.model.CharacterResponse
import com.example.cartoonapp.model.Info
import com.example.cartoonapp.model.Location
import com.example.cartoonapp.model.Origin
import com.example.cartoonapp.model.Result
import com.example.cartoonapp.ui.theme.CartoonAppTheme

@Composable
fun HomeScreen(results: List<Result>){
//    var chars : List<Result>  = listOf(
//        Result(
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
            .padding(8.dp)
            .fillMaxWidth(),
        onClick = {}
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ){
            val imageView : ImageView? =null
            Image(
                imageVector = Icons.Filled.Face,
                contentDescription = "character's image",
                modifier = Modifier.weight(0.30f)
            )
            Column (
                modifier = Modifier
                    .weight(0.70f)

            ){
                Text(text = result.name,
                    modifier = Modifier.fillMaxWidth().padding(top = 10.dp))
                Row (
                    modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        imageVector = Icons.Filled.Face,
                        contentDescription = "character's status",
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(text = "${result.status} - ",
                        style = TextStyle(
                            fontSize = 11.sp
                        ))
                    Text(text = result.species,
                        style = TextStyle(
                            fontSize = 11.sp
                        ))
                }
                Text(text = "Last Known Location",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Gray,
                    style = TextStyle(
                        fontSize = 10.sp
                    )
                )
                Text(text = result.location.name,
                    modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
                    style = TextStyle(
                        fontSize = 13.sp
                    ))

                Text(text = "Last seen in:",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Gray,
                    style = TextStyle(
                        fontSize = 10.sp
                    )
                )
                Text(text = "Pet Shop Employee",
                    modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
                    style = TextStyle(
                        fontSize = 13.sp
                    ))
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