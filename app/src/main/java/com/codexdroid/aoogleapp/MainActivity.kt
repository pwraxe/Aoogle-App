package com.codexdroid.aoogleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalUriHandler
import com.codexdroid.aoogleapp.ui.theme.AoogleAppTheme
import com.codexdroid.aoogleapp.utils.PAGE
import com.codexdroid.aoogleapp.common_ui.SideInfo
import com.codexdroid.aoogleapp.pages.HomePage
import com.codexdroid.aoogleapp.pages.searchPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            AoogleAppTheme {

                Starter()
            }
        }
    }
}

@Composable
fun Starter() {


    var currentPage by remember { mutableStateOf(PAGE.HOME.name) }
    var currentTab by remember { mutableIntStateOf(0) }
    var currentString by remember { mutableStateOf("Akshay Pawar") }
    val localUri = LocalUriHandler.current

    when (currentPage) {
        PAGE.HOME.name -> HomePage(
            onNavigate = { id, str ->
                currentPage = PAGE.SEARCH.name
                currentTab = id
                currentString = str
            },
            onViewResume = {
                localUri.openUri("https://drive.google.com/file/d/1LUmOwZ0KiT0J4veLw68jKkgQQ7O4aSn3/view")
            }
        )
        PAGE.SEARCH.name -> searchPage(
            onNavigate = { currentPage = PAGE.HOME.name },
            currentTabId = currentTab, userInput = currentString)
        else -> SideInfo()
    }
}