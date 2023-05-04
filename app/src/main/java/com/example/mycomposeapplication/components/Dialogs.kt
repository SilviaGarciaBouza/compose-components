package com.example.mycomposeapplication

import androidx.compose.runtime.Composable
import android.graphics.drawable.Icon
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Device
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.mycomposeapplication.ui.theme.MyComposeApplicationTheme

@Composable
fun MyDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(onDismissRequest = onDismiss) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                MyTittleDialog("Titulo del ejemplo")
                MyDivideDialog()
                var statusRadioButton by rememberSaveable { mutableStateOf("") }
                MyRadioButton(statusRadioButton, {statusRadioButton = it})
                MyDivideDialog()
                MyTextButtonsDialog()

            }
        }
    }

}

@Composable
fun MyDialog3(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(onDismissRequest = onDismiss) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                MyTittleDialog("Titulo del ejemplo")
                MyDivideDialog()
                MyItemDialog("ejemplo@gmail.com",R.drawable.avatar)
                MyItemDialog("ejemplo@gmail.com",R.drawable.avatar)
                MyItemDialog("ejemplo@gmail.com",R.drawable.avatar)
                MyDivideDialog()
                MyTextButtonsDialog()

            }
        }
    }

}

@Composable
fun MyTextButtonsDialog() {
    Row() {
        TextButton(onClick = { }) {
            Text(text = "Cancell")
        }
        TextButton(onClick = { }) {
            Text(text = "ok")
        }

    }
}

@Composable
fun MyItemDialog(textDialog: String, @DrawableRes imageDialog: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = imageDialog),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(text = textDialog, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun MyDivideDialog() {
    Divider(
        Modifier
            .fillMaxWidth()
            .padding(12.dp), color = Color.Red
    )
}

@Composable
fun MyTittleDialog(textDialog: String) {
    Text(
        text = textDialog,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        modifier = Modifier.padding(bottom = 10.dp)
    )
}


@Composable
fun MyDialog2(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss },
            //dismissOnBackPress si le das atras desaparece el dialog, dismissclicoutside q si le das atras desaparecee el dialog
            properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(20.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Este es un ejemplo")
            }
        }
    }
}

@Composable
fun MyDialog0(show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit) {
    Column() {
        if (show) {
            AlertDialog(onDismissRequest = { },
                title = { Text(text = "Título") },
                text = { Text(text = "Texto de ejemplo de la descripción del diálogo") },
                confirmButton = {
                    TextButton(onClick = { onConfirm() }) {
                        Text(text = "Abrir")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { onDismiss() }) {
                        Text(text = "Cerrar")
                    }
                })
        }
    }
}