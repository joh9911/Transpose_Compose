package com.example.transpose.ui.screen.home.home_playlist.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.transpose.data.model.newpipe.NewPipePlaylistData
import com.example.transpose.utils.constants.AppColors


@Composable
fun NationalPlaylistItem(
    playlistData: NewPipePlaylistData,
    onClick: (String) -> Unit
) {
    val itemId = playlistData.id
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 20.dp)
    ) {
        AsyncImage(
            model = playlistData.thumbnailUrl,
            contentDescription = "Nation Icon",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = playlistData.title,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = playlistData.description,
            fontSize = 10.sp,
            color = AppColors.DescriptionColor,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(5.dp))

        Row {
            Text(
                text = playlistData.uploaderName,
                fontSize = 8.sp,
                color = AppColors.DescriptionColor,
                modifier = Modifier.weight(0.8f)
            )
            Text(
                text = playlistData.publishTimestamp.toString(),
                fontSize = 8.sp,
                color = AppColors.DescriptionColor,
                modifier = Modifier.weight(0.4f)
            )
        }
    }
}
