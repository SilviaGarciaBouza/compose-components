package com.example.mycomposeapplication.taskApp.domain

import com.example.mycomposeapplication.taskApp.UI.TaskModel
import com.example.mycomposeapplication.taskApp.data.TaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(private var taskRepository: TaskRepository) {
    operator fun invoke(): Flow<List<TaskModel>>{
        return taskRepository.tasks
    }
}

