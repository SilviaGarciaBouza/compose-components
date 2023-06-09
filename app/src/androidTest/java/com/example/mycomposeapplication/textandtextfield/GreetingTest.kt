package com.example.mycomposeapplication.textandtextfield

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.mycomposeapplication.Greeting
import org.junit.Rule
import org.junit.Test

class GreetingTest {
    //Hay q poner estas 2 líneas
    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun whenComponentStart_thenVerifyConstainsHi() {
        composeTestRule.setContent {
            Greeting()
        }

        //Si hay mas elementos text, busca de entre todos el q contiene hi, sin importat m,ayúsculas
        composeTestRule.onNodeWithTag("component1").assertExists()

    }


}