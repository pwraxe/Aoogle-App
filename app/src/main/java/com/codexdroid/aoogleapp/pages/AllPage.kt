package com.codexdroid.aoogleapp.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.NotificationAdd
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.codexdroid.aoogleapp.R
import com.codexdroid.aoogleapp.common_ui.SideInfo
import com.codexdroid.aoogleapp.common_ui.horizontalLine
import com.codexdroid.aoogleapp.common_ui.smallDot
import com.codexdroid.aoogleapp.data.PageAllItemData
import com.codexdroid.aoogleapp.ui.theme.fontProductSansBold
import com.codexdroid.aoogleapp.ui.theme.fontProductSansNormal
import com.codexdroid.aoogleapp.utils.getAge

@Preview
@Composable
fun AboutPreview(modifier: Modifier = Modifier) {
    About()
}

@Composable
fun About(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 10.dp)
            .background(color = Color(0XFF202124))
    ) {

        LazyColumn {

            item {

                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .background(color = Color(0xFF33353A))
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = modifier.padding(10.dp)
                    ) {
                        Column {
                            Text(
                                text = "Akshay Pawar",
                                color = Color.White,
                                fontFamily = fontProductSansNormal,
                                fontSize = 24.sp,

                                )
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                     text = "Software Developer",
                                    color = Color.White,
                                    fontFamily = fontProductSansNormal,
                                    fontSize = 16.sp,
                                )
                                smallDot()

                                Text(
                                    text = "Android",
                                    color = Color.White,
                                    fontFamily = fontProductSansNormal,
                                    fontSize = 16.sp,
                                )
                            }
                        }
                        Spacer(modifier = modifier.weight(1f))
                        Icon(
                            imageVector = Icons.Default.NotificationAdd,
                            contentDescription = "Notification Icon",
                            modifier = modifier
                                .padding(10.dp)
                                .background(
                                    color = Color(0xFF75D3EF),
                                    shape = CircleShape
                                )
                                .padding(6.dp)
                        )
                    }

                    LazyRow(modifier = modifier.padding(top = 10.dp)) {

                        item {
                            Image(
                                painter = painterResource(R.drawable.avatar),
                                contentDescription = "Profile Pics",
                                contentScale = ContentScale.Crop,
                                modifier = modifier
                                    .padding(start = 6.dp, end = 4.dp)
                                    .size(140.dp, 120.dp)
                                    .clip(RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp))
                            )
                        }

                        item {
                            Image(
                                painter = painterResource(R.drawable.avatar2),
                                contentDescription = "Profile Pics",
                                contentScale = ContentScale.Crop,
                                modifier = modifier
                                    .size(140.dp, 120.dp)
                            )

                        }

                        item {
                            Image(
                                painter = painterResource(R.drawable.avatar3),
                                contentDescription = "Profile Pics",
                                contentScale = ContentScale.Crop,
                                modifier = modifier
                                    .padding(horizontal = 4.dp)
                                    .size(140.dp, 120.dp)
                                    .clip(RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp))
                            )
                        }
                    }

                    Row(
                        modifier = modifier
                            .wrapContentHeight()
                            .height(130.dp)
                    ) {

                        Card(
                            modifier = modifier
                                .padding(start = 10.dp, end = 8.dp, top = 10.dp, bottom = 10.dp)
                                .weight(1f),
                            colors = CardDefaults.cardColors(containerColor = Color(0XFF202124))) {

                            Column(modifier = modifier.padding(10.dp)) {
                                Text(
                                    text = "Age",
                                    fontSize = 14.sp,
                                    fontFamily = fontProductSansNormal,
                                    color = Color.White
                                )

                                Spacer(modifier = modifier.weight(1f))

                                Text(
                                    text = "${getAge()} years",
                                    fontSize = 20.sp,
                                    fontFamily = fontProductSansNormal,
                                    color = Color.White
                                )
                                Text(
                                    text = "10 July 1996",
                                    fontSize = 12.sp,
                                    fontFamily = fontProductSansNormal,
                                    color = Color.White
                                )
                            }
                        }

                        Card(
                            modifier = modifier
                                .padding(end = 10.dp, top = 10.dp, bottom = 10.dp)
                                .weight(1f),
                            colors = CardDefaults.cardColors(containerColor = Color(0XFF202124))
                        ) {
                            Column(modifier = modifier.padding(10.dp)) {
                                Text(
                                    text = "Education",
                                    fontSize = 14.sp,
                                    fontFamily = fontProductSansNormal,
                                    color = Color.White
                                )
                                Spacer(modifier = modifier.weight(1f))

                                Text(
                                    text = "Sir Visvesvaraya Institute of Technology, Chincholi, Nashik, 2014 - 2019",
                                    fontSize = 12.sp,
                                    fontFamily = fontProductSansNormal,
                                    color = Color.White,
                                    lineHeight = 1.2.em
                                )
                            }
                        }
                    }

                    Card(
                        modifier = modifier
                            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
                            .clip(RoundedCornerShape(20.dp)),
                        colors = CardDefaults.cardColors(containerColor = Color(0XFF202124))
                    ) {
                        Text(
                            text = "I am a Software Developer with over 3 years of specialized experience in native Android development using Kotlin. Throughout my career, I have successfully developed nearly 40 applications, including 6 personal, and 16 Organizational apps built fromscratch. I have also contributed to the enhancement of 8 existing applications. I have hosted 8 applications on the Google PlayStore, with 2 Own Crafted.",
                            fontSize = 14.sp,
                            fontFamily = fontProductSansNormal,
                            color = Color(0XFFBDC1C6),
                            modifier = modifier.padding(12.dp)
                        )
                    }
                }
            }

            item {

                HorizontalDivider(thickness = 8.dp, modifier = modifier, color = Color(0XFF202124))
            }

            item {
                SideInfo(modifier = modifier

                    .background(color = Color(0xFF303136))
                )
            }
        }
    }
}