package com.codexdroid.aoogleapp.common_ui

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Enter
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codexdroid.aoogleapp.R
import com.codexdroid.aoogleapp.ui.theme.fontProductSansBold
import com.codexdroid.aoogleapp.ui.theme.fontProductSansNormal

@Preview(device = "spec:width=1280dp,height=800dp,dpi=240,orientation=portrait")
@Composable
fun TopMenuPreview(modifier: Modifier = Modifier) {
    TopMenu({},{})
}



@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun TopMenu(
    onClickGoogle: () -> Unit,
    onClickedImages: () -> Unit,
    modifier: Modifier = Modifier) {

    when(calculateWindowSizeClass().widthSizeClass) {
        WindowWidthSizeClass.Compact, WindowWidthSizeClass.Medium -> {

            Column (modifier = modifier){

                Row (verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier.padding (start = 10.dp, end = 10.dp)) {

                    Box (modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {

                        Text(
                            text = "Google",
                            fontSize = 25.sp,
                            fontFamily = fontProductSansBold,
                            color = Color.White,
                            style = TextStyle(fontFamily = fontProductSansNormal),
                            modifier = modifier
                                .align(alignment = Alignment.Center)
                                .clickable {
                                    onClickGoogle()
                                }
                        )

                        Row(
                            modifier = modifier
                                .align(alignment = Alignment.TopEnd)
                                .padding(end = 6.dp),
                            verticalAlignment = Alignment.CenterVertically) {

                            IconButton(
                                onClick = {},
                                modifier = modifier) {
                                Icon(
                                    imageVector = Icons.Default.Notifications,
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            }

                            Image(
                                painter = painterResource(R.drawable.avatar),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = modifier
                                    .clip(CircleShape)
                                    .size(30.dp)
                                    .clickable { onClickedImages() }
                            )
                        }
                    }
                }

                Row(modifier = modifier
                    .padding(start = 20.dp, end = 10.dp)
                    .background(
                        color = Color(0XFF303134),
                        shape = CircleShape),
                    verticalAlignment = Alignment.CenterVertically) {

                    BasicTextField(
                        value = "", //inputSearch,
                        onValueChange = {},
                        modifier = modifier
                            .weight(1f)
                            .padding(10.dp)
                            .padding(start = 10.dp),
                        textStyle = TextStyle(color = Color.White, fontSize = 14.sp),
                        singleLine = true,
                        cursorBrush = Brush.linearGradient(listOf(Color.White, Color.White))
                    )


                    Icon(
                        Icons.Default.Clear,
                        contentDescription = "Clear Search",
                        tint = Color.White,
                        modifier = modifier
                            .padding(horizontal = 6.dp)
                            .clickable {}
                    )

                    VerticalDivider(
                        thickness = 1.dp,
                        color = Color.White,
                        modifier = modifier
                            .padding(4.dp)
                            .height(30.dp))

                    Icon(
                        imageVector = Icons.Default.Mic,
                        contentDescription = "Voice search",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(horizontal = 6.dp)
                            .size(24.dp)
                            .clickable {}
                    )

                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(start = 6.dp, end = 16.dp)
                            .size(24.dp)
                            .clickable {}
                    )
                }

            }

        }
         WindowWidthSizeClass.Expanded -> {
            HeaderLarge()
        }
    }

}


@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(device = "spec:id=reference_tablet,shape=Normal,width=1280,height=800,unit=dp,dpi=240")
@Composable
fun HeaderLarge(modifier: Modifier = Modifier) {

    var paddingStart = 0.dp

    when(calculateWindowSizeClass().widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            paddingStart = 10.dp
        }
        WindowWidthSizeClass.Medium, WindowWidthSizeClass.Expanded -> {
            paddingStart = 30.dp
        }
    }

    Row (modifier = modifier,
        verticalAlignment = Alignment.CenterVertically) {

        Text(
            text = "Google",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = modifier
                .padding(start = paddingStart)
                .pointerHoverIcon(icon = PointerIcon.Hand)
                .clickable {}
        )

        Row(modifier = modifier
            .padding(start = paddingStart, end = 160.dp)
            .weight(1f)
            .background(
                color = Color(0XFF303134),
                shape = CircleShape).weight(1f),
            verticalAlignment = Alignment.CenterVertically) {

            BasicTextField(
                value = "", //inputSearch,
                onValueChange = {},
                modifier = modifier
                    .padding(10.dp)
                    .padding(start = 10.dp)
                    .weight(1f),
                textStyle = TextStyle(color = Color.White, fontSize = 14.sp),
                singleLine = true,
                cursorBrush = Brush.linearGradient(listOf(Color.White, Color.White))
            )


            Icon(
                Icons.Default.Clear,
                contentDescription = "Clear Search",
                tint = Color.White,
                modifier = modifier
                    .padding(horizontal = 6.dp)
                    .clickable {}
            )

            VerticalDivider(
                thickness = 1.dp,
                color = Color.White,
                modifier = modifier
                    .padding(4.dp)
                    .height(30.dp))

            Icon(
                imageVector = Icons.Default.Mic,
                contentDescription = "Voice search",
                tint = Color.White,
                modifier = Modifier
                    .padding(horizontal = 6.dp)
                    .size(24.dp)
                    .clickable {}
            )

            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier
                    .padding(start = 6.dp, end = 16.dp)
                    .size(24.dp)
                    .clickable {}
            )
        }



        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = modifier
                .padding(end = 10.dp)
                //.weight(1f)

        ){
            Text(
                text = "Gmail",
                color = Color.White,
                modifier = modifier
                    .padding(6.dp)
                    .clickable { }
                    .pointerHoverIcon(icon = PointerIcon.Hand)
            )

            Text(
                text = "Images",
                color = Color.White,
                modifier = modifier
                    .padding(6.dp)
                    .clickable {
                        //onClickedImages(4)
                    }
                    .pointerHoverIcon(icon = PointerIcon.Hand)
            )

            IconButton(
                onClick = { },
                modifier = modifier.pointerHoverIcon(icon = PointerIcon.Hand)) {
                Icon(
                    imageVector = Icons.Default.Apps,
                    contentDescription = null,
                    tint = Color.White
                )
            }

            Image(
                painter = painterResource(R.drawable.avatar),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .clip(CircleShape)
                    .size(30.dp)
                    .align(alignment = Alignment.CenterVertically)
                    //.hoverable(interactionSrc,enabled = true)
                    .pointerHoverIcon(icon = PointerIcon.Hand)
            )

//            onHoverProfile(interactionSrc.collectIsHoveredAsState().value)
        }
    }
}


