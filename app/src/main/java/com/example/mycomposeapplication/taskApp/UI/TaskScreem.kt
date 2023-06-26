package com.example.mycomposeapplication.taskApp.UI

import androidx.compose.runtime.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun TaskScreem(viewModel: TaskViewModel) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(22.dp)) {
        Box(modifier = Modifier.fillMaxSize(), Alignment.BottomEnd) {
            FabAddTask()
        }
        DialogAddTask(true, { } ,{}, Modifier.align(Alignment.Center))

    }
}




@Composable
fun FabAddTask() {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                backgroundColor = Color.Cyan,
                contentColor = Color.Black,
                modifier = Modifier
            ) {
                androidx.compose.material.Icon(Icons.Default.Add, contentDescription = "Add icon")
            }
        }



@Composable
fun DialogAddTask (show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit,align: Modifier){

    if (show) {
        Dialog(onDismissRequest = onDismiss) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "New task", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.size(16.dp))
                var myText by rememberSaveable { mutableStateOf("") }
                TextField(value = myText, onValueChange = { myText = it }, singleLine = true, maxLines = 1)
                Spacer(modifier = Modifier.size(16.dp))
                Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Cyan)) {
                    Text(text = "Add new task")
                }

            }
        }
    }

}
