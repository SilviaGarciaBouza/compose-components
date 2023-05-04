package com.example.mycomposeapplication

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

//Icon:https://fonts.google.com/icons
//    implementation 'androidx.compose.material:material-icons-extended:1.4.2'
@Composable
fun MyIcon() {
    Icon(imageVector = Icons.Rounded.Star, contentDescription = "Icon", tint = Color.Yellow)
}