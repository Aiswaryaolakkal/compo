package com.example.wom

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.composerecyclerview.data.TvShowList
import com.example.wom.model.TvShow
import com.example.wom.ui.theme.DetailsActivity

class ListingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisplayTvShows {
//                Toast.makeText(this, it.name, Toast.LENGTH_LONG).show()
//                startActivity(InfoActivity.intent(this,it))
                startActivity(DetailsActivity.intent(this, it))
            }
        }
    }


}

@Composable
fun TVShowImage(tvShow: TvShow) {
    Image(
        painter = painterResource(id = tvShow.imageId),
        contentDescription = null, contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(4.dp)
            .height(140.dp)
            .width(100.dp)
            .clip(RoundedCornerShape(corner = CornerSize(10.dp)))
    )
}


@Composable
fun TvShowListItem(tvShow: TvShow, selectedItem: (TvShow) -> Unit) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        elevation = 10.dp,
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clickable { selectedItem(tvShow) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            TVShowImage(tvShow = tvShow)
            Column(Modifier.padding(8.dp)) {
                Text(text = tvShow.name, style = MaterialTheme.typography.h5)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = tvShow.overview, maxLines = 3,
                    style = MaterialTheme.typography.h6,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(5.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    modifier = Modifier.padding(5.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = tvShow.year.toString(), style = MaterialTheme.typography.h5)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = tvShow.rating.toString(), style = MaterialTheme.typography.h5)
                    Spacer(modifier = Modifier.height(4.dp))
                }

            }
        }
    }
}

@Composable
fun DisplayTvShows(selectedItem: (TvShow) -> Unit) {

    val tvShows = remember { TvShowList.tvShows }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = tvShows,
            itemContent = {
                TvShowListItem(tvShow = it, selectedItem)
            }
        )
    }

}
