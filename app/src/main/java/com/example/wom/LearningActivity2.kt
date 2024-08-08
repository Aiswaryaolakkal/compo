package com.example.wom

import android.inputmethodservice.Keyboard
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wom.ui.theme.Shapes
import com.example.wom.ui.theme.WOMTheme

class LearningActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            LazyColoumList {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                Log.v("test","$it")
            }
//            WOMTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//
////                    ImageBox()
////                    boxLayout()
//
////                    Row(
////                        modifier = Modifier.background(
////                            color = Color.Blue,
////                            shape = Shapes.medium
////                        ),
////                        horizontalArrangement = Arrangement.SpaceEvenly,
////                        Alignment.Bottom,
////
////                        ) {
//////                        Greeting2("Android")
////
////                    }
//                }
//            }
        }
    }
}

@Composable
fun boxLayout() {
    Box(
        modifier = Modifier
            .background(color = Color.Red)
            .fillMaxWidth()
    ) {
        Text(
            text = "Hello Box",
            color = Color.Red,
            modifier = Modifier
                .background(color = Color.Yellow)
                .padding(15.dp)
                .align(Alignment.TopStart)


        )

        Text(
            text = "Hello Box",
            color = Color.Red,
            modifier = Modifier
                .background(color = Color.Yellow)
                .padding(15.dp)
                .align(Alignment.TopCenter)


        )

        Text(
            text = "Hello Box",
            color = Color.Red,
            modifier = Modifier
                .background(color = Color.Yellow)
                .padding(15.dp)
                .align(Alignment.CenterStart)
        )

        Text(
            text = "Hello Box",
            color = Color.Red,
            modifier = Modifier
                .background(color = Color.Yellow)
                .padding(15.dp)
                .align(Alignment.BottomEnd)
        )
    }

}

@Composable
fun ImageBox() {
    Box() {
        Image(painter = painterResource(id = R.drawable.lucifer), contentDescription = "lucifer")
        Text(
            text = "Film Name",
            color = Color.DarkGray,
            fontSize = 30.sp,
            modifier = Modifier.align(alignment = Alignment.TopStart)
        )

        Button(
            onClick = { },
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.Red,
                contentColor = Color.White
            ), modifier = Modifier
                .border(5.dp, color = Color.DarkGray)
                .align(alignment = Alignment.BottomStart)
        ) {
            Text(text = "***")
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(
        text = "He$name!", fontSize = 20.sp,
        color = Color.Red,
        fontWeight = FontWeight.Thin,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(color = Color.Yellow, shape = Shapes.medium)
            .border(2.dp, color = Color.Blue, shape = Shapes.medium)
            .padding(10.dp)
//            .fillMaxHeight()
//            .fillMaxWidth()
    )
}

@Composable
fun DefaultPreview2() {
    WOMTheme {
        Greeting2("Android")
    }
}

//@Preview(showBackground = true)
@Composable
fun LazyColoumList(selectedItem: (String) -> Unit) {
    LazyColumn {
        items(10) {
            Text(
                "item $it",
                modifier = Modifier
                    .padding(10.dp)
                    .clickable { selectedItem("$it selected") })
            Divider(color = Color.Yellow, thickness = 5.dp)

        }
    }
}