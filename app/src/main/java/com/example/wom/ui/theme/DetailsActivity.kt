package com.example.wom.ui.theme

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.wom.model.TvShow

class DetailsActivity : ComponentActivity() {
    companion object {
        private const val TvShowId = "tv"
        fun intent(context: Context, tvShow: TvShow) =
            Intent(context, DetailsActivity::class.java).apply {
                putExtra(TvShowId, tvShow)
            }
    }

    private val tvShow: TvShow by lazy {
        intent?.getSerializableExtra(TvShowId) as TvShow
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewMoreInfo(tvShow = tvShow)

        }
    }
}

@Composable
fun ViewMoreInfo(tvShow: TvShow) {
    val scrollState = rememberScrollState()
    Card(modifier = Modifier.padding(8.dp), shape = RoundedCornerShape(corner = CornerSize(10.dp))) {
        Column() {
            Image(
                painter = painterResource(id = tvShow.imageId),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
            )
            Text(text = tvShow.name, modifier = Modifier.padding(8.dp))
            Spacer(modifier = Modifier.padding(10.dp))
            Text(text = tvShow.overview, modifier = Modifier.padding(8.dp))
            Spacer(modifier = Modifier.padding(10.dp))
            Text(text = "Original Release : " + tvShow.year, modifier = Modifier.padding(8.dp))
            Spacer(modifier = Modifier.padding(10.dp))
            Text(text = "Rating :" + tvShow.rating, modifier = Modifier.padding(8.dp))
            Spacer(modifier = Modifier.padding(10.dp))

        }
    }
}