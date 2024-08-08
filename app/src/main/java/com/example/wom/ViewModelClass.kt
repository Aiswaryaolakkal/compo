package com.example.wom

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ViewModelClass : ViewModel() {
    private val _flowTotal = MutableStateFlow<Int>(0)
    val flowtotal : StateFlow<Int> = _flowTotal
    init {
        backPressure()
        _flowTotal.value = 0
    }

    var count by mutableStateOf(0)
    fun increaseCount() {
        count++
    }
    fun calcuateTotal  (input:Int)
    {
        _flowTotal.value = _flowTotal.value.plus(input)
    }

    fun backPressure() {
        var myfloe = flow<Int> {
            for (i in 1..10) {
                emit(i)
                delay(1000L)
                Log.v("test produce ", i.toString())
            }
        }
        viewModelScope.launch {
            myfloe.filter { i->i%2 ==0}
                .map { it -> showMessage(it) }
                .collect {
                    delay(2000L)
                    Log.v("test consume ", it.toString())
                }
        }
    }

    private fun showMessage(i: Int): String {
        return "HELLO $i"
    }
}