package com.example.mycomposeapplication.UI

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.compose.material.ExperimentalMaterialApi
import com.example.mycomposeapplication.taskApp.UI.TaskModel
import com.example.mycomposeapplication.taskApp.UI.TaskViewModel
import com.example.mycomposeapplication.taskApp.UI.TasksUiState
import com.example.mycomposeapplication.taskApp.domain.AddTaskUseCase
import com.example.mycomposeapplication.taskApp.domain.GetTasksUseCase
import com.example.mycomposeapplication.taskApp.domain.RemoveTaskUseCase
import com.example.mycomposeapplication.taskApp.domain.UpdateTaskUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import com.example.mycomposeapplication.taskApp.UI.TasksUiState.Success
import io.mockk.coVerify
import io.mockk.every
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.invoke
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.hamcrest.core.Every
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class TaskViewModelTest{
  //Crea la instancia del viewModel y para ello mokeas los casos de uso q tiene el viewmodel injectados:
  @RelaxedMockK
  private lateinit var getTasksUseCase: GetTasksUseCase

  @RelaxedMockK
  private lateinit var addTaskUseCase: AddTaskUseCase

  @RelaxedMockK
  private lateinit var removeTaskUseCase: RemoveTaskUseCase

  @RelaxedMockK
  private lateinit var updateTaskUseCase: UpdateTaskUseCase


  private lateinit var taskViewModel: TaskViewModel

  //Se crea esta regla(escribir tal cual)
  @get:Rule
  var rule:InstantTaskExecutorRule = InstantTaskExecutorRule()

   //En before, se pone lo q se hace antes de empezar el test
  // inicia del mokitoy el viewModel
  @Before
  fun onBefore(){
   MockKAnnotations.init(this)
   taskViewModel = TaskViewModel(getTasksUseCase, addTaskUseCase, removeTaskUseCase, updateTaskUseCase)
   //Por el ciclo de vida del viewModel ponemos lo siguiente: Para gestionar el dispacher loshilos
    //Poner arriba de la clase @ExperimentalCoroutinesApi
   Dispatchers.setMain(Dispatchers.Unconfined)
  }
  //After: cuando se acaben los tests resetea
  @After
  fun onAfter(){
    Dispatchers.resetMain()
  }

  @Test
  fun  whenOpenTaskDialog_thenTaskDialogShowValueIsTrue()= runTest{
    //Given
    //When
   // taskViewModel.addTask(nameTask)
    taskViewModel.openTaskDialogShow()
    //Then
    assert(  taskViewModel.taskDialogShow.value == true )

  }

  @Test
  fun  whenCloseTaskDialog_thenTaskDialogShowValueIsFalse()= runTest{
    //Given
    //When
    // taskViewModel.addTask(nameTask)
    taskViewModel.closeTaskDialogShow()
    //Then
    assert(  taskViewModel.taskDialogShow.value == false )

  }
 


  }




