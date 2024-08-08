package com.example.wom.compose.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wom.data.Conversion
import com.example.wom.data.ConversionResult

@Composable
fun HistoryScreen(
    list: State<List<ConversionResult>>,
    onCloseTask: (ConversionResult) -> Unit,
    onClearAllTask: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        if ((list.value).isNotEmpty()) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "History", color = Color.Gray)
                OutlinedButton(onClick = { onClearAllTask() }) {
                    Text(text = "Clear All", color = Color.Gray)
                }
            }
            HistroryList(list = list, onCloseTask = { item -> onCloseTask(item) })

        }
    }
}