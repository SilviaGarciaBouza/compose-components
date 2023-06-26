package com.example.mycomposeapplication

import android.annotation.SuppressLint
import android.app.GameManager
import android.content.Intent
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
import androidx.compose.ui.window.Dialog
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
import com.example.mycomposeapplication.taskApp.UI.TaskScreem
import com.example.mycomposeapplication.taskApp.UI.TaskViewModel
import com.example.mycomposeapplication.ui.theme.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val logingViewModel: TaskViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background

                ) {


                    TaskScreem(logingViewModel)



/*

                    var selected by rememberSaveable { mutableStateOf("") }
                    var selectedFlavour by rememberSaveable { mutableStateOf("") }

                    val navigationController = rememberNavController()
                    NavHost(navController = navigationController, startDestination = MiRoutes.MiPantalla1.miRoute){
                        composable(MiRoutes.MiPantalla1.miRoute){AffirmationComb(navigationController)}
                        composable(MiRoutes.MiPantalla2.miRoute){ Art(navController = navigationController)}

                        composable(MiRoutes.MiPantalla3.miRoute){Cupcake(navigationController,CupcakeViewModel(),
                            selected,
                            { selected = it },
                            selectedFlavour,
                            { selectedFlavour = it })}

                        composable(MiRoutes.MiPantalla4.miRoute){ TipCalculator(navController = navigationController)}
                        composable(MiRoutes.MiPantalla5.miRoute){ChangeDice(navigationController)}
                        composable(MiRoutes.MIPantalla6.miRoute){ DiceRoll(navController = navigationController) }
                        composable(MiRoutes.MiPantalla7.miRoute){ DogWoof(navigationController) }
                        composable(MiRoutes.MiPantalla8.miRoute){ LogIg(navController = navigationController) }
                        composable(MiRoutes.MiPantalla9.miRoute){ Tuit(navigationController) }
                    }

*/



                }
            }
        }

    }




    sealed class MiRoutes(val miRoute: String){
        object MiPantalla1: MiRoutes("miPantalla1")
        object MiPantalla2: MiRoutes("miPantalla2")
        object MiPantalla3: MiRoutes("miPantalla3")
        object MiPantalla4: MiRoutes("miPantalla4")
        object MiPantalla5: MiRoutes("miPantalla5")
        object MIPantalla6: MiRoutes("miPantalla6")
        object MiPantalla7: MiRoutes("miPantalla7")
        object MiPantalla8: MiRoutes("miPantalla8")
        object MiPantalla9: MiRoutes("miPantalla9")

    }




}



































