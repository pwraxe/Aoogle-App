package com.codexdroid.aoogleapp.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codexdroid.aoogleapp.R
import com.codexdroid.aoogleapp.common_ui.ProfileTooltip
import com.codexdroid.aoogleapp.common_ui.TopMenu
import com.codexdroid.aoogleapp.common_ui.horizontalLine
import com.codexdroid.aoogleapp.data.SearchMenu
import com.codexdroid.aoogleapp.data.searchMenu
import com.codexdroid.aoogleapp.utils.showSnack
import pages.Experience
import pages.Images

@Preview(device = "spec:id=reference_desktop,shape=Normal,width=1920,height=1080,unit=dp,dpi=160")
@Composable
fun SearchViewPreview(modifier: Modifier = Modifier) {
    LocalSearchPage({},"Akshay")
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun LocalSearchPage(
    onNavigate: () -> Unit,
    userInput: String,
    modifier: Modifier = Modifier,
    currentTabId: Int = 0) {

    var inputSearch by remember { mutableStateOf(userInput) }
    var currentId by remember { mutableIntStateOf(currentTabId) }
    var gmail by remember { mutableStateOf(false) }
    var profile by remember { mutableStateOf(false) }

    Column (modifier = modifier.background(color = Color(0XFF202124))){

        //==========================HEADER============================
        when(calculateWindowSizeClass().widthSizeClass) {
            WindowWidthSizeClass.Compact, WindowWidthSizeClass.Medium -> {
                Column {
                    Row (verticalAlignment = Alignment.CenterVertically,
                        modifier = modifier.padding (start = 10.dp, end = 10.dp)) {

                        Box (modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {

                            Text(
                                text = "Google",
                                fontSize = 25.sp,
                                color = Color.White,
                                modifier = modifier
                                    .align(alignment = Alignment.Center)
                                    .clickable {}
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
                                        .clickable { }
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

                Row (modifier = modifier
                    .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically) {

                    Text(
                        text = "Google",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = modifier
                            .padding(start = 20.dp)
                            .pointerHoverIcon(icon = PointerIcon.Hand)
                            .clickable {}
                    )

                    Row(modifier = modifier
                        .padding(start = 20.dp, end = 160.dp)
                        .background(
                            color = Color(0XFF303134),
                            shape = CircleShape).weight(1f)
                        .weight(1f),
                        verticalAlignment = Alignment.CenterVertically) {

                        BasicTextField(
                            value = "", //inputSearch,
                            onValueChange = {},
                            modifier = modifier
                                .padding(10.dp)
                                .weight(1f)
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

                    Spacer(modifier = modifier.weight(0.3f))


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
        }


        //==========================MENU============================

        when(calculateWindowSizeClass().widthSizeClass) {
            WindowWidthSizeClass.Compact, WindowWidthSizeClass.Medium -> {

            }
            WindowWidthSizeClass.Expanded -> {

            }
        }
    }

}