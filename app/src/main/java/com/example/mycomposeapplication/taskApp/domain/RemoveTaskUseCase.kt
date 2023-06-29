package com.example.mycomposeapplication.taskApp.domain

import com.example.mycomposeapplication.taskApp.UI.TaskModel
import com.example.mycomposeapplication.taskApp.data.TaskRepository
import javax.inject.Inject

class RemoveTaskUseCase @Inject constructor(private val taskRepository: TaskRepository) {
    suspend fun invoke(taskModel: TaskModel){
        taskRepository.removeTask(taskModel)
    }
}
