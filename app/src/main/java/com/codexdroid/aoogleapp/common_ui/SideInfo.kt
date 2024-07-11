package com.codexdroid.aoogleapp.common_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codexdroid.aoogleapp.data.androidApps
import com.codexdroid.aoogleapp.data.androidAppsLinks
import com.codexdroid.aoogleapp.data.areasWorkedOn
import com.codexdroid.aoogleapp.data.interest
import com.codexdroid.aoogleapp.data.techStackData
import com.codexdroid.aoogleapp.data.techStackDataLinks
import com.codexdroid.aoogleapp.ui.theme.fontProductSansBold
import com.codexdroid.aoogleapp.utils.getActualExperience
import com.codexdroid.aoogleapp.utils.getAge
import data.SocialData
import data.socials

@Preview
@Composable
fun SideInfoPreview(modifier: Modifier = Modifier) {
    SideInfo()
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SideInfo(modifier: Modifier = Modifier) {

    var socialId by remember { mutableIntStateOf(0) }
    var socialUri by remember { mutableStateOf("") }
    val uriHandler = LocalUriHandler.current

    Column (modifier = modifier
        .padding(top = 6.dp)
        .background(color = Color(0xFF33353A))
        .padding(horizontal = 10.dp, vertical = 2.dp)
    ) {


        Text(
            text = "About",
            fontFamily = fontProductSansBold,
            fontSize = 20.sp,
            color = Color.White,
            modifier = modifier
                .background(color = Color(0xFF33353A))
                .padding(vertical = 10.dp)
        )

        Row {
            Text(
                text = "Born: ",
                fontWeight = FontWeight.Bold,
                color = Color.White)
            Text(
                text = "10 July 1996 (age ${getAge()} years), ",
                color = Color.White
            )
            Text(
                text = "Surat, Gujrat",
                color = Color(0XFF99C3FF),
                modifier = modifier
                    .background(color = Color(0xFF33353A))
                    .clickable {
                        uriHandler.openUri("https://maps.app.goo.gl/Vq3CD4yDLS7xb3LG6")
                    }
            )
        }

        Spacer(modifier = modifier.padding(top = 6.dp))

        Row {
            Text(
                text = "Education: ",
                fontWeight = FontWeight.Bold,
                color = Color.White)
            Text(
                text = "Bachelor Degree (IT), ",
                color = Color.White
            )
            Text(
                text = "Pune University (2019)",
                color = Color(0XFF99C3FF),
                modifier = modifier
                    .background(color = Color(0xFF33353A))
                    .clickable {
                        uriHandler.openUri("https://maps.app.goo.gl/RoRQ1v7V8ieN2TPr8")
                    }
            )
        }

        Spacer(modifier = modifier.padding(top = 6.dp))

        Row {
            Text(
                text = "Experience: ",
                fontWeight = FontWeight.Bold,
                color = Color.White)
            Text(
                text = "${getActualExperience()}+ years in Native Android",
                color = Color.White
            )
        }

        Spacer(modifier = modifier.padding(top = 6.dp))

        Row {
            Text(
                text = "Awards: ",
                fontWeight = FontWeight.Bold,
                color = Color.White)
            Text(
                text = "3rd Rank in Class (2017)",
                color = Color.White
            )
        }

        Spacer(modifier = modifier.padding(top = 6.dp))

        FlowRow (modifier = modifier.background(color = Color(0xFF33353A))){

            for (index in techStackDataLinks.indices) {

                val stackData = techStackDataLinks[index]

                if (index == 0) {
                    Text(
                        text = stackData.title,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = modifier.background(color = Color(0xFF33353A)))
                }
                else {
                    Text(
                        text = stackData.title,
                        color = Color(0XFF99C3FF),
                        modifier = modifier
                            .background(color = Color(0xFF33353A))
                            .clickable {
                            stackData.url?.let {
                                uriHandler.openUri(it)
                            }
                        }
                    )
                }
            }

            for (index in techStackData.indices) {

                val stackData = techStackData[index]
                Text(
                    text = stackData.title,
                    color = Color.White,
                    modifier = modifier.background(color = Color(0xFF33353A)))
            }
        }

        FlowRow(modifier = modifier
            .background(color = Color(0xFF33353A))
            .padding(top = 6.dp)

        ) {


            for (index in androidAppsLinks.indices) {
                val appData = androidAppsLinks[index]
                if (index == 0) {
                    Text(
                        text = appData.title,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = modifier.background(color = Color(0xFF33353A)))
                }
                else {
                    Text(
                        text = appData.title,
                        color = Color(0XFF99C3FF),
                        modifier = modifier
                            .background(color = Color(0xFF33353A))
                            .clickable {
                                appData.url?.let {
                                    uriHandler.openUri(it)
                                }
                            }
                    )
                }
            }

            for (index in androidApps.indices) {
                val appData = androidApps[index]
                Text(
                    text = appData.title,
                    color = Color.White,
                    modifier = modifier.background(color = Color(0xFF33353A))
                )
            }
        }

        Spacer(modifier = modifier.padding(top = 6.dp))


        FlowRow {
            for (index in areasWorkedOn.indices) {
                Text(
                    text = areasWorkedOn[index],
                    fontWeight = if (index == 0) FontWeight.Bold else FontWeight.Normal,
                    color = Color.White
                )
            }
        }


        Spacer(modifier = modifier.padding(top = 6.dp))

        FlowRow {
            for (index in interest.indices) {
                Text(
                    text = interest[index],
                    fontWeight = if (index == 0) FontWeight.Bold else FontWeight.Normal,
                    color = Color.White
                )
            }
        }



        HorizontalDivider(
            color = Color(0XFF46484A),
            modifier = modifier
                .background(color = Color(0xFF33353A))
                .padding(vertical = 10.dp))


        Text(text = "Profiles",
            color = Color.White,
            fontSize = 16.sp,
        )

        LazyRow {
            items(socials) {
                SocialView(it,{
                    socialUri = it.url
                    socialId = it.id
                })
            }
        }
    }


    when(socialId) {
        1 -> uriHandler.openUri(socialUri)
        2 -> uriHandler.openUri(socialUri)
        3 -> uriHandler.openUri(socialUri)
        4 -> uriHandler.openUri(socialUri)
        5 -> uriHandler.openUri(socialUri)
        6 -> uriHandler.openUri(socialUri)
        7 -> uriHandler.openUri(socialUri)
        else -> {}
    }
}

//val uriHandler = LocalUriHandler.current
//uriHandler.openUri(socialData.url)


@Composable
fun SocialView(
    socialData: SocialData,
    onIconClicked: () -> Unit,
    modifier: Modifier = Modifier) {


    Image(
        painter = painterResource(socialData.icon),
        contentDescription = null,
        modifier = modifier
            .size(50.dp)
            .padding(horizontal = 8.dp)
            .pointerHoverIcon(icon = PointerIcon.Hand)
            .clickable {
                onIconClicked()
            }
    )

}