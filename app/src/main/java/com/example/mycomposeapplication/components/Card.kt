package com.example.mycomposeapplication

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        elevation = 12.dp,
        shape = MaterialTheme.shapes.small,
        backgroundColor = Color.Red,
        contentColor = Color.Cyan,
        border = BorderStroke(5.dp, Color.Green)
    ) {
        Text(text = "Ejmeplo")
    }
}