package com.codexdroid.aoogleapp.common_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Directions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codexdroid.aoogleapp.R
import com.codexdroid.aoogleapp.ui.theme.fontProductSansNormal

@Preview
@Composable
fun LocationItemPreview(modifier: Modifier = Modifier) {
    locationItems()
}

@Composable
fun locationItems(
    modifier: Modifier = Modifier,
    menuItem: MapItemData = commonMapItemsList.first()) {

    val uriHandler = LocalUriHandler.current

    Column (modifier = modifier.background(color = Color(0XFF202124))) {

        horizontalLine(modifier = modifier.padding(vertical = 14.dp))

        Row (verticalAlignment = Alignment.CenterVertically) {

            Column (modifier = modifier.weight(1f)) {

                Text(
                    text = menuItem.title,
                    color = Color(0XFFE8E8E8),
                    fontSize = 16.sp,
                    fontFamily = fontProductSansNormal,
                    modifier = modifier
                        .clickable {
                            menuItem.directionUrl?.let {
                                uriHandler.openUri(it)
                            }
                        }
                )

                Text(
                    text = menuItem.address,
                    color = Color(0XFFBDC1C6),
                    fontSize = 12.sp,
                    fontFamily = fontProductSansNormal,
                    modifier = modifier
                        .clickable {
                            menuItem.directionUrl?.let {
                                uriHandler.openUri(it)
                            }
                        }
                )

                if(menuItem.rating != 0) {

                    Row (verticalAlignment = Alignment.CenterVertically) {

                        Text(
                            text = menuItem.rating.toDouble().toString(),
                            color = Color(0XFFBDC1C6),
                            fontFamily = fontProductSansNormal
                        )

                        Spacer(modifier.padding(start = 2.dp))

                        ratingBar()

                        smallDot()

                        menuItem.type?.let {
                            Text(
                                text = it,
                                color = Color(0XFFBDC1C6),
                                fontSize = 12.sp,
                                fontFamily = fontProductSansNormal
                            )
                        }
                    }
                }

                Text(
                    text = menuItem.hours,
                    color = Color(0XFFBDC1C6),
                    fontSize = 12.sp,
                    fontFamily = fontProductSansNormal
                )
            }

            Row (modifier = modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center){

                menuItem.websiteUrl?.let {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        IconButton({
                            uriHandler.openUri(it)
                        }, modifier = modifier
                            .border(
                                width = 1.dp,
                                shape = CircleShape,
                                color = Color(0XFFB1C5FF)
                            )
                            .size(38.dp)
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_globe_asia),
                                contentDescription = null,
                                tint = Color(0XFFB1C5FF)
                            )
                        }

                        Spacer(modifier = modifier.padding(vertical = 1.dp))

                        Text(
                            text = "Website",
                            color = Color(0XFFB1C5FF),
                            fontFamily = fontProductSansNormal
                        )
                    }
                }

                Spacer(modifier.padding(horizontal = 8.dp))

                menuItem.directionUrl?.let {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {

                        IconButton({
                            uriHandler.openUri(it)
                        }, modifier = modifier
                            .border(
                                width = 1.dp,
                                shape = CircleShape,
                                color = Color(0XFFB1C5FF)
                            )
                            .size(38.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Directions,
                                contentDescription = null,
                                tint = Color(0XFFB1C5FF)
                            )
                        }

                        Spacer(modifier = modifier.padding(vertical = 1.dp))

                        Text(
                            text = "Direction",
                            color = Color(0XFFB1C5FF),
                            fontFamily = fontProductSansNormal
                        )
                    }
                }
            }
        }
    }
}