package com.example.wom.compo

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wom.data.Conversion
@Composable
fun InputBlock(
    conversion: Conversion,
    inputText : MutableState<String>,
    isLandscape : Boolean,
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    calculate : (String)-> Unit
) {
    val buttonBackgroundColor = MaterialTheme.colors.primary
    val buttonTextColor = MaterialTheme.colors.onPrimary
    val textFieldTextColor = MaterialTheme.colors.onSurface
    val textFieldBackgroundColor = MaterialTheme.colors.surface
    val labelColor = MaterialTheme.colors.onBackground

    if(isLandscape){
        Column(modifier = Modifier.padding(0.dp,20.dp)) {
            Row() {
                Spacer(modifier = Modifier.height(30.dp))
                OutlinedTextField(
                    value = inputText.value,
                    onValueChange = {
                        inputText.value = it
                    },
//                placeholder = { Text(text = "12")},
                    label = { Text(text = "Convertion Input")},

                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = true,
                        keyboardType = KeyboardType.Number
                    ),

                    textStyle = TextStyle(color = textFieldTextColor, fontSize = 20.sp), shape = RoundedCornerShape(10.dp)
                )


            }
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = {
                    if (inputText.value != "") {
                        calculate(inputText.value)
                    } else {
                        Toast.makeText(context, "Please enter a valid input", Toast.LENGTH_SHORT)
                            .show()
                    }
                },
          shape = RoundedCornerShape(20.dp), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
            ) {
                Text(
                    text = "Convert",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )

            }
        }
    }else{
        Column(modifier = Modifier.padding(0.dp,20.dp)) {
            Row(modifier = modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.height(30.dp))
                OutlinedTextField(
                    value = inputText.value,
                    onValueChange = {
                        inputText.value = it
                    },
//                placeholder = { Text(text = "12")},
                    label = { Text(text = "Convertion Input")},
                    modifier = modifier
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = true,
                        keyboardType = KeyboardType.Number
                    ),
                    /*       colors = TextFieldDefaults.textFieldColors(
                               backgroundColor = MaterialTheme.colors.surface.copy(
                                   0.3F
                               )
                           ),*/
                    textStyle = TextStyle(color = textFieldTextColor, fontSize = 20.sp), shape = RoundedCornerShape(10.dp)
                )

//            Text(
//                text = conversion.convertFrom,
//                fontSize = 24.sp,
//                modifier = modifier
//                    .padding(10.dp, 30.dp, 0.dp, 0.dp)
//                    .fillMaxWidth(0.35F)
//            )
            }
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = {
                    if (inputText.value != "") {
                        calculate(inputText.value)
                    } else {
                        Toast.makeText(context, "Please enter a valid input", Toast.LENGTH_SHORT)
                            .show()
                    }
                },
                modifier.fillMaxWidth().height(50.dp), shape = RoundedCornerShape(20.dp), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
            ) {
                Text(
                    text = "Convert",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )

            }
        }
    }

}