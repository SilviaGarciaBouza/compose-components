package com.example.mycomposeapplication.components

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import com.example.mycomposeapplication.R

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycomposeapplication.ui.theme.MyComposeApplicationTheme

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*

import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycomposeapplication.ui.theme.Shapes
import kotlinx.coroutines.launch
import java.text.DecimalFormat


//Particos de to lo anterior
//como una guia de tlf q en el header, arriba va enseñando si es marvel o dc, es decir el publisher
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyReciclerView3() {
    val context = LocalContext.current
    //1-obtienes un mapa q los separa por publisher

    val superhero: Map<String, List<SuperHeroRV2>> = superHero2().groupBy { it.sHPublished }
    //Deja entre ellos 8.dp
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        //2-añado:
        superhero.forEach { (publisher, mySuperhero) ->

            //4- añade el header
            stickyHeader {
                Text(text = publisher, modifier = Modifier.fillMaxWidth().background(color = Color.Magenta))
            }


            //3- le paso el mySuperhero
            items(mySuperhero) {
                //En el {} lo q quieres q haga al clicar
                ItemSuperHero2(
                    superHero2 = it,
                    { Toast.makeText(context, it.sHName, Toast.LENGTH_SHORT).show() })
            }
        }
    }
}
















// import androidx.compose.foundation.layout.*
// import androidx.compose.foundation.lazy.LazyColumn
// import androidx.compose.foundation.lazy.items

//1º hacemos la clase de los items
data class SuperHeroRV2(
    var sHName: String,
    var sHRealName: String,
    var sHPublished: String,
    @DrawableRes var sHImage: Int
)

//2º la fun q retorne la list de items
fun superHero2(): List<SuperHeroRV2> {
    return listOf(
        SuperHeroRV2("Spiderman", "Peter Parker", "Marvel", R.drawable.spiderman),
        SuperHeroRV2("Wolverine", "James H.", "Marvel", R.drawable.logan),
        SuperHeroRV2("Batman", "Bruce W.", "DC", R.drawable.batman),
        SuperHeroRV2("Thor", "Thor O.", "Marvel", R.drawable.thor),
        SuperHeroRV2("Flash", "Jay Garrick", "DC", R.drawable.flash),
        SuperHeroRV2("Green Lantern", "Alan", "DC", R.drawable.green_lantern),
        SuperHeroRV2("Wonder Woman", "Diana", "DC", R.drawable.wonder_woman)
    )
}

//3º Se dibuja el item
@Composable
fun ItemSuperHero2(superHero2: SuperHeroRV2, onClickItem: (SuperHeroRV2) -> Unit) {
    Card(
        border = BorderStroke(1.dp, Color.DarkGray),
        modifier = Modifier
            .width(200.dp)
            .clickable { onClickItem(superHero2) }
            .padding(top = 8.dp, bottom = 8.dp, end = 16.dp, start = 16.dp)) {
        Column() {

            Image(
                painterResource(id = superHero2.sHImage),
                contentDescription = "Superhero image",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(text = superHero2.sHName)
            Text(text = superHero2.sHRealName)
            Text(text = superHero2.sHPublished)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyReciclerViewGrill() {
    val context = LocalContext.current
    //fixed el nº de columnas, .Adptive(80.dp) si lo quieres por medida
    LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
        items(superHero2()) {
            //En el {} lo q quieres q haga al clicar
            ItemSuperHero2(
                superHero2 = it,
                { Toast.makeText(context, it.sHName, Toast.LENGTH_SHORT).show() })
        }
        //contentOaddings es el margen en los bordes
    }, contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp))

}


// import androidx.compose.foundation.layout.*
// import androidx.compose.foundation.lazy.LazyColumn
// import androidx.compose.foundation.lazy.items

//1º hacemos la clase de los items
data class SuperHeroRV(
    var sHName: String,
    var sHRealName: String,
    var sHPublished: String,
    @DrawableRes var sHImage: Int
)

//2º la fun q retorne la list de items
fun superHero(): List<SuperHeroRV> {
    return listOf(
        SuperHeroRV("Spiderman", "Peter Parker", "MArvel", R.drawable.spiderman),
        SuperHeroRV("Wolverine", "James H.", "Marvel", R.drawable.logan),
        SuperHeroRV("Batman", "Bruce W.", "DC", R.drawable.batman),
        SuperHeroRV("Thor", "Thor O.", "Marvel", R.drawable.thor),
        SuperHeroRV("Flash", "Jay Garrick", "DC", R.drawable.flash),
        SuperHeroRV("Green Lantern", "Alan", "DC", R.drawable.green_lantern),
        SuperHeroRV("Wonder Woman", "Diana", "DC", R.drawable.wonder_woman)
    )
}

//3º Se dibuja el item
@Composable
fun ItemSuperHero(superHero: SuperHeroRV, onClickItem: (SuperHeroRV) -> Unit) {
    Card(
        border = BorderStroke(1.dp, Color.DarkGray),
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable { onClickItem(superHero) }) {
        Column() {

            Image(
                painterResource(id = superHero.sHImage),
                contentDescription = "Superhero image",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(text = superHero.sHName)
            Text(text = superHero.sHRealName)
            Text(text = superHero.sHPublished)
        }
    }
}

//4ª ReciclerView
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyReciclerView1() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    //Deja entre ellos 8.dp
    Column {
        LazyColumn(state = rvState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(superHero()) {
                //En el {} lo q quieres q haga al clicar
                ItemSuperHero(superHero = it,
                    { Toast.makeText(context, it.sHName, Toast.LENGTH_SHORT).show() })
            }
        }
        //El botón aparece cuando se oculta el primer item
        val buttonRVShow by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }


        //indica que al pasar hacia el siguiente item te suma uno y al volver al anterior(todo con scrlo´) te resta uno
        rvState.firstVisibleItemScrollOffset

        //cuando haces click al botón va a la posición uno: con corrutina es need
        if (buttonRVShow) {
            Button(
                onClick = {
                    coroutineScope.launch {
                        rvState.animateScrollToItem(0)
                    } }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)) {
                Text(text = "Button")
            }
        }
    }
}


@Composable
fun MyReciclerView() {

    val myList = listOf("Pera", "Manzana", "Mango")

    LazyColumn {
        //Puedes ir poniendo uno por uno con "item"
        item { Text(text = "Ejemplo") }
        //o ponerlos todos juntos con "items"
        //(7) significa q se va a repetir 7 veces
        //Puedes usar it para saber la posicion
        items(7) { Text(text = "Este es el item número $it") }
        //Con la lista myList. it es cada elemento
        items(myList) { Text(text = "mi fruta es $it") }
        //header, el recicler y un footer
        item { Text(text = "Header") }
        items(myList) { Text(text = "Milista con la fruta $it") }
        item { Text(text = "Footer") }
    }
}