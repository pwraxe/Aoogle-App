package pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codexdroid.aoogleapp.data.ImageData
import com.codexdroid.aoogleapp.data.imageList

@Preview
@Composable
fun ImagePreview(modifier: Modifier = Modifier) {
    Images()
}

@Composable
fun Images(modifier: Modifier = Modifier) {

    var imageData: ImageData? by remember { mutableStateOf(null) }

    Column (modifier = modifier
        .background(color = Color(0XFF202124))
        .fillMaxSize()
        .padding(1.dp)) {

        imageData?.let {
            Column(modifier = modifier
                .fillMaxSize()
                .weight(1f)) {

                ElevatedCard (
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF282124),
                        contentColor = Color.White),
                    shape = RoundedCornerShape(20.dp),
                    modifier = modifier
                        .fillMaxSize()
                        .padding(10.dp)) {

                    Column {
                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = modifier.padding(16.dp)) {

                            Image(painter = painterResource(it.image),
                                contentDescription = "",
                                modifier = modifier
                                    .clip(CircleShape)
                                    .size(32.dp)
                            )

                            Text(
                                text = it.title,
                                modifier = modifier.padding(horizontal = 10.dp)
                            )
                            Spacer(modifier = modifier.weight(1f))

                            IconButton(onClick = { imageData = null }) {
                                Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
                            }
                        }

                        Box(
                            modifier = modifier
                                .fillMaxWidth()
                                .aspectRatio(1.8f) // Adjust aspect ratio as needed
                        ) {
                            Image(
                                painter = painterResource(it.image),
                                contentDescription = "",
                                modifier = modifier
                                    .fillMaxSize(),
                                contentScale = ContentScale.Fit
                            )
                        }

                        Text(
                            text = it.description,
                            fontSize = 16.sp,
                            modifier = modifier.padding(vertical = 6.dp, horizontal = 16.dp)
                        )
                    }
                }
            }
        }

        Column(modifier = modifier
            .fillMaxWidth()
            .weight(1f)) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(160.dp),
                contentPadding = PaddingValues(4.dp),
                modifier = modifier
            ) {

                items(imageList.shuffled()) { imageRes ->

                    Column(
                        modifier = modifier
                            .background(color = Color(0XFF202124))
                            .clip(RoundedCornerShape(16.dp))
                            .padding(vertical = 10.dp, horizontal = 10.dp)
                            .clickable {
                                imageData = imageRes
                            }) {

                        Image(
                            painter = painterResource(imageRes.image),
                            contentDescription = null,
                            modifier = Modifier
                                .aspectRatio(1f)
                                .clip(RoundedCornerShape(10.dp))
                                .fillMaxSize(),

                            contentScale = ContentScale.FillBounds
                        )

                        Row (verticalAlignment = Alignment.CenterVertically){
                            Image(
                                painter = painterResource(imageRes.image),
                                contentDescription = "",
                                modifier = modifier
                                    .clip(CircleShape)
                                    .size(16.dp),
                                contentScale = ContentScale.Crop
                            )

                            Text(
                                text = imageRes.title,
                                fontSize = 12.sp,
                                color = Color.White,
                                modifier = modifier.padding(
                                    horizontal = 6.dp,
                                    vertical = 6.dp
                                )
                            )
                        }

                        Text(
                            text = imageRes.description,
                            fontSize = 16.sp,
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }


    }
}
