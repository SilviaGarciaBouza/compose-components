package com.example.mycomposeapplication.components

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mycomposeapplication.Tuit
import com.example.mycomposeapplication.ui.theme.MyComposeApplicationTheme
import kotlinx.coroutines.launch

//Es un layout, como el esqueleto de una pantalla q permite añadir componentes y los adapta facil a la pantalla

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyScaffold() {
    var stateScaf = rememberScaffoldState()
    var coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = { MyTopAppBar({coroutineScope.launch { stateScaf.snackbarHostState.showSnackbar("Clicked $it") }})},
        scaffoldState = stateScaf,
        bottomBar = {MyBottomNavigation()},
        floatingActionButton = {MyFAB()},
        //la posicion puede ser center o end
        floatingActionButtonPosition = FabPosition.End,
        //si es true lo incrusta en la barra de abajo
        isFloatingActionButtonDocked = false
    ) {
    }
}



@Composable
fun MyTopAppBar(onClicIcon: (String) -> Unit) {
    TopAppBar(
        title = { Text(text = "My App Name") },
        backgroundColor = Color.DarkGray,
        contentColor = Color.White,
        elevation = 4.dp,
        //a la izda:
        navigationIcon = {
            IconButton(onClick = { onClicIcon("back") }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
            }
        },
        //a la dcha:
        actions = {
            IconButton(onClick = { onClicIcon("Search") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
            }
            IconButton(onClick = { onClicIcon("Dangerous") }) {
                Icon(imageVector = Icons.Filled.Dangerous, contentDescription = "Dangerous")
            }
        }

    )

}


@Composable
fun MyBottomNavigation() {
    var index by remember { mutableStateOf(0) }
    BottomNavigation(backgroundColor = Color.DarkGray, contentColor = Color.White) {
        BottomNavigationItem(
            selected = index == 0,
            onClick = { index = 0 },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            },
            label = { Text(text = "Home") }
        )
        BottomNavigationItem(
            selected = index == 1,
            onClick = { index = 1 },
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favourite"
                )
            },
            label = { Text(text = "Favourite") }
        )
        BottomNavigationItem(
            selected = index == 2,
            onClick = { index = 2 },
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Personal"
                )
            },
            label = { Text(text = "Personal") }
        )
    }
}



@Composable
fun MyFAB(){
    FloatingActionButton(onClick = { /*TODO*/ }, backgroundColor = Color.Cyan, contentColor = Color.Black) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
    }
}




//
//
//
//2ºDrawer

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeApplicationTheme {
        //Tuit(navController = NavController())

    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyScaffold1() {
    var stateScaf = rememberScaffoldState()
    var coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            MyTopAppBar1(
                onClicIcon = {
                    coroutineScope.launch {
                        stateScaf.snackbarHostState.showSnackbar(
                            "Clicked $it"
                        )
                    }
                },
                //el lambda para abrit el menu
                onDrawIcon = { coroutineScope.launch { stateScaf.drawerState.open() } }
            )
        },
        scaffoldState = stateScaf,
        bottomBar = { MyBottomNavigation1() },
        floatingActionButton = { MyFAB1() },
        //la posicion puede ser center o end
        floatingActionButtonPosition = FabPosition.End,
        //si es true lo incrusta en la barra de abajo
        isFloatingActionButtonDocked = false,
        //2- Pasas el MyDraw
        //%- Le pones el lambda para cerrar
        drawerContent = { MyDraw({ coroutineScope.launch { stateScaf.drawerState.close() } }) },
        //3-le das desde el margen izdo hacia el centro y aparece la mantallita
        drawerGesturesEnabled = true
    ) {
    }
}



@Composable
//onDrawIcon para pasarla cuando haces clic en el menu
fun MyTopAppBar1(onClicIcon: (String) -> Unit, onDrawIcon: () -> Unit) {
    TopAppBar(
        title = { Text(text = "My App Name") },
        backgroundColor = Color.DarkGray,
        contentColor = Color.White,
        elevation = 4.dp,
        //a la izda:
        navigationIcon = {
            IconButton(onClick = { onDrawIcon() }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
            }
        },
        //a la dcha:
        actions = {
            IconButton(onClick = { onClicIcon("Search") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
            }
            IconButton(onClick = { onClicIcon("Dangerous") }) {
                Icon(imageVector = Icons.Filled.Dangerous, contentDescription = "Dangerous")
            }
        }

    )

}

@Composable
fun MyBottomNavigation1() {
    var index by remember { mutableStateOf(0) }
    BottomNavigation(backgroundColor = Color.DarkGray, contentColor = Color.White) {
        BottomNavigationItem(
            selected = index == 0,
            onClick = { index = 0 },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            },
            label = { Text(text = "Home") }
        )
        BottomNavigationItem(
            selected = index == 1,
            onClick = { index = 1 },
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favourite"
                )
            },
            label = { Text(text = "Favourite") }
        )
        BottomNavigationItem(
            selected = index == 2,
            onClick = { index = 2 },
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Personal"
                )
            },
            label = { Text(text = "Personal") }
        )
    }
}

@Composable
fun MyFAB1() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        backgroundColor = Color.Cyan,
        contentColor = Color.Black
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
    }
}


//1-Crea lo q se va a ver en la pantallita q sale de la izda
//4Para q se cierre y en cada uno le pasas en clicable el lambda
@Composable
fun MyDraw(onCloseDrawer:()->Unit) {
    Column(Modifier.padding(8.dp)) {
        Text(
            text = "First Option", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() }
        )
        Text(
            text = "Second Option", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() }

        )
        Text(
            text = "Next Option", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() }

        )
        Text(
            text = "Next Option", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() }

        )
        Text(
            text = "Next Option", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() }

        )
    }
}


