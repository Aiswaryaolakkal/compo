package com.example.wom.compose.converter

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.wom.data.Conversion

@Composable
fun ConversionMenu(
    list: List<Conversion>,
    isLandscape: Boolean,
    modifier: Modifier = Modifier,
    convert: (Conversion) -> Unit
) {
    var displayText by rememberSaveable { mutableStateOf("Select the conversion type") }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    var expanded by remember { mutableStateOf(false) }

    val buttonBackgroundColor = MaterialTheme.colors.primary
    val buttonTextColor = MaterialTheme.colors.onPrimary
    val textFieldTextColor = MaterialTheme.colors.onSurface
    val textFieldBackgroundColor = MaterialTheme.colors.surface
    val labelColor = MaterialTheme.colors.onBackground

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown
    Column(modifier = Modifier.padding(10.dp)) {
        if (isLandscape) {
            OutlinedTextField(
                value = displayText,
                onValueChange = { displayText = it },
                textStyle = TextStyle(fontSize = 20.sp, color = textFieldTextColor),
                modifier = modifier
                    .onGloballyPositioned { cordinates ->
                        textFieldSize = cordinates.size.toSize()
                    },
                label = { Text(text = "Conversion Type", color = labelColor) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = textFieldBackgroundColor,
                    focusedBorderColor = buttonBackgroundColor,
                    unfocusedBorderColor = buttonBackgroundColor,
                    cursorColor = buttonBackgroundColor
                ),
                trailingIcon = {
                    Icon(
                        icon,
                        contentDescription = "icon",
                        modifier.clickable { expanded = !expanded })
                }, readOnly = true
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = modifier
                    .width(with(LocalDensity.current)
                    { textFieldSize.width.toDp() })
                    .background(textFieldBackgroundColor)
            )
            {
                list.forEach { conversion ->
                    DropdownMenuItem(onClick = {
                        displayText = conversion.description
                        expanded = false
                        convert(conversion)
                    }) {
                        Text(
                            text = conversion.description,
                            fontSize = 20.sp,
                            color = labelColor,
                            fontWeight = FontWeight.Light
                        )
                    }
                }
            }
        } else {
            OutlinedTextField(
                value = displayText,
                onValueChange = { displayText = it },
                textStyle = TextStyle(fontSize = 20.sp, color = textFieldTextColor),
                modifier = modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { cordinates ->
                        textFieldSize = cordinates.size.toSize()
                    },
                label = { Text(text = "Conversion Type", color = labelColor) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = textFieldBackgroundColor,
                    focusedBorderColor = buttonBackgroundColor,
                    unfocusedBorderColor = buttonBackgroundColor,
                    cursorColor = buttonBackgroundColor
                ),
                trailingIcon = {
                    Icon(
                        icon,
                        contentDescription = "icon",
                        modifier.clickable { expanded = !expanded })
                }, readOnly = true
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = modifier
                    .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                    .background(textFieldBackgroundColor)
            )
            {
                list.forEach { conversion ->
                    DropdownMenuItem(onClick = {
                        displayText = conversion.description
                        expanded = false
                        convert(conversion)
                    }) {
                        Text(
                            text = conversion.description,
                            fontSize = 20.sp,
                            color = labelColor,
                            fontWeight = FontWeight.Light
                        )
                    }
                }
            }
        }


    }
}
