package com.example.mycomposeapplication

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp



//la funlambda devuelve un boolean
data class Item1( val tittle: String, var status: Boolean= false, var funlambda:(Boolean) -> Unit)

@Composable
fun getItemsInformation(titles: List<String>): List<Item1>{
    //.map recorre cada uno de los elementos de ka lista
    return titles.map {
        var status by rememberSaveable{ mutableStateOf(false) }
        Item1(
            tittle = it,
            status = status,
            funlambda = {status = it}
        )
    }
}



@Composable
fun MyCheckBoxesWhithText2(item: Item1){
    Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = item.status,
            onCheckedChange = { item.funlambda(!item.status) },
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = item.tittle)
    }
}







//la funlambda devuelve un boolean
data class Item(val tittle: String, var status: Boolean = false, var funlambda: (Boolean) -> Unit)

@Composable
fun MyCheckBoxesWhithText(item: Item) {
    Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = item.status,
            onCheckedChange = { item.funlambda(!item.status) },
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = item.tittle)
    }
}


@Composable
fun MyCheckBoxWhithText() {
    var mychecked by rememberSaveable { mutableStateOf(false) }
    Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = mychecked,
            onCheckedChange = { mychecked = !mychecked },
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Cyan,
                checkmarkColor = Color.Green
            )
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = "Ejemplo")
    }
}


@Composable
fun MyCheckBox() {
    var mychecked by rememberSaveable { mutableStateOf(false) }
    Checkbox(
        checked = mychecked,
        onCheckedChange = { mychecked = !mychecked },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Cyan,
            checkmarkColor = Color.Green
        )
    )
}
