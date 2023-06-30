package com.example.mycomposeapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//Edit text sin el estado:
@Composable
fun MyTextFieldSinState(myText: String, onValueChanged: (String) -> Unit) {
    TextField(value = myText, onValueChange = { onValueChanged(it) })
}


@Composable
fun MyTextFieldAdvanc() {
    Column() {
        var myText by rememberSaveable { mutableStateOf("") }
        OutlinedTextField(
            value = myText,
            onValueChange = { myText = it },
            modifier = Modifier.padding(20.dp),
            label = { Text(text = "Introduce una palabra") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Magenta,
                unfocusedBorderColor = Color.Blue
            )
        )
    }
}


//Como un editText
@Composable
fun MyTextField() {
    var myText by rememberSaveable { mutableStateOf("") }
    TextField(value = myText, onValueChange = { myText = it })
}


@Composable
fun MyText() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {


        Text(text = "Esto es una prueba", color = Color.Red)
        Text(text = "Esto es una prueba", fontSize = 30.sp)
        Text(text = "Esto es una prueba", fontWeight = FontWeight.Bold)
        Text(text = "Esto es una prueba", fontWeight = FontWeight.Light)
        Text(text = "Esto es una prueba", fontFamily = FontFamily.Cursive)
        Text(text = "Esto es una prueba", textDecoration = TextDecoration.LineThrough)
        Text(text = "Esto es una prueba", textDecoration = TextDecoration.Underline)
        Text(
            text = "Esto es una prueba", textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.Underline, TextDecoration.LineThrough
                )
            )
        )
    }
}



@Composable
fun Greeting() {
    Surface(color = Color.Yellow) {
        Text(text = "Hi!", Modifier.testTag("component1"))
        Text(text = "hi, its me", Modifier.testTag("component2"))

    }
}
