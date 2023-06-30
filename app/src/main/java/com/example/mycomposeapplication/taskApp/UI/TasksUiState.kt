package com.example.mycomposeapplication.taskApp.UI

sealed interface TasksUiState {
    //object si no recibe datos, data class si sí los recibe
    object Loading:TasksUiState
    data class Error(val throwable: Throwable): TasksUiState
    data class Success(val tasksList: List<TaskModel>):TasksUiState
}