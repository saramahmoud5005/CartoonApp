package com.example.cartoonapp.presentation

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cartoonapp.results
import com.example.cartoonapp.ui.theme.CartoonAppTheme
import com.example.domain.model.Result

@Composable
fun CharacterDetailsScreen(results: List<Result>){

//    val result : Result = results[1]
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(bottomStart = 60.dp, bottomEnd = 60.dp)
                )
                .background(color = Color.Gray)
                .weight(0.30f),
        ){
//            AsyncImage(
//                modifier = Modifier.fillMaxSize(),
//                model = result.image,
//                contentDescription = "character's image"
//            )
            Image(imageVector = Icons.Filled.Email, contentDescription = "",
                modifier = Modifier.fillMaxSize())
        }

        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                )
                .weight(0.70f),
        ){
            Column {
                Text(
                    text = "result.name",
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
                CustomRowForTwoElements(Icons.Filled.LocationOn,"result.location.name", Color.Red)

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
                        ).fillMaxSize().padding(top = 2.dp),
                    )

                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Alive - ",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(text = "Human",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold

                        )
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
                CustomRowForTwoElements(Icons.Filled.Face, "Female", Color.Black)

                Spacer(modifier = Modifier.height(10.dp))
                CustomRowForTwoElements(Icons.Filled.Face, "Female", Color.Black)

                Spacer(modifier = Modifier.height(10.dp))
                EpisodeItem()
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

@Composable
fun EpisodeItem(){
    Row(

    ){

    }
}