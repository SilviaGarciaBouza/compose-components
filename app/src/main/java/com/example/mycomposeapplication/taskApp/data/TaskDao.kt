package com.example.mycomposeapplication.taskApp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    //Genera la lista de tareas
    @Query("SELECT * from TaskEntity")
    fun getTasks(): Flow<List<TaskEntity>>//devuelve un flujo, no una lista
    //añade la nueva tarea, el nuevo item
    @Insert
    suspend fun addTask(item: TaskEntity)
    //actualiza los datos de ese item
    @Update
    suspend fun updateTask(item: TaskEntity)
    //borra un item, una tarea
    @Delete
    suspend fun deleteTask(item: TaskEntity)
}