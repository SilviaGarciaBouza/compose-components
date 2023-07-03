package com.example.mycomposeapplication.dialog

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.mycomposeapplication.MyDialog
import org.junit.Rule
import org.junit.Test

class MyDialogTest {
    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun whenDialogIsTrue_thenShowDialog(){
        composeTestRule.setContent {
            MyDialog(show = true, {})
        }
        composeTestRule.onNodeWithTag("myDialog").assertIsDisplayed()
    }

    @Test
    fun whenDialogIsFalse_thenNotShowDialog(){
        composeTestRule.setContent {
            MyDialog(show = false, {})
        }
        composeTestRule.onNodeWithTag("myDialog").assertDoesNotExist()
    }
}