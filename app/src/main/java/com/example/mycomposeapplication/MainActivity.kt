package com.example.mycomposeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycomposeapplication.ui.theme.MyComposeApplicationTheme

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*

import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycomposeapplication.ui.theme.Shapes
import java.text.DecimalFormat


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background

                ) {
                    //ChangeDice()
                    //DiceRoll()
                    // LogIg()
                    //Tuit()
                   // TipCalculator()
                    Art()


                }
            }
        }
    }




    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MyComposeApplicationTheme {
            Tuit()

        }
    }

    
    
    
    @Composable
    fun Art(){
        val image= painterResource(id = R.drawable.androidparty)
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(40.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                elevation = 20.dp,
                shape = MaterialTheme.shapes.small,
                backgroundColor = Color.White
            ) {
                Image(painter = image,
                    contentDescription = null,
                    alpha = 0.5f,
                    //redondo, borde le pones grosor, color y el redondeado q en este caso lo mismo q la imagen
                    modifier = Modifier
                        .padding(22.dp)
                        .fillMaxSize())
            }
            Spacer(modifier = Modifier.size(40.dp))
            Column( modifier = Modifier
                .background(color = Color.LightGray)
                .padding(22.dp)
                .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center ){
                Text(text = "Autor: Magic Bell", fontSize = 24.sp)
                Text(text = "Autor: Magic Bell", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.size(22.dp))
            Row() {
                Button(onClick = { /*TODO*/ }, modifier = Modifier.weight(1f)) {
                    Text(text ="Previous" )
                }
                Spacer(modifier = Modifier.size(22.dp))

                Button(onClick = { /*TODO*/ },modifier = Modifier.weight(1f)) {
                    Text(text ="Next" )
                }
            }
        }
    }
}






