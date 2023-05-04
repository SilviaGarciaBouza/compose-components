package com.example.mycomposeapplication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun MyDropDownMenu() {
    var selectedText by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    val desserts = listOf<String>("Fruta", "Café", "tarta", "Helado", "Infusión")

    Column(Modifier.padding(12.dp)) {
        OutlinedTextField(value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth())
        //al estar expandido, se expande y al onDismissRequest, cuando se cierra q se cierre
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            desserts.forEach { desserts ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    selectedText = desserts
                }) {
                    Text(text = desserts)

                }
            }
        }
    }
}