package com.example.mycomposeapplication

import android.os.Bundle
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
                    MyViewModelExample(myViewModel= MyViewModel())
                }
            }
        }
    }
*/


//=0-  implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.3.1'
//    implementation "androidx.compose.runtime:runtime-livedata:1.2.1"

// 1- El ViewModel:
class MyViewModel : ViewModel() {
    private val _myEmail = MutableLiveData<String>()
    val myEmail: LiveData<String> = _myEmail

    private val _myPassword = MutableLiveData<String>()
    val myPassword: LiveData<String> = _myPassword

    private val _isMyVMenable = MutableLiveData<Boolean>()
    val isMyVMenable: LiveData<Boolean> = _isMyVMenable

    fun myChangeEmailPassword(email: String, password: String){
        _myEmail.value = email
        _myPassword.value = password
        _isMyVMenable.value = enabled(email, password)
    }
    fun enabled (email: String, password: String): Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6
    }
}

//3- Usa los datos, pasa el myViewModel en todo
@Composable
fun MyViewModelExample(myViewModel: MyViewModel) {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

        val myEmail: String by myViewModel.myEmail.observeAsState(initial = "")
        val myPassword: String by myViewModel.myPassword.observeAsState(initial = "")
        val isEnable: Boolean by myViewModel.isMyVMenable.observeAsState(false)

        TextField(value = myEmail , onValueChange = {
            myViewModel.myChangeEmailPassword(it, myPassword)

        })
        TextField(value = myPassword, onValueChange = {
            myViewModel.myChangeEmailPassword(myEmail, it)
        })
        Button( onClick = { }, enabled= isEnable,) {
            Text(text = "Go!")
        }
    }
}