/*
*
*
                Row (modifier = modifier.padding(top = 20.dp),
                    verticalAlignment = Alignment.CenterVertically) {

                    Text(
                        text = "Google",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = modifier
                            .padding(start = 40.dp)
                            .pointerHoverIcon(icon = PointerIcon.Hand)
                            .clickable {
                                onNavigate()
                            }
                    )

                    Row(modifier = modifier
                        .padding(start = 50.dp)
                        .background(color = Color(0XFF303134), shape = CircleShape)
                        .width(650.dp),
                        verticalAlignment = Alignment.CenterVertically) {

                        BasicTextField(
                            value = inputSearch,
                            onValueChange = { inputSearch = it },
                            modifier = modifier
                                .padding(10.dp)
                                .padding(start = 10.dp)
                                .weight(1f)
                                .onKeyEvent { event ->
                                    if (inputSearch.isNotEmpty()) {
                                        if (event.key == Enter) {
                                            val search = inputSearch.lowercase()

                                            if (search.contains("experience")) {
                                                currentId = 1
                                            } else if (search.contains("project") || search.contains(
                                                    "work"
                                                )
                                            ) {
                                                currentId = 2
                                            } else if (search.contains("education") || search.contains(
                                                    "school"
                                                ) || search.contains("collage")
                                            ) {
                                                currentId = 3
                                            } else if (search.contains("image") || search.contains("photo") || search.contains(
                                                    "pics"
                                                )
                                            ) {
                                                currentId = 4
                                            } else {
                                                currentId = 0
                                            }
                                        }
                                    }
                                    true
                                },
                            textStyle = TextStyle(color = Color.White, fontSize = 14.sp),
                            singleLine = true,
                            cursorBrush = Brush.linearGradient(listOf(Color.White, Color.White))
                        )


                        Icon(
                            Icons.Default.Clear,
                            contentDescription = "Clear Search",
                            tint = Color.White,
                            modifier = modifier
                                .padding(horizontal = 6.dp)
                                .clickable {}
                        )

                        VerticalDivider(
                            thickness = 1.dp,
                            color = Color.White,
                            modifier = modifier
                                .padding(4.dp)
                                .height(30.dp))

                        Icon(
                            imageVector = Icons.Default.Mic,
                            contentDescription = "Voice search",
                            tint = Color.White,
                            modifier = Modifier
                                .padding(horizontal = 6.dp)
                                .size(24.dp)
                                .clickable {}
                        )

                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = Color.White,
                            modifier = Modifier
                                .padding(start = 6.dp, end = 16.dp)
                                .size(24.dp)
                                .clickable {
                                    inputSearch = inputSearch
                                    currentId = 0
                                }
                        )
                    }
                }
* */