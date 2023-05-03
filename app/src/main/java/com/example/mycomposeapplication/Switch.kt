package com.example.mycomposeapplication

import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color


@Composable
fun MySwitch() {
    var myChecked by rememberSaveable { mutableStateOf(false) }
    Switch(
        checked = myChecked,
        onCheckedChange = { myChecked = !myChecked },
        //si es false es q está deshabilitado:
        enabled = true,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Magenta,
            uncheckedTrackColor = Color.Blue,
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Cyan,
            checkedTrackAlpha = 0.8f,
            uncheckedTrackAlpha = 0.1f,
            //los siguientes según si están enable true o false
            disabledCheckedThumbColor = Color.Black,
            disabledCheckedTrackColor = Color.LightGray,
            disabledUncheckedThumbColor = Color.Red,
            disabledUncheckedTrackColor = Color.White
        )
    )
}
