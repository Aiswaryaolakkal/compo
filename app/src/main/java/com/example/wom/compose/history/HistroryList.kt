package com.example.wom.compose.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wom.data.ConversionResult

@Composable
fun HistroryList(
    list: State<List<ConversionResult>>,
    onCloseTask: (ConversionResult) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(
            items = list.value,
            key = { item -> item.id }
        ) { item ->
            HistoryItem(conType = item.conv_type,conFrom = item.conFrom,
                conTo = item.conTo,
                onClose = { onCloseTask(item) })
        }
    }
}