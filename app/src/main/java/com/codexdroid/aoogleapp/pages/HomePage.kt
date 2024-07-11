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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Enter
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codexdroid.aoogleapp.R
import com.codexdroid.aoogleapp.common_ui.ProfileTooltip
import com.codexdroid.aoogleapp.ui.theme.fontProductSansBold
import com.codexdroid.aoogleapp.ui.theme.fontProductSansNormal
import com.codexdroid.aoogleapp.utils.showSnack


@Preview
@Composable
fun HomePreview(modifier: Modifier = Modifier) {
    HomePage({i,s -> },{})
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun HomePage(
    onNavigate: (Int, String) -> Unit,
    onViewResume: () -> Unit,
    modifier: Modifier = Modifier) {

    var gmail by remember { mutableStateOf(false) }
    var profile by remember { mutableStateOf(false) }

    var inputSearch by remember { mutableStateOf("") }

    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState, modifier = modifier)
        }) {

        Box (modifier = modifier
            .padding(it)
            .fillMaxSize()
            .background(color = Color(0XFF202124))) {

            Box(
                modifier= modifier.align(alignment = Alignment.TopStart),
                contentAlignment = Alignment.TopEnd) {

                Column {
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = modifier.padding(start = 6.dp, top = 6.dp, end = 6.dp)){

                        Row {
                            Text(
                                text = "Gmail",
                                color = Color.White,
                                fontFamily = fontProductSansNormal,
                                modifier = modifier
                                    .padding(6.dp)
                                    .clickable { gmail = true })

                            Text(
                                text = "Images",
                                color = Color.White,
                                fontFamily = fontProductSansNormal,
                                modifier = modifier
                                    .padding(6.dp)
                                    .clickable { onNavigate(4,inputSearch) })

                            Text(
                                text = "Resume",
                                color = Color.White,
                                fontFamily = fontProductSansNormal,
                                modifier = modifier
                                    .padding(6.dp)
                                    .clickable { onViewResume() })
                        }
                        Spacer(modifier = modifier.weight(1f))
                        Row (verticalAlignment = Alignment.CenterVertically,
                            modifier = modifier.padding(end = 10.dp)){

                            IconButton(
                                onClick = { },
                                modifier = modifier) {

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
                                    .clickable {
                                        profile = true
                                    }
                            )
                        }
                    }


                    if (profile) {
                        Column (
                            modifier = modifier
                                .align(alignment = Alignment.End)
                                .padding(end = 6.dp),
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.End) {
                            ProfileTooltip(onClose = { profile = false })
                        }
                    }
                }
            }
            //===================================================================================================CENTRAL
            Column (
                modifier = modifier
                    .padding(top = 160.dp)) {
                Text (
                    text = "Google",
                    fontSize = 45.sp,
                    fontFamily = fontProductSansBold,
                    color = Color.White,
                    modifier = modifier
                        .padding(10.dp)
                        .align(alignment = Alignment.CenterHorizontally)
                )

                OutlinedTextField (
                    value = inputSearch,
                    placeholder = { Text("Search for me") },
                    onValueChange = { s -> inputSearch = s },
                    modifier = modifier
                        .fillMaxWidth()
                        .align(alignment = Alignment.CenterHorizontally)
                        .padding(start = 10.dp, end = 10.dp)
                        .onKeyEvent { event ->
                            if (inputSearch.isNotEmpty()) {
                                if (event.key == Enter) {
                                    val search = inputSearch.lowercase()
                                    if (search.contains("experience")) {
                                        onNavigate(1, inputSearch)
                                    } else if (search.contains("project") || search.contains("work")) {
                                        onNavigate(2, inputSearch)
                                    } else if (search.contains("education") || search.contains("school") || search.contains(
                                            "collage"
                                        )
                                    ) {
                                        onNavigate(3, inputSearch)
                                    } else if (search.contains("image") || search.contains("photo") || search.contains(
                                            "pics"
                                        )
                                    ) {
                                        onNavigate(4, inputSearch)
                                    } else {
                                        onNavigate(0, inputSearch)
                                    }
                                }
                            }
                            true

                        },
                    shape = RoundedCornerShape(30.dp),
                    textStyle = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = fontProductSansNormal,
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = modifier.padding(start = 16.dp)
                        )
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Mic,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = modifier.padding(end = 16.dp)
                        )
                    },
                    keyboardActions = KeyboardActions(
                        onDone = {
                            if (inputSearch.isNotEmpty()) {
                                val search = inputSearch.lowercase()
                                if (search.contains("experience")) {
                                    onNavigate(1, inputSearch)
                                } else if (search.contains("project") || search.contains("work")) {
                                    onNavigate(2, inputSearch)
                                } else if (search.contains("education") || search.contains("school") || search.contains(
                                        "collage"
                                    )
                                ) {
                                    onNavigate(3, inputSearch)
                                } else if (search.contains("image") || search.contains("photo") || search.contains(
                                        "pics"
                                    )
                                ) {
                                    onNavigate(4, inputSearch)
                                } else {
                                    onNavigate(0, inputSearch)
                                }
                            }
                        }
                    ),
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0XFFDFE1E5)
                    ),
                )
            }

            //===================================================================================================FOOTER
            Row (
                modifier = modifier
                    .align(alignment = Alignment.BottomCenter)
                    .background(color = Color(0xFF313335))
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text (
                    text = "India, MH15--",
                    color = Color.White,
                    modifier = modifier.weight(1f),
                    fontFamily = fontProductSansNormal,
                )

                Text (
                    text = "Mobile Version-1.Alpha",
                    color = Color.White,

                    textAlign = TextAlign.Center,
                    fontFamily = fontProductSansNormal,
                )
            }


            //SHow Snack
            if (gmail) {
                Box(modifier = modifier
                    .align(alignment = Alignment.BottomCenter)
                    .padding(bottom = 35.dp)
                ) {
                    showSnack(onDismissed = {gmail = false}, message = "pawarakshay13@gmail.com")
                }
            }
        }
    }
}