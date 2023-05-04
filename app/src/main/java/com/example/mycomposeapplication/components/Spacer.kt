package com.example.mycomposeapplication

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//Lo usamos en MyLayoutsCombination()

@Composable
fun MySpacer0(size: Int) {
    //Spacer(modifier = Modifier
    // .width(0.dp)
    //.height(30.dp))
    Spacer(
        modifier = Modifier
            .width(0.dp)
            .height(size.dp)
    )
}

