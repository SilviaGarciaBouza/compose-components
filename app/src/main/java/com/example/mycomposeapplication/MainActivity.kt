package com.example.mycomposeapplication

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import android.util.Patterns
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
import kotlinx.coroutines.launch
import java.text.DecimalFormat

import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgs
import androidx.navigation.navArgument
import com.example.mycomposeapplication.components.*
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
                    //DogWoof()
                    //pro Navigation:2 crea la navegación
                    /*
                    val navigationController = rememberNavController()
                    NavHost(navController = navigationController, startDestination = Routes.Pantalla1.route){
                        composable(Routes.Pantalla1.route){Screem1(navigationController)}
                        composable(Routes.Pantalla2.route){Screem2(navigationController)}
                        composable(Routes.Pantalla3.route){Screem3(navigationController)}
                        composable(Routes.Pantalla4.route,
                        arguments = listOf(navArgument("age") {type = NavType.IntType})
                        ){backStackEntry->
                            Screem4(navigationController, backStackEntry.arguments?.getInt("age") ?: 0)}
                        composable(Routes.Pantalla5.route){Screem5(navigationController)}
                        composable(Routes.Pantalla6.route,
                            arguments = listOf(navArgument("name") {defaultValue = "S"})
                        ){backStackEntry->
                            Screem6(navigationController, backStackEntry.arguments?.getString("name"))}
                    }
                    */
                    //MyViewModelExample(myViewModel= MyViewModel())
                }
            }
        }
    }



}






























