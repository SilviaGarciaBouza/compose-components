package com.example.mycomposeapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
fun ChangeDice(navController: NavController) {

    var painterResourcesDice by remember { mutableStateOf(R.drawable.dice_1) }
    var textRoll by remember { mutableStateOf("Click and go to Dice 2") }
    var currentStep by remember { mutableStateOf(1) }
Column(modifier = Modifier.fillMaxSize()) {


    Column(
        modifier = Modifier.fillMaxWidth().weight(1f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(text = textRoll)
        Image(
            painter = painterResource(painterResourcesDice),
            contentDescription = null,
            modifier = Modifier.clickable {
                when (painterResourcesDice) {
                    R.drawable.dice_1 -> {
                        painterResourcesDice = R.drawable.dice_2
                        textRoll = "Click and go to Dice 3"
                    }
                    R.drawable.dice_2 -> {
                        painterResourcesDice = R.drawable.dice_3
                        textRoll = "Click and go to Dice 4"
                    }
                    R.drawable.dice_3 -> {
                        painterResourcesDice = R.drawable.dice_4
                        textRoll = "Click and go to Dice 1"
                    }
                    R.drawable.dice_4 -> {
                        painterResourcesDice = R.drawable.dice_1
                        textRoll = "Click and go to Dice 2"
                    }
                }
            }
        )
    }
    Button(
        onClick = { navController.navigate(MainActivity.MiRoutes.MIPantalla6.miRoute) },
        Modifier.padding(12.dp).align(Alignment.CenterHorizontally),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Yellow
        )
    ) {
        Text(text = "Go to Dice roll")
    }
}
}

