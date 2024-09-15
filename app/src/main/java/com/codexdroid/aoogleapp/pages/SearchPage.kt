package com.codexdroid.aoogleapp.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Enter
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codexdroid.aoogleapp.common_ui.horizontalLine
import com.codexdroid.aoogleapp.common_ui.ProfileTooltip
import com.codexdroid.aoogleapp.common_ui.TopMenu
import com.codexdroid.aoogleapp.data.SearchMenu
import com.codexdroid.aoogleapp.data.searchMenu
import com.codexdroid.aoogleapp.ui.theme.fontProductSansBold
import com.codexdroid.aoogleapp.ui.theme.fontProductSansNormal
import pages.Images
import pages.Experience
import com.codexdroid.aoogleapp.utils.showSnack

@Preview
@Composable
fun SearchPreview(modifier: Modifier = Modifier) {
    searchPage({},"Akshay")
}
@Composable
fun searchPage(
    onNavigate: () -> Unit,
    userInput: String,
    modifier: Modifier = Modifier,
    currentTabId: Int = 0) {

        var inputSearch by remember { mutableStateOf(userInput) }
        var currentId by remember { mutableIntStateOf(currentTabId) }
        var gmail by remember { mutableStateOf(false) }
        var profile by remember { mutableStateOf(false) }

        Box(modifier = modifier
            .fillMaxSize()
            .background(color = Color(0XFF202124))) {

            Column {

//                TopMenu(onClickGoogle = {
//                    onNavigate()
//                }, onClickedImages = { profile = true })


                Text(
                    text = "Google",
                    fontSize = 25.sp,
                    fontFamily = fontProductSansBold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = TextStyle(fontFamily = fontProductSansNormal),
                    modifier = modifier
                        .padding(10.dp)
                        .align(alignment = Alignment.CenterHorizontally)
                        .clickable {}
                )


                //================================HEADER===================================
                Row(modifier = modifier
                    .padding(horizontal = 10.dp)
                    .background(color = Color(0XFF303134), shape = CircleShape),
                    verticalAlignment = Alignment.CenterVertically) {




                    BasicTextField(
                        value = inputSearch,
                        onValueChange = { inputSearch = it },
                        modifier = modifier
                            .padding(start = 16.dp)
                            .weight(1f)
                            .onKeyEvent { event ->
                                if (inputSearch.isNotEmpty()) {
                                    if (event.key == Enter) {
                                        val search = inputSearch.lowercase()

                                        if (search.contains("experience")) {
                                            currentId = 1
                                        } else if (search.contains("project") || search.contains("work")) {
                                            currentId = 2
                                        } else if (search.contains("education") || search.contains("school") || search.contains(
                                                "collage"
                                            )
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
                        textStyle = TextStyle(
                            color = Color.White,
                            fontSize = 14.sp,
                            fontFamily = fontProductSansNormal),
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
                }


                //================================MENU=====================================
                Column {
                    LazyRow(modifier = modifier.padding(start = 10.dp, end = 10.dp, top = 12.dp)) {
                        items(searchMenu) {
                            menuItem(menu = it,
                                currentId = currentId,
                                onMenuClicked = {id ->
                                    currentId = id
                                })
                        }
                    }

                    horizontalLine(modifier = modifier)

                    Column(modifier = modifier) {

                        val search = inputSearch.lowercase()
                        if (
                            !search.contains("akshay") &&
                            !search.contains("pawar") &&
                            !search.contains("portfolio") &&
                            !search.contains("experience") &&
                            !search.contains("project") &&
                            !search.contains("work") &&
                            !search.contains("education") &&
                            !search.contains("school") &&
                            !search.contains("collage") &&
                            !search.contains("image") &&
                            !search.contains("photo") &&
                            !search.contains("pics")) {


                            Row(modifier = modifier.padding(top = 20.dp)) {

                                Text(
                                    text = "Did you mean: ",
                                    color = Color(0xFFFF7769),
                                    fontFamily = fontProductSansNormal

                                    )
                                Text(
                                    text = "Akshay Pawar",
                                    color = Color(0XFF99C3FF),
                                    fontStyle = FontStyle.Italic,
                                    fontFamily = fontProductSansNormal,
                                    modifier = modifier
                                        .clickable {
                                            inputSearch = "Akshay Pawar"
                                        }
                                )
                            }
                        }

                        Row {

                            when(currentId) {
                                1 -> {
                                    Experience(modifier)
                                }
                                2 -> {
                                    project(modifier)
                                }
                                3 -> {
                                    Education(modifier)
                                }
                                4 -> {
                                    Images(modifier)
                                }
                                else -> {
                                    About(modifier = modifier)
                                }
                            }
                        }
                    }
                }
            }

//            if (profile) {
//                ProfileTooltip(
//                    onClose = { profile = false },
//                    modifier = modifier
//                        .align(alignment = Alignment.TopEnd)
//                )
//            }
        }

        //SHow Snack
        if (gmail) {
            Box(modifier = modifier
                .padding(bottom = 35.dp)) {
                showSnack(onDismissed = { gmail = false }, message = "pawarakshay13@gmail.com")
            }
        }
    }


//Menu Below Search Bar
@Composable
fun menuItem (
    menu: SearchMenu,
    currentId: Int,
    onMenuClicked: (Int) -> Unit,
    modifier: Modifier = Modifier) {

    val textMeasurer = rememberTextMeasurer()
    var sizeInDp = with(LocalDensity.current) {
        textMeasurer.measure(menu.text).size.width.toDp()
    }

    Column (modifier = modifier .pointerHoverIcon(icon = PointerIcon.Hand)){

        Text(
            menu.text,
            fontFamily = fontProductSansNormal,
            modifier = modifier
                .padding(horizontal = 10.dp)
                .clickable { onMenuClicked(menu.id) },
            color = if(menu.id == currentId) Color(0XFF8AB4F8) else Color.White,
            fontSize = 12.sp
        )

        Spacer(modifier = modifier.padding(2.dp))

        if (menu.id == currentId) {
            sizeInDp = sizeInDp.plus(10.dp)

            HorizontalDivider(
                modifier = modifier
                    .width(sizeInDp)
                    .align(alignment = Alignment.CenterHorizontally),
                thickness = 2.dp,
                color = Color(0XFF8AB4F8)
            )
        }
    }
}
