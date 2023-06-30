package com.example.mycomposeapplication.taskApp.domain

import com.example.mycomposeapplication.taskApp.UI.TaskModel
import com.example.mycomposeapplication.taskApp.data.TaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AddTaskUseCase @Inject constructor(private val taskRepository: TaskRepository){
    suspend operator fun invoke(taskModel: TaskModel){
        taskRepository.addTask(taskModel)
    }
}
