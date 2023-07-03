package com.example.mycomposeapplication.textandtextfield

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextClearance
import com.example.mycomposeapplication.Greeting
import com.example.mycomposeapplication.MyTextFieldAdvanc
import org.junit.Rule
import org.junit.Test

class MyTextFieldAdvancTest {
    //Hay q poner estas 2 líneas
    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun whenTextCointainsHi_thenConstainsHi() {
        composeTestRule.setContent {
            MyTextFieldAdvanc()
        }
       //Borra texto del telfield
        composeTestRule.onNodeWithText("").performTextClearance()

    }

}