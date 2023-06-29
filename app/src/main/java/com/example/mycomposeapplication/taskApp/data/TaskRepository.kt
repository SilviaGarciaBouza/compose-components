package com.example.mycomposeapplication.taskApp.data

import androidx.room.*
import com.example.mycomposeapplication.taskApp.UI.TaskModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepository @Inject constructor(private var taskDao: TaskDao) {
    //Los mismos elementos q en el TaskDao
    //1Genera el flow de la lista de tareas map para convertir un taskEntity en un taskmodel ti.()
    // lo del task entity q es igual al model para convertirlo.
    val tasks: Flow<List<TaskModel>> = taskDao.getTasks().map {item ->item.map{TaskModel(it.id, it.taskName,it.selectedTask)}}
    //2añade la nueva tarea, el nuevo item
    suspend fun addTask(taskModel: TaskModel){
        taskDao.addTask(TaskEntity(taskModel.id, taskModel.nameTask, taskModel.selected))
    }
    //3actualiza los datos de ese item
    suspend fun updateTask(taskModel: TaskModel){
        taskDao.updateTask(TaskEntity(taskModel.id, taskModel.nameTask, taskModel.selected))
    }
    //4borra un item, una tarea
    suspend fun removeTask(taskModel: TaskModel){
        taskDao.deleteTask(TaskEntity(taskModel.id, taskModel.nameTask, taskModel.selected))
    }
}