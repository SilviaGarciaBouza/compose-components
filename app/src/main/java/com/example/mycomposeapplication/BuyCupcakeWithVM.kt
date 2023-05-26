package com.example.mycomposeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycomposeapplication.ui.theme.MyComposeApplicationTheme
/*
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background

                ) {

                    var selected by rememberSaveable { mutableStateOf("") }
                    var selectedFlavour by rememberSaveable { mutableStateOf("") }
                    Cupcake(CupcakeViewModel(), selected,  {selected = it},selectedFlavour,{selectedFlavour=it})


                }
            }
        }

    }
*/



    @Composable
    fun Cupcake(viewModel: CupcakeViewModel,name: String, onItemSelected: (String) -> Unit, nameFlavour: String, onItemSelectedFlavour: (String) -> Unit) {
        var price = viewModel.cupcakeChange(name)
       Card(Modifier.fillMaxSize().padding(22.dp)) {

        Column(
               Modifier
                   .fillMaxSize()
                   .padding(22.dp)
        ) {


            Column(modifier = Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    RadioButton(
                        selected = name == "1 Cupcakes", onClick = { onItemSelected("1 Cupcakes") })
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "1 Cupcakes", Modifier.padding(12.dp))
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    RadioButton(
                        selected = name == "2 Cupcakes", onClick = { onItemSelected("2 Cupcakes") })
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "2 Cupcakes", Modifier.padding(12.dp))
                }

            }
            Spacer(modifier = Modifier.height(22.dp))
            Divider(
                Modifier
                    .fillMaxWidth()
                    .padding(12.dp), color = Color.Black
            )
            Spacer(modifier = Modifier.height(22.dp))

            Column(modifier = Modifier.fillMaxWidth()) {
                Row() {
                    RadioButton(
                        selected = nameFlavour == "Sugar",
                        onClick = { onItemSelectedFlavour("Sugar") })
                    Spacer(modifier = Modifier.width(8.dp))

                    Text(text = "Sugar", Modifier.padding(12.dp))
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    RadioButton(
                        selected = nameFlavour == "Chocolatte",
                        onClick = { onItemSelectedFlavour("Chocolatte") })
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Chocolatte", Modifier.padding(12.dp))
                }

            }

            Spacer(modifier = Modifier.height(22.dp))
            Divider(
                Modifier
                    .fillMaxWidth()
                    .padding(12.dp), color = Color.Black
            )
            Spacer(modifier = Modifier.height(22.dp))

            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {

                Text(text = "Total = ${price}")

                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Buy now!")
                }
            }
        }

        }
    }


/*


*/



class CupcakeViewModel: ViewModel(){

    val PRICE_PER_CUPCAKE= 10


    private val _price = MutableLiveData<Int>()
    val price: LiveData<Int> = _price


    fun cupcakeChange(myQuantity: String): Int{
        return  quantityCupcakes(myQuantity) * PRICE_PER_CUPCAKE

    }

    fun quantityCupcakes(myQuantity: String):Int{
        if (myQuantity == "1 Cupcakes"){
            return 1
        } else { return 2}
    }

}
