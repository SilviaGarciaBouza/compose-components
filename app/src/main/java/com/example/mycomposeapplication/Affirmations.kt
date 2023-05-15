package com.example.mycomposeapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

data class Afirmation(val sentence: String, val image: Int)
fun affirmations(): List<Afirmation> {
    return listOf<Afirmation>(
        Afirmation("El dado sí muestra 1", R.drawable.dice_1) ,
        Afirmation("El dado sí muestra 2", R.drawable.dice_2) ,
        Afirmation("El dado sí muestra 3", R.drawable.dice_3) ,
        Afirmation("El dado sí muestra 4", R.drawable.dice_4) ,
        Afirmation("El dado sí muestra 5", R.drawable.dice_5) ,
        Afirmation("El dado sí muestra 6", R.drawable.dice_6)
    )
}

@Composable
fun itemAffirmation(itemAffirmation: Afirmation){
    Card(
        Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
        Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(itemAffirmation.image), contentDescription = "Image dice 1")
            Text(text = itemAffirmation.sentence,
                Modifier
                    .background(Color.Magenta)
                    .padding(12.dp)
                    .fillMaxWidth(),
                color = Color.White
            )
        }

    }
}
@Composable
fun AffirmationsGrid(){
    LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
        // LazyColumn(){
        items(affirmations()) {
            itemAffirmation(itemAffirmation = it)

        }
    },  contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp))

}

@Composable
fun AffirmationsColumn(){
    LazyColumn(){
        items(affirmations()) {
            itemAffirmation(itemAffirmation = it)

        }
    }

}


@Composable
fun AffirmationComb(){
    Column(Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.weight(1f)){
            AffirmationsGrid()
        }
        Box(modifier = Modifier.weight(1f)){
            AffirmationsColumn()

        }

    }
}