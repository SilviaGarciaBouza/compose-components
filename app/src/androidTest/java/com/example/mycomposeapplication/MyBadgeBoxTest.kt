package com.example.mycomposeapplication

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class MyBadgeBoxTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun whenComponentStart_thenVerifyContentDescription() {
        composeTestRule.setContent {
            MyBadgeBox()
        }
        //acción
    }


}