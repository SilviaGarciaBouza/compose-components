package com.example.mycomposeapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.RangeSlider
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyRangeSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(20.dp)) {
        var sliderValue by remember { mutableStateOf(0f..10f) }

        RangeSlider(
            values = sliderValue,
            onValueChange = { sliderValue = it },
            valueRange = 0f..10f,
            steps = 9
        )
        Text(text = "valor inucial = ${sliderValue.start}")
        Text(text = "valor inucial = ${sliderValue.endInclusive}")
    }
}


@Composable
fun MySlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderValue by rememberSaveable { mutableStateOf(0f) }
        var sliderComplete by rememberSaveable { mutableStateOf("") }
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            onValueChangeFinished = { sliderComplete = sliderValue.toString() },
            valueRange = 0f..10f,
            //steps es valueRange -2
            steps = 9,
            enabled = true
        )
        Text(text = sliderComplete)
    }
}


@Composable
fun MySlider0() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by rememberSaveable { mutableStateOf(0f) }
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        Text(text = sliderPosition.toString())

    }
}
