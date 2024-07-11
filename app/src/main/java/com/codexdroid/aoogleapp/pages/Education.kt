package com.codexdroid.aoogleapp.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codexdroid.aoogleapp.R
import com.codexdroid.aoogleapp.common_ui.horizontalLine
import com.codexdroid.aoogleapp.common_ui.latestCommon
import com.codexdroid.aoogleapp.common_ui.locationItems
import com.codexdroid.aoogleapp.common_ui.questionsItem
import com.codexdroid.aoogleapp.data.educationData
import com.codexdroid.aoogleapp.data.educationLocation
import com.codexdroid.aoogleapp.data.educationQuestion
import com.codexdroid.aoogleapp.ui.theme.fontProductSansNormal


@Preview
@Composable
fun EducationPreview(modifier: Modifier = Modifier) {
    Education(modifier)
}

@Composable
fun Education(modifier: Modifier) {

    var currentId by remember { mutableIntStateOf(-1) }

    Column (modifier = modifier
        .fillMaxSize()
        .background(color = Color(0XFF202124))
        .padding(horizontal = 10.dp)
    ) {

        //============================LATEST COMPANY, PROJECT, EDUCATION=================================
        LazyColumn(modifier = modifier.padding(top = 10.dp)) {

            items(educationData) {
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

            items(educationQuestion) { questions ->

                questionsItem(
                    question = questions,
                    currentId,
                    onClickOpen = { id ->
                        currentId = if (currentId == id) -1 else id
                    }
                )
            }


            item {
                Text(
                    text = "Places",
                    color = Color(0XFFE8E8E8),
                    fontSize = 20.sp,
                    fontFamily = fontProductSansNormal,
                    modifier = modifier.padding(top = 26.dp)
                )
            }

            item {
                Image(painter = painterResource(R.drawable.map_education),
                    contentDescription = "",
                    modifier = modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(top = 8.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop,
                )
            }

            items(educationLocation) {
                locationItems(menuItem = it, modifier = modifier)
            }

            item {
                Spacer(modifier = modifier.padding(top = 20.dp))
            }
        }
    }
}