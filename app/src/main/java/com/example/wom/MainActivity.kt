package com.example.wom

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.wom.ui.theme.WOMTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wom.compose.converter.BaseScreen
import com.example.wom.conversion.ConverterViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var factory: ConverterViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WOMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val vm = viewModel<ViewModelClass>()
                    /*AlignTopRowElement(
                        R.drawable.img_under_dev,
                        " Construction",
                        Modifier.padding(8.dp)
                    )*/
//                    FavoriteCollectionCard(Modifier.padding(8.dp), "Text message")
//                AlignTopRow(Modifier.padding(8.dp))
//                    FavoriteCollectionGrid(Modifier.padding(8.dp))
//                    HomeScreen(Modifier.padding(16.dp))
//                    SmoothNavigationBar(Modifier.padding(16.dp))
//
//                    BoxExample2()
//                    DisplaySnackBar()
//                    ButnClick(50){
//                        vm.calcuateTotal(50)
//                    }
                    BaseScreen(factory = factory)
                }
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState())) {
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        Spacer(Modifier.height(16.dp))
        HomeSection("Align Your Body ") {
            AlignTopRow()
        }
        Spacer(Modifier.height(16.dp))
        HomeSection(title = "Align Body") {
            FavoriteCollectionGrid(
                Modifier
                    .padding(16.dp)
                    .fillMaxHeight()
            )
        }
        Spacer(Modifier.height(16.dp))
//
    }
}

@Composable
fun HomeSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(title)
        content()
    }
}

@Composable
fun FavoriteCollectionGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), modifier = modifier.height(350.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(16) {
            FavoriteCollectionCard(
                Modifier
                    .padding(8.dp)
                    .width(100.dp)
                    .height(100.dp), "grid"
            )
        }
    }
}

@Composable
fun AlignTopRow(modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(16.dp),
        modifier = modifier
    ) {

        items(5) { item ->
            AlignTopRowElement(image = R.drawable.img_under_dev, textDis = "Testing")
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun AlignTopRowElement(
    @DrawableRes image: Int,
    textDis: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = textDis, modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.h6
        )
    }
}

@Composable
fun FavoriteCollectionCard(
    modifier: Modifier = Modifier, disString: String
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = Color.Gray,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center, modifier = Modifier.width(255.dp)
        ) {

            Image(
                painter = painterResource(R.drawable.img_under_dev),
                contentDescription = null,
                contentScale = ContentScale.Crop, modifier = Modifier.size(80.dp)
            )
            Text(
                text = disString,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },

        placeholder = {
            Text(stringResource(R.string.search))
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}

@Composable
fun SmoothNavigationBar(modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = stringResource(R.string.bottom_navigation_home)
                )
            },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = stringResource(R.string.bottom_navigation_profile)
                )
            },
            selected = false,
            onClick = {}
        )
    }
}

@Composable
fun BoxExample1() {
    Box(
        modifier = Modifier
            .background(color = Color.Green)
            .size(180.dp, 300.dp)
    ) {
        Box(
            modifier = Modifier
                .background(color = Color.Yellow)
                .size(125.dp, 100.dp)
                .align(Alignment.TopEnd)
        ) {

        }

        Text(
            text = "Hi",
            style = MaterialTheme.typography.h3,
            modifier = Modifier
                .background(color = Color.White)
                .size(90.dp, 50.dp)
                .align(Alignment.BottomCenter)


        )
    }
}

@Preview
@Composable
fun BoxExample2() {
    Box(
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxSize()
    ) {

        Text(
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(10.dp)
                .align(Alignment.TopStart),
            text = "TopStart"
        )
        Text(
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(10.dp)
                .align(Alignment.TopCenter),
            text = "TopCenter"
        )
        Text(
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(10.dp)
                .align(Alignment.TopEnd),
            text = "TopEnd"
        )

        Text(
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(10.dp)
                .align(Alignment.CenterStart),
            text = "CenterStart"
        )

        Text(
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(10.dp)
                .align(Alignment.Center),
            text = "Center"
        )
        Text(
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(10.dp)
                .align(Alignment.CenterEnd),
            text = "CenterEnd"
        )

        Text(
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(10.dp)
                .align(Alignment.BottomStart),
            text = "BottomStart"
        )
        Text(
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(10.dp)
                .align(Alignment.BottomCenter),
            text = "BottomCenter"
        )
        Text(
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(10.dp)
                .align(Alignment.BottomEnd),
            text = "BottomEnd"
        )
    }
}

@Preview
@Composable
fun BoxExample3() {
    Box() {
        Image(
            painter = painterResource(id = R.drawable.img_under_dev),
            contentDescription = "beach resort"
        )
        Text(
            text = "Beach Resort",
            style = MaterialTheme.typography.h4,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.BottomStart)
        )
        Button(
            onClick = {},
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.White,
                contentColor = Color.DarkGray
            ),
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(10.dp)
                .border(5.dp, Color.DarkGray, RectangleShape)

        ) {
            Text("Add To Cart")
        }

    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DisplaySnackBar() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    Scaffold(scaffoldState = scaffoldState) {
        Button(onClick = {
            coroutineScope.launch {
                val snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
                    message = "This is the message",
                    actionLabel = "Undo",
                    duration = SnackbarDuration.Short
//                            inifinite , long
                )
                when (snackBarResult) {
                    SnackbarResult.ActionPerformed -> Log.i("MYTAG", "action label clicked")
                    SnackbarResult.Dismissed -> Log.i("MYTAG", "dismissed!")
                }
            }
        }) {
            Text(text = "Display SnackBar")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun ButnClick(input: Int, sum: (Int) -> Unit) {
    Button(onClick = { sum(input) }) {
        Text(text = "Click Here+ $sum")

    }
}

@Composable
fun DefaultPreview() {
    WOMTheme {
        Greeting("Android")
    }
}