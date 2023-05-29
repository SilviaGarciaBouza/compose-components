package com.example.mycomposeapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DiceRoll(navController: NavController) {
    Column(modifier = Modifier.padding(20.dp)
        .fillMaxSize()) {


    Column(
        Modifier.fillMaxWidth().weight(1f),
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
        Button(
            onClick = { navController.navigate(MainActivity.MiRoutes.MiPantalla7.miRoute) },
            Modifier.padding(12.dp).align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Yellow
            )
        ) {
            Text(text = "Go to Woof")
        }
    }
}
