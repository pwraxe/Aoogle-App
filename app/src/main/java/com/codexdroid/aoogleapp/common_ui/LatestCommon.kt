package com.codexdroid.aoogleapp.common_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codexdroid.aoogleapp.data.PageAllItemData
import com.codexdroid.aoogleapp.data.pageAllMainData
import com.codexdroid.aoogleapp.ui.theme.fontProductSansBold
import com.codexdroid.aoogleapp.ui.theme.fontProductSansNormal

@Preview
@Composable
fun LatestCommonPreview(modifier: Modifier = Modifier) {
    latestCommon(pageAllItemData = pageAllMainData.first())
}

@Composable
fun latestCommon(
    pageAllItemData: PageAllItemData,
    modifier: Modifier = Modifier
) {


    val localUri = LocalUriHandler.current

    Column(modifier = modifier.padding(vertical = 16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(pageAllItemData.image),
                contentDescription = "Avatar",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .clip(CircleShape)
                    .size(28.dp)
            )

            Column(modifier = modifier.padding(horizontal = 10.dp)) {

                Text(
                    text = pageAllItemData.heading,
                    fontSize = 14.sp,
                    color = Color(0XFFDADCE0),
                    fontFamily = fontProductSansNormal
                )
                Text(
                    text = pageAllItemData.url + pageAllItemData.url + pageAllItemData.url,
                    fontSize = 12.sp,
                    fontFamily = fontProductSansNormal,
                    color = Color(0XFFDADCE0),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = modifier
                        .clickable {
                            localUri.openUri(pageAllItemData.url)
                        }
                )
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically) {

            Text(
                text = pageAllItemData.title,
                color = Color(0XFF99C3FF),
                fontSize = 20.sp,
                fontFamily = fontProductSansBold,
                modifier = modifier
                    .padding(vertical = 4.dp)
                    .clickable {
                        localUri.openUri(pageAllItemData.url)
                    }
            )
            Icon(
                if (!pageAllItemData.isUrlSafe) Icons.Default.Info else Icons.Default.CheckCircle,
                contentDescription = "Verified",
                tint = if (!pageAllItemData.isUrlSafe) Color.Red else Color(0XFF3DA288),
                modifier = modifier
                    .padding(horizontal = 4.dp)
                    .size(16.dp)
            )
        }

        Text(
            text = pageAllItemData.desc,
            color = Color(0XFFBDC1C6),
            fontSize = 14.sp,
            fontFamily = fontProductSansNormal
        )

        Row(verticalAlignment = Alignment.CenterVertically) {

            Text(
                text = pageAllItemData.duration,
                color = Color.White,
                fontSize = 14.sp,
                fontFamily = fontProductSansNormal
            )

            smallDot()

            Text(
                text = if (pageAllItemData.isFullTime) "Full-Time" else "Part-Time",
                color = Color.White,
                fontSize = 14.sp,
                fontFamily = fontProductSansNormal
            )

            smallDot()

            Text(
                text = pageAllItemData.location,
                color = Color.White,
                fontSize = 14.sp,
                modifier = modifier.padding(vertical = 6.dp),
                fontFamily = fontProductSansNormal
            )
        }
    }
}