package com.example.wom.remember

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wom.R
import com.example.wom.ViewModelClass
import com.example.wom.ui.theme.WOMTheme

class RemeberActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val vm = viewModel<ViewModelClass>()
            WOMTheme {
                var count = vm.count
//                var count by rememberSaveable{ mutableStateOf(0) }
                viewButton(count) {
//                    count = it + 1
                    vm.increaseCount()
                }
            }
        }
    }
}

@Composable
fun viewButton(currentCount: Int, updatecount: (Int) -> Unit) {
//    val count = remember{mutableStateOf(0) }
    val context = LocalContext.current
    Button(onClick = {
        updatecount(currentCount);
    }) {
        Text(text = "Click Here+ $currentCount")
    }
}