package com.example.mycomposeapplication.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycomposeapplication.R


@Composable
fun MyImage() {
    Image(
        painter = painterResource(R.drawable.avatar),
        contentDescription = null,
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
    )
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
