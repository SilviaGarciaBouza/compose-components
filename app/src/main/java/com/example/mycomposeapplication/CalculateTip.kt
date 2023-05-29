package com.example.mycomposeapplication

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.DecimalFormat
import androidx.compose.material.icons.rounded.Money
import androidx.compose.material.icons.rounded.Percent
import androidx.navigation.NavController

@VisibleForTesting
@Composable
fun TipCalculator(navController: NavController) {
    Column(Modifier
        .fillMaxSize()) {


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(color = Color.Gray)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            var myTextTip by rememberSaveable { mutableStateOf("") }
            var myTip by rememberSaveable { mutableStateOf("") }
            var amount = myTextTip.toDoubleOrNull() ?: 0.00
            var tipPercent = myTip.toDoubleOrNull() ?: 0.00


            var myChecked by rememberSaveable { mutableStateOf(false) }
            val df = DecimalFormat("#.##")
            var calculate = amount * tipPercent / 100.00
            var calculateTip = df.format(calculate).toDouble()
            var calculateTipRound = Math.round(calculateTip)




            Text(
                text = "Calculadora de propinas",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.size(26.dp))

            OutlinedTextField(
                value = myTextTip,
                onValueChange = { myTextTip = it },
                label = { Text(text = "Introduce el precio", color = Color.Magenta) },
                // Icon(imageVector = Icons.Rounded.Star, contentDescription = "Icon", tint = Color.Yellow)
                leadingIcon = { Icon(imageVector = Icons.Rounded.Money, null) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Magenta,
                    unfocusedBorderColor = Color.Blue,
                    backgroundColor = Color.White
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                )
            )
            Spacer(modifier = Modifier.size(8.dp))

            OutlinedTextField(
                value = myTip,
                onValueChange = { myTip = it },
                label = { Text(text = "Introduce el porcentaje(ej:15)", color = Color.Magenta) },
                leadingIcon = { Icon(imageVector = Icons.Rounded.Percent, null) },

                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Magenta,
                    unfocusedBorderColor = Color.Blue,
                    backgroundColor = Color.White
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = Modifier.size(8.dp))

            Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Redondear Propina", color = Color.White, fontSize = 12.sp)
                Spacer(modifier = Modifier.width(98.dp))
                Switch(
                    checked = myChecked,
                    onCheckedChange = { myChecked = !myChecked },
                    //si es false es q está deshabilitado:
                    enabled = true
                )
            }

            Spacer(modifier = Modifier.size(26.dp))

            Text(
                text = if (myChecked) {
                    "La propina es ${calculateTip}$"
                } else {
                    "La propina es ${calculateTipRound}$"
                }, fontSize = 24.sp,
                fontWeight = FontWeight.Bold, color = Color.White
            )
        }
        Button(
            onClick = { navController.navigate(MainActivity.MiRoutes.MiPantalla5.miRoute) },
            Modifier
                .padding(12.dp)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Yellow
            )
        ) {
            Text(text = "Go to Change dice")
        }
    }
}