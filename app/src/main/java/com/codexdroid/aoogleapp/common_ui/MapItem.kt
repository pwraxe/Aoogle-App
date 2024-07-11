package com.codexdroid.aoogleapp.common_ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class MapItemData(
    var title: String,
    var address: String,
    var hours: String,
    var rating: Int = 0,
    var type: String? = null,
    var websiteUrl: String? = null,
    var directionUrl: String? = null
)

val commonMapItemsList = listOf(
    MapItemData(
        title = "Office",
        address = "8th Floor East-Court, Phoenix Market city,, 808, 809, Viman Nagar, Pune, 411014",
        hours = "Opens: 7 AM - 7 PM",
        rating = 4,
        type = "Corporate office in Pune, Maharashtra",
        websiteUrl = "https://programming.com/",
        directionUrl = "https://maps.app.goo.gl/mFvDUvXGPT2d727f6"
    ),
    MapItemData(
        title = "Home",
        address = "Shivaji Nagar Sinnar, 422103",
        hours = "Opens: 6:00PM - 10PM",
        rating = 0,
    ),
    MapItemData(
        title = "Engineering Collage",
        address = "Nashik - Shirdi Rd, Svit, Maharashtra 422102",
        hours = "Opens: 9 AM - 5 PM",
        rating = 4,
        type = "Engineering Collage, Nashik",
        websiteUrl = "https://svitnashik.in/",
        directionUrl = "https://maps.app.goo.gl/JwPWp5ng68HsfB4C6"
    )
)

@Composable
fun MapItem(
    modifier: Modifier = Modifier,
    menuItem: MapItemData = commonMapItemsList.first()) {

    Row {
        Column {

            Text(
                text = menuItem.title,
                color = Color(0XFFE8E8E8),
                fontSize = 16.sp,
                modifier = modifier.padding(top = 20.dp)
            )

            Text(
                text = menuItem.address,
                color = Color(0XFFBDC1C6),
                fontSize = 12.sp
            )

            Row {
                if(menuItem.rating != 0) {
                    Text(
                        text = menuItem.rating.toString(),
                        color = Color(0XFFBDC1C6)
                    )

                    ratingBar()
                }
            }
        }
    }
}