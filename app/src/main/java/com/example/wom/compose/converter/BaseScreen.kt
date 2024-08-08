package com.example.wom.compose.converter

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wom.compose.history.HistoryScreen
import com.example.wom.conversion.ConverterViewModel
import com.example.wom.conversion.ConverterViewModelFactory

@Composable
fun BaseScreen(
    factory: ConverterViewModelFactory,
    modifier: Modifier = Modifier,
    converterViewModel: ConverterViewModel = viewModel(factory = factory)
) {
    val configuration = LocalConfiguration.current
    var isLandscape by remember {
        mutableStateOf(false)
    }
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            isLandscape = true

            val list = converterViewModel.getConversions()
            val historyList = converterViewModel.resultList.collectAsState(initial = emptyList())
            Row(
                modifier = modifier
                    .padding(10.dp)
            ) {
                TopScreen(
                    list = list, converterViewModel.selectedConversion,
                    converterViewModel.inputText,
                    converterViewModel.typedValue, isLandscape
                ) { conType, from, to ->
                    converterViewModel.addResult(conType, from, to)
                }
                Spacer(modifier = modifier.width(10.dp))
                HistoryScreen(
                    list = historyList,
                    { item -> converterViewModel.removeResult(item) },
                    { converterViewModel.clearAll() })
            }
        }

        else -> {
            isLandscape = false
            val list = converterViewModel.getConversions()
            val historyList = converterViewModel.resultList.collectAsState(initial = emptyList())
            Column(modifier = modifier.padding(10.dp)) {
                TopScreen(
                    list = list, converterViewModel.selectedConversion,
                    converterViewModel.inputText,
                    converterViewModel.typedValue, isLandscape
                ) { conType, from, to ->
                    converterViewModel.addResult(conType, from, to)
                }
                Spacer(modifier = modifier.height(30.dp))
                HistoryScreen(
                    list = historyList,
                    { item -> converterViewModel.removeResult(item) },
                    { converterViewModel.clearAll() })
            }
        }
    }

}