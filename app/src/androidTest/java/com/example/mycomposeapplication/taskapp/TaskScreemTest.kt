package com.example.mycomposeapplication.taskapp

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.NavController
import com.example.mycomposeapplication.taskApp.UI.TaskScreem
import com.example.mycomposeapplication.taskApp.UI.TaskViewModel
import com.example.mycomposeapplication.taskApp.domain.AddTaskUseCase
import org.junit.Rule
import org.junit.Test


class TaskScreemTest {
    
    //Siempre se empieza con las signtes 2 líneas:
    @get:Rule
    val composeTestRule = createComposeRule()
    
    @Test
    fun whenComponentStart_thenVerifyContentIsHi(){
        composeTestRule.setContent {
            //el componente a testear
           // TaskScreem( )
        }
       //lo q vas a testear, las acciones q quieres comprobar
    }
}