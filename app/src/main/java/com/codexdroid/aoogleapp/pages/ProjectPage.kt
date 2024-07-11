package com.codexdroid.aoogleapp.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codexdroid.aoogleapp.common_ui.horizontalLine
import com.codexdroid.aoogleapp.common_ui.SideInfo
import com.codexdroid.aoogleapp.common_ui.latestCommon
import com.codexdroid.aoogleapp.common_ui.questionsItem
import com.codexdroid.aoogleapp.common_ui.verticalLine
import com.codexdroid.aoogleapp.data.pageAllQuestionsList
import com.codexdroid.aoogleapp.data.projectsListPost
import com.codexdroid.aoogleapp.data.projectsListPre
import com.codexdroid.aoogleapp.data.projectsQuestions
import com.codexdroid.aoogleapp.ui.theme.fontProductSansNormal

@Preview
@Composable
fun ProjectPreview(modifier: Modifier = Modifier) {
    project()
}

@Composable
fun project(modifier: Modifier = Modifier) {

    val questionsList = remember { pageAllQuestionsList.toMutableStateList() }
    var currentId by remember { mutableIntStateOf(-1) }

    Column (modifier = modifier
        .background(color = Color(0XFF202124))
        .padding(horizontal = 10.dp)
    ) {
        //============================LATEST COMPANY, PROJECT, EDUCATION=================================
        LazyColumn(modifier = modifier.padding(top = 10.dp)) {

            items(projectsListPre) {
                latestCommon(it,modifier)
            }

            item {
                Text(
                    text = "People also ask",
                    color = Color(0XFFE8E8E8),
                    fontSize = 20.sp,
                    fontFamily = fontProductSansNormal,
                    modifier = modifier.padding(top = 12.dp)
                )

                horizontalLine(modifier.padding(top = 6.dp))
            }

            items(projectsQuestions) { questions ->

                questionsItem(
                    question = questions,
                    currentId,
                    onClickOpen = { id ->
                        currentId = if (currentId == id) -1 else id
                    }
                )
            }

            item {
                Spacer(modifier = modifier.padding(top = 10.dp))
            }
            items(projectsListPost) {
                latestCommon(it,modifier)
            }

            item {
                Spacer(modifier = modifier.padding(vertical = 20.dp))
            }

        }
    }
}