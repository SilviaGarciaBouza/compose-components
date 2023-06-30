package com.example.mycomposeapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun Tuit(navController: NavController) {
    Column(Modifier.fillMaxSize()) {


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(color = Color.Black)
                .padding(28.dp)
        ) {


            Row() {
                StartTuit(1f)
                Spacer(modifier = Modifier.size(18.dp))
                EndTuit(3f)
            }
            Spacer(modifier = Modifier.height(20.dp))
            DividerTuitBotton()
        }
        Button(
            onClick = { navController.navigate(MainActivity.MiRoutes.MiPantalla10.miRoute) },
            Modifier.padding(12.dp).align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Yellow
            )
        ) {
            Text(text = "Go to Task app")
        }
    }
}


@Composable
fun DividerTuitBotton() {
    Divider(
        Modifier
            .fillMaxWidth()
        , color = Color.Gray
    )
}

@Composable
fun StartTuit(percentage: Float = 1f) {
    val image = painterResource(R.drawable.avatar)
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clip(CircleShape)
            .size(55.dp)
    )

}

@Composable
fun EndTuit(percentage: Float = 3f) {
    Column() {
        Row() {
            Text(text = "Name", color = Color.White, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "@UserName", color = Color.Gray)
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "1h", color = Color.Gray)
            Spacer(
                modifier = Modifier.weight(1f)
            )
            Icon()
        }
        Text(
            text = "Texto ejemplo de algún tuit que se podría introducir en este espacio y con alguna explicación o simplemente algún tuit que alguien haya escrito que sea importante o por pasar el tiempo",
            color = Color.White
        )
        Spacer(modifier = Modifier.height(14.dp))
        CardTuit()
        Spacer(modifier = Modifier.height(14.dp))
        Row() {
            BadgeBoxTuitBotton(R.drawable.ic_chat,R.drawable.ic_chat_filled, Color.Gray, Color.White ,"1")
            Spacer(modifier = Modifier.width(68.dp))
            BadgeBoxTuitBotton(R.drawable.ic_rt,R.drawable.ic_rt , Color.Gray, Color.Green,"1")
            Spacer(modifier = Modifier.width(68.dp))
            BadgeBoxTuitBotton(R.drawable.ic_like, R.drawable.ic_like_filled , Color.Gray, Color.Red,"1")
        }
    }

}

@Composable
fun CardTuit() {
    val image = painterResource(R.drawable.avatar)
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 2.dp,
        shape = MaterialTheme.shapes.small
    ) {
        Image(painter = image, contentDescription = "", contentScale = ContentScale.FillWidth)

    }
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BadgeBoxTuitBotton(icon: Int, iconClic: Int, color: Color, colorClic: Color, textNumber: String) {
    var isClick by rememberSaveable { mutableStateOf(false) }
    var textNumberclick = textNumber.toInt() + 1

    if (isClick == false) {
        BadgedBox(badge = { Text(text = textNumber,color = Color.Gray, modifier = Modifier.padding(start = 4.dp)) }) {
            Icon(painterResource(id = icon), contentDescription = "", tint = color, modifier = Modifier.clickable { isClick= !isClick })
        }
    } else {
        BadgedBox(badge = { Text(text = textNumberclick.toString(), color = colorClic, modifier = Modifier.padding(start = 4.dp)) }) {
            Icon(painterResource(id = iconClic), contentDescription = "", tint = colorClic, modifier = Modifier.clickable { isClick= !isClick })
        }
    }
}

@Composable
fun Icon() {
    Box() {
        Icon(
            painterResource(id = R.drawable.ic_dots),
            contentDescription = "Icon",
            tint = Color.White
        )
    }
}







