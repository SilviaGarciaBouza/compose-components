package com.example.mycomposeapplication.taskApp.UI

import androidx.compose.foundation.lazy.layout.MutableIntervalList
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.CreationExtras
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel

class TaskViewModel @Inject constructor(): ViewModel() {

    private var _taskDialogShow= MutableLiveData<Boolean>()
    var taskDialogShow: LiveData<Boolean> = _taskDialogShow

    private var _listTasks= mutableStateListOf<TaskModel>()
    var listTasks: List<TaskModel> = _listTasks

    fun closeTaskDialogShow(){
        _taskDialogShow.value =false
    }

    fun onConfirmDialog(name: String){
        _taskDialogShow.value =false
        _listTasks.add(TaskModel(nameTask = name))

    }

    fun openTaskDialogShow(){
        _taskDialogShow.value =true
    }

}