package com.example.wom.compose.converter

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.wom.compo.InputBlock
import com.example.wom.conversion.ResultScreen
import com.example.wom.data.Conversion
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun TopScreen(
    list: List<Conversion>,
    selectedConversion: MutableState<Conversion?>,
    inputText: MutableState<String>,
    typedValue: MutableState<String>,
    isLandscape: Boolean, save: (String,String, String) -> Unit
) {
    var toSave by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .background(
                color = Color(0x16A7A9AA)
            )
            .padding(10.dp)
    ) {
        ConversionMenu(list = list, isLandscape) {
            selectedConversion.value = it
            typedValue.value = "0.0"
        }

        selectedConversion.value?.let {
            InputBlock(conversion = it, inputText = inputText, isLandscape) { input ->
                typedValue.value = input
                toSave = true
            }
        }
        if (typedValue.value != "0.0") {

            val input = typedValue.value.toDouble()
            val multiply = selectedConversion.value!!.multiplyBy
            val result = input * multiply
            val df = DecimalFormat("#.####")
            df.roundingMode = RoundingMode.DOWN
            val roundedResult = df.format(result)
            val message1 =
                "${typedValue.value} ${selectedConversion.value!!.convertFrom}          =       "
            val message2 = "$roundedResult ${selectedConversion.value!!.convertTo}"
//            val message1 =
//                "${typedValue.value} ${selectedConversion.value!!.convertFrom} is equal to"
//            val message2 = "$roundedResult ${selectedConversion.value!!.convertTo}"
            if (toSave) {
                save(selectedConversion.value!!.description, message1,message2)
                toSave = false
            }
            ResultScreen(msg1 = message1, msg2 = message2,isLandscape)
        }
    }
}