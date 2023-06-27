package com.example.mycomposeapplication.taskApp.UI

data class TaskModel (val id: Long = System.currentTimeMillis(), var nameTask: String, var selected: Boolean= false)