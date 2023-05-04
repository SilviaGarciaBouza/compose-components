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



//Poner una imagen
@Composable
fun MyImageText() {
    val image = painterResource(R.drawable.androidparty)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            alpha = 0.5f,
            //redondo, borde le pones grosor, color y el redondeado q en este caso lo mismo q la imagen
            modifier = Modifier
                .clip(CircleShape)
                .border(5.dp, Color.Red, CircleShape)
        )
        // modifier = Modifier.clip(RoundedCornerShape(45f)))
    }
}

//Poner una imagen
@Composable
fun MyImageText0() {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = image,
            contentDescription = null,
            alpha = 0.5f,
            contentScale = ContentScale.Crop
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Happy Birthday", fontSize = 32.sp)

    }
}

@Composable
fun Greeting() {
    Surface(color = Color.Yellow) {
        Text(text = "Hi!")

    }
}
