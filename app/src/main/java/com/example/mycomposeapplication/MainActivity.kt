package com.example.mycomposeapplication

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.compose.material.MaterialTheme
import androidx.compose.foundation.background
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*

import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycomposeapplication.components.MyReciclerView3
import kotlinx.coroutines.launch
import java.text.DecimalFormat

import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.OpenInBrowser
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import com.example.mycomposeapplication.components.MyScaffold1
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import androidx.compose.foundation.lazy.LazyColumn
import com.example.mycomposeapplication.components.MyReciclerView1
import com.example.mycomposeapplication.ui.theme.*


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
                    // Art()
                    //MyReciclerView1()
                    //MyReciclerView3()
                    // MyScaffold1()
                    //AffirmationComb()
                    DogWoof()


                }
            }
        }
    }


    @Composable
    fun MyTopAppBarDog() {
        TopAppBar(
            title = { Text(text = "Woof") },
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.secondary,
            elevation = 4.dp,
        )
    }


    data class Dog(val name: String, val photo: Int, val years: Int, val description: String)

    fun Dogs(): List<Dog> {
        return listOf(
            Dog("Bimba", R.drawable.perro1, 2, "She like play with the ball"),
            Dog("Lúa", R.drawable.perro2, 8, "She sleep all day"),
            Dog("Toy", R.drawable.perro3, 5, "He is wonderfull"),
            Dog("Bimba", R.drawable.perro14, 9, "He like icecream"),
            Dog("Popi", R.drawable.perro5, 1, "He is fat"),
            Dog("Avellana", R.drawable.perro6, 3, "She sleep all day"),
            Dog("Panter", R.drawable.perro7, 8, "She like play whit the ball"),
            Dog("Fosquito", R.drawable.perro8, 2, "He is fat"),
            Dog("Bimba", R.drawable.perro9, 1, "She like play whit the ball"),
            Dog("Piruleta", R.drawable.perro10, 7, "She sleep all day"),
            Dog("Bollicao", R.drawable.perro11, 2, "He is fat"),
            Dog("Cortina", R.drawable.perro12, 9, "She like play whit the ball"),
            Dog("Tableta", R.drawable.perro13, 4, "She sleep all day")


        )
    }

    @Composable
    fun ItemDog(dog: Dog) {
        var expanded by remember { mutableStateOf(false) }
        Card(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp)
                .background(MaterialTheme.colors.surface)
        ) {
            Column(
                //animación para expandirse como resorte
                modifier = Modifier.animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
            ) {


                Row(
                    Modifier
                        .fillMaxSize()
                        .padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Row(Modifier.weight(1f)) {
                        Image(
                            painter = painterResource(dog.photo), contentDescription = "Dog photo",
                            Modifier
                                .clip(CircleShape)
                                .size(50.dp), contentScale = ContentScale.Crop
                        )
                        Column(Modifier.padding(horizontal = 20.dp)) {
                            Text(
                                text = dog.name,
                                color = MaterialTheme.colors.onPrimary,
                                fontWeight = Bold
                            )
                            Text(
                                text = "${dog.years} years old",
                                color = MaterialTheme.colors.onPrimary
                            )
                        }
                    }
                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(
                            imageVector = if (expanded) {
                                Icons.Filled.ExpandMore
                            } else {
                                Icons.Filled.ExpandLess
                            },
                            contentDescription = "Icon",
                            tint = MaterialTheme.colors.onPrimary,
                        )

                    }
                }
                if (expanded) {
                    DogDescription(dog = dog)
                }
            }
        }
    }

    @Composable
    fun DogDescription(dog: Dog) {
        Column(Modifier.padding(12.dp)) {
            Text(
                text = "Description", color = MaterialTheme.colors.onPrimary,
                fontWeight = Bold
            )
            Text(text = dog.description)
        }
    }

    @Composable
    fun DogWoof() {
        Column() {
            MyTopAppBarDog()
            LazyColumn(
                Modifier
                    .background(MaterialTheme.colors.background)
                    .padding(top = 12.dp), verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                items(Dogs()) {
                    ItemDog(dog = it)
                }

            }
        }

    }


}































