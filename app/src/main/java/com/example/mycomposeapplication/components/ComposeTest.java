package com.example.mycomposeapplication.components;

public class ComposeTest {

}

/*
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
    fun myfirstTest() {
        composeTestRule.setContent {
            Greeting()
        }
        //Finders: para seleccionar un elemento.

        //Si hay mas elementos text, busca de entre todos el q contiene hi, sin importat m,ayúsculas
        composeTestRule.onNodeWithText("hi", ignoreCase = true)
        //buscas por el tag(en el componente se mete en el modifivador)
        composeTestRule.onNodeWithTag("component2")
        //Buscar por contentDescripcion para imagneners o así
        composeTestRule.onNodeWithContentDescription("superImage")

        //Finder: para seleccionar todos los elementos q tengan los sig requisitos

        //Si hay mas elementos text, busca de entre todos los q contiene hi, sin importat m,ayúsculas
        composeTestRule.onAllNodesWithText("hi", ignoreCase = true)
        //buscas por el tag(en el componente se mete en el modifivador)
        composeTestRule.onAllNodesWithTag("component2")
        //Buscar por contentDescripcion para imagneners o así
        composeTestRule.onAllNodesWithContentDescription("superImage")


        //Actions:

        //hacer click
        composeTestRule.onNodeWithText("Hi").performClick()
        //si seleccionas muchos, coges el primero y click
        composeTestRule.onAllNodesWithText("Hi").onFirst().performClick()
        //clicks dsituntos: doble, largo...
        composeTestRule.onNodeWithText("Hi").performTouchInput {
            longClick()
            doubleClick()
            swipeDown()
            swipeUp()
            swipeLeft()
            swipeRight()
        }
        //                scrol dntro del componente
        composeTestRule.onNodeWithText("Hi").performScrollTo()
        //algunos te dejan concatener y otros ya no añadir más
        //                boton de accion del teclado
        composeTestRule.onNodeWithText("Hi").performScrollTo().performClick().performTextInput("")
        //        flechaa intro
        composeTestRule.onNodeWithText("Hi").performImeAction()
        //                borra texto del textfield
        composeTestRule.onNodeWithText("Hi").performTextClearance()
        //reemplazar el texto del componente, cambia el textfield vamos
        composeTestRule.onNodeWithText("Hi").performTextReplacement("")


        //Assertions Compprobaciones

        //Q exista ese componente
        composeTestRule.onNodeWithText("").assertExists()
        //que no existe
        composeTestRule.onNodeWithText("").assertDoesNotExist()
        //q el content description sea exactamente
        composeTestRule.onNodeWithText("").assertContentDescriptionEquals("")
        //qu el content description contenga ""
        composeTestRule.onNodeWithText("").assertContentDescriptionContains("")
        //que es visible
        composeTestRule.onNodeWithText("").assertIsDisplayed()
        //que no sea visible
        composeTestRule.onNodeWithText("").assertIsNotDisplayed()
        //q está habilitado
        composeTestRule.onNodeWithText("").assertIsEnabled()
        //no esta desabilitado
        composeTestRule.onNodeWithText("").assertIsNotEnabled()
        //esta seleccionado
        composeTestRule.onNodeWithText("").assertIsSelected()
        //no seleccionado
        composeTestRule.onNodeWithText("").assertIsNotSelected()
        //esta focus(cuando le das a un text view y te sale el teclado
        composeTestRule.onNodeWithText("").assertIsFocused()
        //no esta focus
        composeTestRule.onNodeWithText("").assertIsNotFocused()
        //está checked
        composeTestRule.onNodeWithText("").assertIsOn()
        //no checked
        composeTestRule.onNodeWithText("").assertIsOff()
        //el texto esigual a ""
        composeTestRule.onNodeWithText("").assertTextEquals("")
        //el texto contiene""
        composeTestRule.onNodeWithText("").assertTextContains("")

    }
}*/
