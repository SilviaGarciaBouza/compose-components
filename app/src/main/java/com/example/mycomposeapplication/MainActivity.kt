package com.example.mycomposeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycomposeapplication.ui.theme.MyComposeApplicationTheme

import androidx.compose.foundation.Image
import androidx.compose.runtime.*

import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp



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
                    diceRoll()
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
    fun diceRoll(
        modifier: Modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var result by remember { mutableStateOf(1) }
            var imageResource = when (result) {
                1 -> painterResource(R.drawable.dice_1)
                2 -> painterResource(R.drawable.dice_2)
                3 -> painterResource(R.drawable.dice_3)
                4 -> painterResource(R.drawable.dice_4)
                5 -> painterResource(R.drawable.dice_5)
                6 -> painterResource(R.drawable.dice_6)
                else -> painterResource(id = R.drawable.dice_1)
            }
            Image(painter = imageResource, contentDescription = null)

            Button(onClick = { result = (1..6).random() }) {
                Text(text = "Roll")
            }

        }
    }

}





