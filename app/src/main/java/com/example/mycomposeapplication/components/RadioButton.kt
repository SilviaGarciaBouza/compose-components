package com.example.mycomposeapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/*
var selected by rememberSaveable { mutableStateOf("") }
MyRadioButton (selected,  {selected = it})

*/


@Composable
fun MyRadioButton(name: String, onItemSelected: (String) -> Unit) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Row() {
            RadioButton(
                selected = name == "Perros", onClick = { onItemSelected("Perros") })
            Text(text = "Perros", Modifier.padding(12.dp))
        }
        Row() {
            RadioButton(
                selected = name == "Gatos", onClick = { onItemSelected("Gatos") })
            Text(text = "Gatos", Modifier.padding(12.dp))
        }
        Row() {
            RadioButton(
                selected = name == "Abejas", onClick = { onItemSelected("Abejas") },
            )
            Text(text = "Abejas", Modifier.padding(12.dp))
        }
    }
}


@Composable
fun MyRadioButton2() {
    Row() {
        var mySelected by rememberSaveable { mutableStateOf(true) }
        RadioButton(
            selected = mySelected,
            enabled = true,
            onClick = { mySelected = !mySelected },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Cyan,
                unselectedColor = Color.Green,
                disabledColor = Color.Red
            )
        )
        Text(text = "Texto 1", Modifier.padding(12.dp))
    }
}