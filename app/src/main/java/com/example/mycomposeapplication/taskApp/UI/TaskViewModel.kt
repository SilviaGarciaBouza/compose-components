package com.example.mycomposeapplication.taskApp.UI

import androidx.compose.foundation.lazy.layout.MutableIntervalList
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.mycomposeapplication.taskApp.UI.TasksUiState.Success
import com.example.mycomposeapplication.taskApp.domain.AddTaskUseCase
import com.example.mycomposeapplication.taskApp.domain.GetTasksUseCase
import com.example.mycomposeapplication.taskApp.domain.RemoveTaskUseCase
import com.example.mycomposeapplication.taskApp.domain.UpdateTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TaskViewModel @Inject constructor(
    //Flow1-inyecta los casos de uso
    private val getTasksUseCase: GetTasksUseCase,
    private val addTaskUseCase: AddTaskUseCase,
    private val removeTaskUseCase: RemoveTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase
): ViewModel() {
    //Flow2-crea la variable de los flow, ensea la lista en success
    val uiState:StateFlow<TasksUiState> = getTasksUseCase().map (::Success)
        .catch { TasksUiState.Error(it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), TasksUiState.Loading)

    private var _taskDialogShow= MutableLiveData<Boolean>()
    var taskDialogShow: LiveData<Boolean> = _taskDialogShow

  //  private var _listTasks= mutableStateListOf<TaskModel>()
   // var listTasks: List<TaskModel> = _listTasks

    fun closeTaskDialogShow(){
        _taskDialogShow.value =false
    }


    fun openTaskDialogShow(){
        _taskDialogShow.value =true
    }


    //    //Flow3-las funciones salen del flow
    fun addTask(name: String){
        viewModelScope.launch {
            _taskDialogShow.value= false
            addTaskUseCase(TaskModel(nameTask= name))
        }

    }
    fun changeSelectedCheckBoxTask(taskModel: TaskModel){
    viewModelScope.launch {
        updateTaskUseCase(taskModel.copy(selected = !taskModel.selected))
    }

    }

    fun itemTaskRemove(taskModel: TaskModel) {
       viewModelScope.launch {
           removeTaskUseCase(taskModel)
       }

    }
}