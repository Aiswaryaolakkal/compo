package com.example.wom.conversion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultScreen(msg1: String, msg2: String, isLandScape: Boolean) {
    val surfaceColor =  Color(0xD0A4AAAD)
    val textColor = MaterialTheme.colorScheme.onSurface
    val highlightColor = MaterialTheme.colorScheme.primary
    if (isLandScape) {
        Card(modifier = Modifier
            .padding(10.dp)) {
            Row(
                modifier = Modifier
                    .background(color = surfaceColor)
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = msg1, fontSize = 20.sp, color = textColor)
                Text(text = msg2, fontSize = 20.sp, color =highlightColor)
            }

        }
    } else {
        Card(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = surfaceColor)
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = msg1, fontSize = 20.sp, color = textColor)
                Text(text = msg2, fontSize = 20.sp, color =highlightColor)
            }

        }
    }
}

