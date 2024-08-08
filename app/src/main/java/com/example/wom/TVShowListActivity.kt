package com.example.wom

import android.graphics.Paint.Align
import android.os.Bundle
import android.text.style.AlignmentSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composerecyclerview.data.TvShowList
import com.example.wom.model.TvShow
import com.example.wom.ui.theme.DetailsActivity
import com.example.wom.ui.theme.WOMTheme

class TVShowListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisplayShows {
                startActivity(DetailsActivity.intent(this, it))
            }
//            WOMTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting3("Android")
//                }
//            }
        }
    }
}


@Composable
fun DisplayShows(selectedItem: (TvShow) -> Unit) {
    val list = remember { TvShowList.tvShows }
    LazyColumn(   contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(
            items = list,
            itemContent = {
                TvShowItem(item = it, selectedItem)
            }
        )
    }

}

@Composable
fun TvShowItem(item: TvShow, selectedItem: (TvShow) -> Unit) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        elevation = 10.dp,
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    )
    {
        Row(
           modifier = Modifier.clickable { selectedItem(item) },
        ) {
            TVShowImage1(item)
            Column {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(10.dp)
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = item.overview, maxLines = 3,
                    modifier = Modifier.padding(4.dp)
                )
                Row( modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = item.year.toString(),
                        modifier = Modifier.padding(10.dp),style = androidx.compose.material.MaterialTheme.typography.h5
                    )
                    Text(text = item.rating.toString(),modifier = Modifier.padding(10.dp),style = androidx.compose.material.MaterialTheme.typography.h5)
                }
            }
        }
    }
}

@Composable
fun TVShowImage1(item: TvShow) {
    Image(
        painter = painterResource(id = item.imageId),
        contentDescription = null,
        modifier = Modifier
            .padding(10.dp)
            .height(140.dp)
            .width(100.dp)
            .clip(RoundedCornerShape(corner = CornerSize(10)))
    )
}