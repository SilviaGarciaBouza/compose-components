package tipCalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.DecimalFormat
import java.text.NumberFormat

class tipCalculatorTest {

    @Test
    fun calculateTipTest_15PercentNotRound(){
        var myTextTip = "100"
        var myTip= "15"

        var amount = myTextTip.toDoubleOrNull() ?: 0.00
        var tipPercent = myTip.toDoubleOrNull() ?: 0.00

        val expectedTip = 15.00
        val df = DecimalFormat("#.##")
        var calculate = amount * tipPercent / 100.00
        var calculateTip = df.format(calculate).toDouble()

        assertEquals(expectedTip,calculateTip)

    }

}