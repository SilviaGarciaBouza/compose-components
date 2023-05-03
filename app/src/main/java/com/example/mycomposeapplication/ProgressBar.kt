package com.example.mycomposeapplication

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun MyProgressbar2() {
    var progressCircular by rememberSaveable { mutableStateOf(0.00f) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(progress = progressCircular)
        Row() {
            Button(onClick = { progressCircular -= 0.10f }) {
                Text(text = "Desminuye")

            }
            Button(onClick = { progressCircular += 0.10f }, Modifier.padding(horizontal = 12.dp)) {
                Text(text = "Aumenta")
            }
        }
    }
}


@Composable
fun MyProgressbar() {
    var visible by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (visible) {
            CircularProgressIndicator(color = Color.Magenta, strokeWidth = 10.dp)
            LinearProgressIndicator(color = Color.Magenta, backgroundColor = Color.Yellow)
        }
        Button(onClick = { visible = !visible }) {
            Text(text = "Pulsa para ver")

        }
    }
}
