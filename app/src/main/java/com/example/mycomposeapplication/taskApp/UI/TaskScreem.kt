package com.example.mycomposeapplication.taskApp.UI

import android.widget.ProgressBar
import android.widget.Toast
import androidx.compose.ui.Alignment

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.example.mycomposeapplication.MainActivity
import kotlinx.coroutines.flow.collect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


@Composable
fun TaskScreem(navController: NavController,viewModel: TaskViewModel) {
   // fun TaskScreem(viewModel: TaskViewModel) {

        Column() {


            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(22.dp)
                    .weight(1f)
            ) {
                val lifecycle = LocalLifecycleOwner.current.lifecycle
                val uiState by produceState<TasksUiState>(
                    initialValue = TasksUiState.Loading,
                    key1 = lifecycle,
                    key2 = viewModel
                ) {
                    lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
                        viewModel.uiState.collect { value = it }
                    }
                }

                when (uiState) {
                    is TasksUiState.Error -> Toast.makeText(
                        LocalContext.current,
                        "Error, try again",
                        Toast.LENGTH_SHORT
                    ).show()

                    is TasksUiState.Loading -> CircularProgressIndicator(
                        color = Color.Magenta,
                        strokeWidth = 10.dp
                    )
                    is TasksUiState.Success -> {
                        TasksList((uiState as TasksUiState.Success).tasksList, viewModel)
                        val showDialog
                                : Boolean by viewModel.taskDialogShow.observeAsState(initial = true)
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(22.dp), Alignment.BottomEnd
                        ) {
                            FabAddTask(viewModel)
                        }
                        if (showDialog) {
                            DialogAddTask(
                                showDialog,
                                { viewModel.closeTaskDialogShow() },
                                // Modifier.align(Alignment.Center),
                                viewModel
                            )
                        }
                    }
                }
            }


    Button(onClick ={ navController.navigate(MainActivity.MiRoutes.MiPantalla1.miRoute) }, Modifier.padding(12.dp).
    align(Alignment.CenterHorizontally), colors = ButtonDefaults.buttonColors(
        backgroundColor = Color.Yellow
    )) {
        Text(text = "Go to Affirmations")
    }


}


}


//ReciclerView La lista se la añade desde el uiState
@Composable
fun TasksList(tasks: List<TaskModel>, viewModel: TaskViewModel) {
    //val taskList: List<TaskModel> = emptyList()
    // var taskList: List<TaskModel> = viewModel.listTasks
    //val context = LocalContext.current
    //Deja entre ellos 8.dp
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(tasks, key = { it.id }) {
            //En el {} lo q quieres q haga al clicar
            ItemTaskList(itemTask = it, viewModel)
        }
    }
}





@Composable
fun FabAddTask(viewModel: TaskViewModel) {
    FloatingActionButton(
        onClick = { viewModel.openTaskDialogShow() },
        backgroundColor = Color.Cyan,
        contentColor = Color.Black,
        modifier = Modifier
    ) {
        androidx.compose.material.Icon(Icons.Default.Add, contentDescription = "Add icon")
    }
}


@Composable
fun DialogAddTask(show: Boolean, onDismiss: () -> Unit, viewModel: TaskViewModel) {

    if (show) {
        Dialog(onDismissRequest = onDismiss) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "New task", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.size(16.dp))
                var myText by rememberSaveable { mutableStateOf("") }
                TextField(
                    value = myText,
                    onValueChange = { myText = it },
                    singleLine = true,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.size(16.dp))
                Button(
                    onClick = { viewModel.addTask(myText) },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Cyan
                    )
                ) {
                    Text(text = "Add new task")
                }
            }
        }


    }

}


//Item del reciclerView
@Composable
fun ItemTaskList(itemTask: TaskModel, viewModel: TaskViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            //lo siguiente para eliminar al mantener pulsado. tb se puede poner con doble click...
            .pointerInput(Unit) {
                detectTapGestures(onLongPress = {
                    viewModel.itemTaskRemove(
                        itemTask
                    )
                })
            },
        elevation = 8.dp,

        ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
            Text(
                text = itemTask.nameTask,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            )
            Checkbox(
                checked = itemTask.selected,
                onCheckedChange = { viewModel.changeSelectedCheckBoxTask(itemTask) },
            )
        }
    }
}



