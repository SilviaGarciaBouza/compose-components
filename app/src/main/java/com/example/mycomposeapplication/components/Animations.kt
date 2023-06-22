package com.example.mycomposeapplication.components

import android.graphics.drawable.Icon
import android.widget.Button
import androidx.compose.animation.*
import androidx.compose.animation.core.Animation
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text

//Crossfade: cambiar entre distintos componentes sin animación
@Composable
fun Animation(){
Column() {
    var recentElement: Elements by rememberSaveable { mutableStateOf(value = Elements.ICON) }
    Button(onClick = { recentElement = randomElement() }) {
        Text(text = "Change between elements")
    }
    Crossfade(targetState = recentElement) {
        when (it) {
            Elements.ICON -> Icon(
                imageVector = Icons.Rounded.Star,
                contentDescription = "Icon",
                tint = Color.Yellow
            )
            Elements.BUTTON -> Button(onClick = {}) { Text(text = "This is a Button") }
            Elements.TEXT -> Text("This is a text")
            else -> Text(text = "Error")
        }
    }
}

}

enum class Elements() { ICON, TEXT, BUTTON, ERROR }


fun randomElement (): Elements {
    var myRandomNumber = (0..2).random()
    var myRandomElement: Elements = when(myRandomNumber) {
        0 -> Elements.ICON
        1 -> Elements.BUTTON
        2 -> Elements.TEXT
        else -> Elements.ERROR
    }
    return myRandomElement
}






//Animación de visibilidad
//al darle al botón se oculta o se enseña el box
@Composable
fun VisibilityAnimation() {
    Column() {


        Column() {
            var showBox by rememberSaveable { mutableStateOf(value = true) }
            Button(onClick = { showBox = !showBox }) {
                Text(text = "Mostrar-Ocultar")
            }
            if (showBox) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Magenta)
                )
            }
        }

        Spacer(modifier = Modifier.size(100.dp))
        Column() {
            var showBox2 by rememberSaveable { mutableStateOf(value = true) }
            Button(onClick = { showBox2 = !showBox2 }) {
                Text(text = "Mostrar-Ocultar")
            }
            //Por defecto desaparece hacia arriba
            //Si pones  enter = slideInHorizontally(), exit= slideOutHorizontally() desaparece de lado
            AnimatedVisibility(visible = showBox2, enter = slideInHorizontally(), exit= slideOutHorizontally()) {
                Box(modifier = Modifier
                    .size(100.dp)
                    .background(Color.Magenta)
                )
            }
        }
    }

}





//Animar el tamaño
@Composable
fun AnimationSize(){
  Column {
      var sizeFirstStatus by rememberSaveable { mutableStateOf(value = true)}
      val sizeFirstBox = if (sizeFirstStatus){100.dp}else{50.dp}
     //Box sin animación
      Box(modifier = Modifier
          .size(sizeFirstBox)
          .background(Color.Magenta)
          .clickable { sizeFirstStatus = !sizeFirstStatus })

     Spacer(modifier = Modifier.size(100.dp)) 

      
      //Box con animación
      var sizeSecondStatus by rememberSaveable { mutableStateOf(value = true) }
      val sizeSecondBox by animateDpAsState(
          targetValue = if(sizeSecondStatus){100.dp}else{50.dp},
          //tiempo q tuda la animación
          animationSpec = tween(durationMillis = 500),
          //acción a realizar cuando termina la animación
          finishedListener = { })
      Box(modifier = Modifier
          .size(sizeSecondBox)
          .background(Color.Magenta)
          .clickable { sizeSecondStatus = !sizeSecondStatus })
  }
}

    @Composable
    fun AnimationColor(){
    Column() {
        var stateColorFirstBox by rememberSaveable { mutableStateOf(true)}
        var firstColor = if (stateColorFirstBox){ Color.Blue} else{Color.Red}
        //Sin animación
        Box(modifier = Modifier
            .size(100.dp)
            .background(firstColor)
            .clickable { stateColorFirstBox = !stateColorFirstBox } )
        Spacer(modifier = Modifier.size(20.dp))



        var stateColorSecondBox by rememberSaveable { mutableStateOf(true)}
        val secondColor by animateColorAsState(
            targetValue = if (stateColorSecondBox){ Color.Blue} else{Color.Red}
        )
        //Con animación
        Box(modifier = Modifier
            .size(100.dp)
            .background(secondColor)
            .clickable { stateColorSecondBox = !stateColorSecondBox })
        Spacer(modifier = Modifier.size(20.dp))




        var stateColorTherddBox by rememberSaveable { mutableStateOf(true)}
        var showfourthBox by rememberSaveable { mutableStateOf(true) }
        val therdColor by animateColorAsState(
            targetValue = if (stateColorTherddBox){ Color.Blue} else{Color.Red},
            //tiempo q tarda en cambiar de color
            animationSpec = tween(durationMillis = 5000),
            //q haga algo cuando termine la animacion: q se habilite un botón.... en este caso q desaparezca el box 4
            finishedListener = {showfourthBox = false}
        )

        Box(modifier = Modifier
            .size(100.dp)
            .background(therdColor)
            .clickable { stateColorTherddBox = !stateColorTherddBox })

        if(showfourthBox){
            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.Yellow))
        }
    }

}