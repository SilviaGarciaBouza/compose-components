package com.example.mycomposeapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun DiceRoll(
    modifier: Modifier = Modifier
        .padding(20.dp)
        .fillMaxSize()
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var result by remember { mutableStateOf(1) }
        var imageResource = when (result) {
            1 -> painterResource(R.drawable.dice_1)
            2 -> painterResource(R.drawable.dice_2)
            3 -> painterResource(R.drawable.dice_3)
            4 -> painterResource(R.drawable.dice_4)
            5 -> painterResource(R.drawable.dice_5)
            6 -> painterResource(R.drawable.dice_6)
            else -> painterResource(id = R.drawable.dice_1)
        }
        Image(painter = imageResource, contentDescription = null)

        Button(onClick = { result = (1..6).random() }) {
            Text(text = "Roll")
        }

    }
}
