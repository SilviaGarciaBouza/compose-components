package com.example.mycomposeapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

//TextButton q tb puedes hacer un texto y q sea clicable
@Composable
fun MyTextButton() {
    Column() {


        Button(onClick = { /*TODO*/ }) {
            Text(text = "Hi!")
        }
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Hi")
        }
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Hi")
        }
    }
}


//que el botón se pueda clicar una vez y después ya no
@Composable
fun MyButton() {
    var enabled by rememberSaveable { mutableStateOf(true) }
    Column() {
        Button(
            onClick = { enabled = false }, enabled = enabled, colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Yellow,
                //colour para cuando está desabilitado
                disabledBackgroundColor = Color.Blue,
                disabledContentColor = Color.Red
            )
        ) {
            Text(text = "Hi!")
        }
    }
}

