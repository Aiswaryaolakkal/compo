package com.example.wom.compose.history

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HistoryItem(
    conType: String,
    conFrom: String,
    conTo: String,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    val surfaceColor =  Color(0xD0A4AAAD)
    val onBackground = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.9f)
    val textColor = MaterialTheme.colorScheme.onSurface
    val highlightColor = MaterialTheme.colorScheme.primary
    val iconColor = MaterialTheme.colorScheme.onBackground
    Card(modifier = Modifier.padding(10.dp).fillMaxWidth()) {
        Row(
            modifier = modifier
                .fillMaxWidth().background(surfaceColor),
//                .border(border = BorderStroke(0.5.dp, Color.Gray)),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.padding(10.dp)) {
                Text(text = conType, fontSize = 20.sp, color = textColor)
                Spacer(modifier = modifier.padding(5.dp))
                Row(horizontalArrangement = Arrangement.Absolute.Center) {
                    Text(text = conFrom, fontSize = 20.sp, color = textColor)
                    Text(text = conTo, fontSize = 22.sp, color = highlightColor)
                }

            }
            IconButton(onClick = { onClose() }) {
                androidx.compose.material.Icon(Icons.Filled.Close, contentDescription = "close",   tint = iconColor)
            }
        }
    }
}