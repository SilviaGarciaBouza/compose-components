package com.example.mycomposeapplication

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BadgedBox
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyBadgeBox() {
    BadgedBox(badge = { Text(text = "100") }, Modifier.padding(12.dp)) {
        Icon(imageVector = Icons.Default.Star, contentDescription = "")
    }
}