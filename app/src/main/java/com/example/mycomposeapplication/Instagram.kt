package com.example.mycomposeapplication

import android.app.Activity
import android.os.Bundle
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mycomposeapplication.ui.theme.MyComposeApplicationTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

/*class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background

                ) {
                    LogIg()
                }
            }
        }
    }
}
*/



@Composable
fun LogIg(navController: NavController) {
    Column(Modifier
        .fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(22.dp)
                .weight(1f)

        ) {
            HeaderLog(Modifier.align(Alignment.TopEnd))
            Spacer(modifier = Modifier.size(26.dp))
            BodyLog(Modifier.align(Alignment.Center))
            Spacer(modifier = Modifier.size(26.dp))
            footerLog(Modifier.align(Alignment.BottomCenter))
        }
        Button(
            onClick = { navController.navigate(MainActivity.MiRoutes.MiPantalla9.miRoute) },
            Modifier.padding(12.dp).align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Yellow
            )
        ) {
            Text(text = "Go to Tuit")
        }
    }
}

@Composable
fun footerLog(modifier: Modifier) {
    Column(modifier = modifier) {
        Divider(color = Color.Gray)
        Spacer(modifier = Modifier.size(16.dp))
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(text = "Don't have a account?", color = Color.Gray)
            Text(
                text = "Sign Up",
                modifier.padding(horizontal = 8.dp),
                color = Color(0xFF4EA8E9)
            )
        }
        Spacer(modifier = Modifier.size(16.dp))

    }
}

@Composable

fun BodyLog(modifier: Modifier) {
    var textLogEmail by rememberSaveable { mutableStateOf("") }
    var textLogPassword by rememberSaveable { mutableStateOf("") }
    var logingEnable by rememberSaveable{ mutableStateOf(false) }
    Column(modifier = modifier) {
        //Modifier en mayuscula pq es una instancioa del de la column
        Image(
            painter = painterResource(R.drawable.insta),
            contentDescription = null,
            Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = modifier.size(16.dp))
        TextFieldEmail(textLogEmail) {
            textLogEmail = it
            logingEnable= enableLogIn(textLogEmail, textLogPassword) }
        Spacer(modifier = modifier.size(8.dp))
        TextFieldPassword(textLogPassword) {
            textLogPassword = it
            logingEnable = enableLogIn(textLogEmail, textLogPassword)
        }
        Text(
            text = "Forgot password?",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4EA8E9),
            //tiene q ir Modifier en mayúscula pq usas el de la coumn yno el de bodyLog
            modifier = Modifier.align(Alignment.End)
        )
        Spacer(modifier = modifier.size(16.dp))
        ButtonLogIn(logingEnable)
        Spacer(modifier = modifier.size(16.dp))
        Row {
            Divider(modifier = modifier.weight(1f), color = Color.Gray)
            Text(text = "OR")
            Divider(modifier = modifier.weight(1f), color = Color.Gray)
        }
        Spacer(modifier = modifier.size(16.dp))
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Image(
                painter = painterResource(id = R.drawable.fb),
                contentDescription = "",
                modifier = modifier.size(22.dp)
            )
            Text(text = "Continue as Name Name", color = Color(0xFF4EA8E9))

        }
    }
}

@Composable
fun ButtonLogIn(loginEnable: Boolean) {
    Button(onClick = { /*TODO*/ },
        enabled= loginEnable,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF4EA8E9),
            disabledBackgroundColor = Color(0xFF78C8F9),
            contentColor = Color.White,
            disabledContentColor = Color.White
        )) {
        Text(text = "Log in")
    }
}

fun enableLogIn(email:String, password: String): Boolean{
    return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6
}

@Composable
fun TextFieldEmail(email: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = onTextChanged,
        enabled = true,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Email") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun TextFieldPassword(password: String, onTextChanged: (String) -> Unit) {
    var passwordVisibility by rememberSaveable { mutableStateOf(false) }
    TextField(
        value = password,
        onValueChange = onTextChanged,
        enabled = true,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Password") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        trailingIcon = {
            val image = if (passwordVisibility) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(imageVector = image, contentDescription = "Show password")
            }
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )

}




@Composable
fun HeaderLog(modifier: Modifier) {
    var activity = LocalContext.current as Activity
    Box(Modifier.fillMaxWidth()) {
        Icon(
            imageVector = Icons.Rounded.Close,
            contentDescription = "Close app",
            tint = Color.Black,
            modifier = modifier.clickable { activity.finish() }
        )
    }
}
