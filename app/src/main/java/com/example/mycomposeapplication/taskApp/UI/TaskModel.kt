package com.example.mycomposeapplication.taskApp.UI
data class TaskModel (val id: Int = System.currentTimeMillis().hashCode(), var nameTask: String, var selected: Boolean= false)