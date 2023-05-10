package com.example.mycomposeapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Art(){
    var stateArt by rememberSaveable{ mutableStateOf(R.drawable.androidparty) }
    var stateArtTextTitle by rememberSaveable{ mutableStateOf("Wonderful word") }
    var stateArtTextAuthor by rememberSaveable{ mutableStateOf("Autor: Magic Bell") }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(40.dp)
        .verticalScroll(rememberScrollState())
        , verticalArrangement = Arrangement.Center
        , horizontalAlignment = Alignment.CenterHorizontally) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            elevation = 20.dp,
            shape = MaterialTheme.shapes.small,
            backgroundColor = Color.White
        ) {
            Image(painter = painterResource(stateArt),
                contentDescription = null,
                alpha = 0.5f,
                //redondo, borde le pones grosor, color y el redondeado q en este caso lo mismo q la imagen
                modifier = Modifier
                    .padding(22.dp)
                    .fillMaxSize())
        }
        Spacer(modifier = Modifier.size(40.dp))
        Column( modifier = Modifier
            .background(color = Color.LightGray)
            .padding(22.dp)
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center ){
            Text(text = stateArtTextTitle, fontSize = 24.sp)
            Text(text = stateArtTextAuthor, fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.size(22.dp))
        Row() {
            Button(onClick = { when (stateArt){
                R.drawable.androidparty -> {
                    stateArt = R.drawable.dice_2
                    stateArtTextAuthor= "Autor:The only one Bear"
                    stateArtTextTitle= "White dice"

                }
                R.drawable.dice_2-> {
                    stateArt = R.drawable.avatar
                    stateArtTextAuthor= "Autor: Cat Dog"
                    stateArtTextTitle= "Me and my person"

                }
                R.drawable.avatar-> {
                    stateArt = R.drawable.androidparty
                    stateArtTextAuthor= "Autor: Magic Bell"
                    stateArtTextTitle= "Wonderful word"

                }
            } }, modifier = Modifier.weight(1f)) {
                Text(text ="Previous" )
            }
            Spacer(modifier = Modifier.size(22.dp))

            Button(onClick = {  when (stateArt){
                R.drawable.androidparty -> {
                    stateArt = R.drawable.avatar
                    stateArtTextAuthor= "Autor: Cat Dog"
                    stateArtTextTitle= "Me and my person"

                }
                R.drawable.avatar-> {
                    stateArt = R.drawable.dice_2
                    stateArtTextAuthor= "Autor: The only one Bear"
                    stateArtTextTitle= "White dice"

                }
                R.drawable.dice_2-> {
                    stateArt = R.drawable.androidparty
                    stateArtTextAuthor= "Autor: Magic Bell"
                    stateArtTextTitle= "Wonderful word"

                }
            } },modifier = Modifier.weight(1f)) {
                Text(text ="Next" )
            }
        }
    }
}