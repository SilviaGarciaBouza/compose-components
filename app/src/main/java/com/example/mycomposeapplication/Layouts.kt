package com.example.mycomposeapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout


//    implementation"androidx.constraintlayout:constraintlayout-compose:1.0.1"
//Cadenas hay horizontal o vertical
//Primero los unes y luego creas la cadena
@Composable
fun MyConstraintlayout4() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxYellow, boxMagent, boxBlue) = createRefs()

        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                start.linkTo(parent.start)
                end.linkTo(boxMagent.start)
            })
        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagent) {
                start.linkTo(boxYellow.end)
                end.linkTo(boxBlue.start)
            })
        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                start.linkTo(boxMagent.end)
                end.linkTo(parent.end)
            })
        //packed todos juntos, spread separados igual... Se ponen los mienmbros y despues el estilo
        createHorizontalChain(boxYellow, boxMagent, boxBlue, chainStyle = ChainStyle.Spread)

    }
}


//barrera, desde esa barrera no puedes pintar nada.
// No puedes pintar desde el end de las cajas havia atrás
//    implementation"androidx.constraintlayout:constraintlayout-compose:1.0.1"

@Composable
fun MyConstraintlayout3() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxYellow, boxCyan, boxGreen) = createRefs()
        val barrier = createEndBarrier(boxCyan, boxYellow)

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                start.linkTo(parent.start, margin = 16.dp)

            })
        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Cyan)
            .constrainAs(boxCyan) {
                top.linkTo(boxYellow.bottom)
                start.linkTo(parent.start)
            })
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                start.linkTo(barrier)
            })
    }
}


//    implementation"androidx.constraintlayout:constraintlayout-compose:1.0.1"

@Composable
fun MyConstraintlayout2() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val boxRed = createRef()
        //línea horizontal: del 0-1(porcentaje de la pantalla dnd se va a poner
        val topGuide = createGuidelineFromTop(0.1f)
        //línea vertical
        val startGuide = createGuidelineFromStart(0.25f)
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                start.linkTo(startGuide)
                top.linkTo(topGuide)
            })
    }
}


//    implementation"androidx.constraintlayout:constraintlayout-compose:1.0.1"
@Composable
fun MyConstraintlayout1() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        //Crea id para los Boxes: y luego se klo asignas con el  constrainAs
        val (boxCian, boxYellow, boxGreen, boxMagenta, boxGray) = createRefs()

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Cyan)
            .constrainAs(boxCian) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                bottom.linkTo(boxCian.top)
                start.linkTo(boxCian.end)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                end.linkTo(boxCian.start)
                top.linkTo(boxCian.bottom)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta) {
                end.linkTo(boxCian.start)
                bottom.linkTo(boxCian.top)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.LightGray)
            .constrainAs(boxGray) {
                top.linkTo(boxCian.bottom)
                start.linkTo(boxCian.end)
            })

    }
}


//Lo usamos en MyLayoutsCombination()

@Composable
fun MySpacer(size: Int) {
    //Spacer(modifier = Modifier
    // .width(0.dp)
    //.height(30.dp))
    Spacer(
        modifier = Modifier
            .width(0.dp)
            .height(size.dp)
    )
}


@Composable
fun MyLayoutsCombination() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color.Cyan)
                .fillMaxWidth(),
            Alignment.Center
        ) {
            Text(text = "Texto1")
        }
        MySpacer(30)
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Red)
                    .weight(1f)
                    .fillMaxHeight(), Alignment.Center
            ) {
                Text(text = "Texto2")
            }
            Box(
                modifier = Modifier
                    .background(Color.Green)
                    .weight(1f)
                    .fillMaxSize(), Alignment.Center
            ) {
                Text(text = "Texto3")
            }
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color.Magenta)
                .fillMaxWidth(), Alignment.BottomCenter
        ) {
            Text(text = "Texto4")
        }
    }
}


@Composable
//es como column pero horizontal
fun MyRow() {
    //horizontalArrangement si no ocupan to el espacio deja margen entre ellos
    Row(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "texto1", modifier = Modifier
                .background(Color.Yellow)
                //.fillMaxHeight()
                .width(100.dp)
        )
        Text(
            text = "texto2", modifier = Modifier
                .background(Color.Blue)
                //.fillMaxHeight()
                .width(100.dp)
        )

        Text(
            text = "texto3", modifier = Modifier
                .background(Color.Yellow)
                //.fillMaxHeight()
                .width(100.dp)
        )

        Text(
            text = "texto4", modifier = Modifier
                .background(Color.Blue)
                //.fillMaxHeight()
                .width(100.dp)
        )

        Text(
            text = "texto5", modifier = Modifier
                .background(Color.Yellow)
                //.fillMaxHeight()
                .width(100.dp)
        )

        Text(
            text = "texto6", modifier = Modifier
                .background(Color.Blue)
                //.fillMaxHeight()
                .width(100.dp)
        )

        Text(
            text = "texto7", modifier = Modifier
                .background(Color.Yellow)
                //.fillMaxHeight()
                .width(100.dp)
        )

        Text(
            text = "texto8", modifier = Modifier
                .background(Color.Blue)
                //.fillMaxHeight()
                .width(100.dp)
        )

        Text(
            text = "texto9", modifier = Modifier
                .background(Color.Yellow)
                //.fillMaxHeight()
                .width(100.dp)
        )
        Text(
            text = "texto10", modifier = Modifier
                .background(Color.Blue)
                //.fillMaxHeight()
                .width(100.dp)
        )

    }
}


@Composable
//Columna vertical
fun MyColumn() {
    Column(
        //verticalArrangement para dejar spacios entre ellos(cuando no ocupan to)
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Texto1", modifier = Modifier
                .background(Color.Yellow)
                //.weight(1f) para trabajar con pesos
                .height(100.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Texto2", modifier = Modifier
                .background(Color.White)
                .height(100.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Texto3", modifier = Modifier
                .background(Color.Red)
                .height(100.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Texto4", modifier = Modifier
                .background(Color.Black)
                .height(100.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Texto5", modifier = Modifier
                .background(Color.Gray)
                .height(100.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Texto6", modifier = Modifier
                .background(Color.Green)
                .height(100.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Texto7", modifier = Modifier
                .background(Color.Magenta)
                .height(100.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Texto8", modifier = Modifier
                .background(Color.DarkGray)
                .height(100.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Texto9", modifier = Modifier
                .background(Color.Yellow)
                .height(100.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Texto10", modifier = Modifier
                .background(Color.White)
                .height(100.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Texto11", modifier = Modifier
                .background(Color.Red)
                .height(100.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Texto12", modifier = Modifier
                .background(Color.Cyan)
                .height(100.dp)
                .fillMaxWidth()
        )
    }
}


@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
                .background(Color.Cyan)
                .verticalScroll(rememberScrollState()), contentAlignment = Alignment.Center
        )
        {
            Text(text = "Hola")
        }
    }

}