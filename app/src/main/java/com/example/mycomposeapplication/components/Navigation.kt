package com.example.mycomposeapplication.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mycomposeapplication.ui.theme.MyComposeApplicationTheme
/*
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

                    //pro Navigation:2 crea la navegación
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
                }
            }
        }
    }
    */


    //Pro Navigation:0    implementation "androidx.navigation:navigation-compose:2.5.3"
    //Pro Navigation:3 Crea las pantallas y pasales de argumentos un navcontrollery al clikar va del 1 al 2
    @Composable
    fun Screem1(navController: NavController){
        Box(modifier = Modifier.fillMaxSize().background(Color.Magenta)){
            Text(text = "pantalla1", Modifier.clickable{ navController.navigate(Routes.Pantalla2.route) })
        }
    }
    @Composable
    fun Screem2(navController: NavController){
        Box(modifier = Modifier.fillMaxSize().background(Color.Cyan)){
            Text(text = "pantalla2", Modifier.clickable{ navController.navigate(Routes.Pantalla3.route) })
        }
    }
    @Composable
    fun Screem3(navController: NavController){
        Box(modifier = Modifier.fillMaxSize().background(Color.Green)){
            // Text(text = "pantalla3",Modifier.clickable{ navController.navigate("pantalla4/age") })
            Text(text = "pantalla3", Modifier.clickable{ navController.navigate(Routes.Pantalla4.createRoute(35)) })

        }
    }
    @Composable
    fun Screem4(navController: NavController, age:Int) {
        Box(modifier = Modifier.fillMaxSize().background(Color.Yellow)) {
            Text(text = "pantalla4, ${age}", Modifier.clickable{ navController.navigate(Routes.Pantalla5.route)})
        }
    }
    @Composable
    fun Screem5(navController: NavController){
        Box(modifier = Modifier.fillMaxSize().background(Color.Gray)){
            Text(text = "pantalla5", Modifier.clickable{navController.navigate(Routes.Pantalla6.createRoute("Sil")) })
            //Así si no paso argumento y se queda lo predeterminado:
            //Text(text = "pantalla5", Modifier.clickable{navController.navigate(Routes.Pantalla6) })
        }
    }
    @Composable
    fun Screem6(navController: NavController, name:String?){
        Box(modifier = Modifier.fillMaxSize().background(Color.White)){
            Text(text = "pantalla6 ${name}")
        }
    }



    //Pro Navigation1: Crea cada objeto es una pantalla
    sealed class Routes(val route: String){
        object Pantalla1: Routes("pantalla1")
        object Pantalla2: Routes("pantalla2")
        object Pantalla3: Routes("pantalla3")
        object Pantalla4: Routes("pantalla4/{age}"){
            fun createRoute(age:Int) = "pantalla4/$age"
        }
        object Pantalla5: Routes("pantalla5")
        object Pantalla6: Routes("pantalla6?name={name}"){
            fun createRoute(name: String) = "pantalla6?name=$name"
        }
    }


   //}