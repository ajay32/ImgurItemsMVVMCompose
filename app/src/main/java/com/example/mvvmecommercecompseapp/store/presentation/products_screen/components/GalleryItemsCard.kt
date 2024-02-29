package com.example.mvvmecommercecompseapp.store.presentation.products_screen.components

import android.os.Build
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.imageLoader
import coil.request.ImageRequest
import com.example.mvvmecommercecompseapp.R
import com.example.mvvmecommercecompseapp.store.domain.model.GalleryItem
import com.example.mvvmecommercecompseapp.store.presentation.util.extractImageUrl
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale


@Composable
fun GalleryItemCard(modifier: Modifier = Modifier, galleryItem: GalleryItem, imageLoader: ImageLoader = LocalContext.current.imageLoader) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(galleryItem.extractImageUrl())
                    .crossfade(true) // Enable crossfade animation
                    .build(),
                placeholder = painterResource(R.drawable.place),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop,
                imageLoader = imageLoader
            )
            Spacer(modifier = Modifier.height(5.dp))
            GalleryItemDetails(galleryItem)
        }
    }
}

@Composable
fun GalleryItemDetails(galleryItem: GalleryItem) {
    galleryItem.title?.let {
        Text(text = it, style = MaterialTheme.typography.titleMedium)
    }
    galleryItem.datetime?.let { datetime ->
        // Convert Unix timestamp to human-readable date
        val formattedDate = formatDateTime(datetime)
        Text(text = formattedDate, style = MaterialTheme.typography.bodyMedium)
    }
    if ((galleryItem.images_count ?: 0) > 1) {
        Text(text = "Additional images: ${galleryItem.images_count?.minus(1) ?: 0}")
    }
}

fun formatDateTime(unixTimestamp: Long): String {
    // Use DateTimeFormatter or SimpleDateFormat (for API < 26) to format the date
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
        LocalDateTime.ofEpochSecond(unixTimestamp, 0, ZoneOffset.UTC).format(formatter)
    } else {
        val date = Date(unixTimestamp * 1000L) // Java uses milliseconds
        val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
        formatter.format(date)
    }
}