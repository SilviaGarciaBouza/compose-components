package com.example.mycomposeapplication.taskApp.domain





import com.example.mycomposeapplication.taskApp.UI.TaskModel
import com.example.mycomposeapplication.taskApp.data.TaskRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class AddTaskUseCaseTest {

    @RelaxedMockK
    private lateinit var taskRepository: TaskRepository
    lateinit var addTaskUseCase: AddTaskUseCase


    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        addTaskUseCase = AddTaskUseCase(taskRepository)
    }

    @Test
    fun verifyAddTask() = runBlocking{
        val task=  TaskModel (nameTask = "task")


        //Given
       // coEvery { taskRepository.addTask(task)}

        //When
      addTaskUseCase(task)

        //Then
        coVerify(exactly = 1) { taskRepository.addTask(task) }
    }

}


