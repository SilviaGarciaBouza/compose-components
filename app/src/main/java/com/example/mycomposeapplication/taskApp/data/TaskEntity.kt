package com.example.mycomposeapplication.taskApp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class TaskEntity (
    @PrimaryKey //le puedes poner algo atrue si qres q la autogenere, nos la tenemos con la fecha
    val id: Int,
    var taskName: String,
    var selectedTask: Boolean = false
        )