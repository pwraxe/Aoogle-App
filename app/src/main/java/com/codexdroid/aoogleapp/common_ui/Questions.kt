package com.codexdroid.aoogleapp.common_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codexdroid.aoogleapp.data.QuestionsTemplates
import com.codexdroid.aoogleapp.data.pageAllQuestionsList
import com.codexdroid.aoogleapp.ui.theme.fontProductSansNormal


@Preview
@Composable
fun QuestionPreview(modifier: Modifier = Modifier) {
    questionsItem(pageAllQuestionsList.first(),-1,{})
}
@Composable
fun questionsItem (
    question: QuestionsTemplates,
    currentId: Int,
    onClickOpen: (Int) -> Unit,
    modifier: Modifier = Modifier) {

    Column (
        modifier = modifier.padding(
            top = 6.dp,
            bottom = 6.dp,
            end = 6.dp)
            .background(color = Color(0XFF202124))

    ){

        Row (verticalAlignment = Alignment.CenterVertically) {

            Text(
                text = question.question,
                fontFamily = fontProductSansNormal,
                modifier = modifier
                    .weight(1f)
                    .clickable { onClickOpen(question.id) },
                fontSize = 16.sp,
                color = Color.White
            )

            IconButton(
                onClick = { onClickOpen(question.id) },
                modifier = modifier
                    .background(
                        color = Color(0XFF313335),
                        shape = CircleShape
                    )
                    .padding(2.dp)
                    .size(24.dp)
            ) {

                Icon(
                    imageVector = if(currentId == question.id)
                        Icons.Default.KeyboardArrowUp
                    else Icons.Default.KeyboardArrowDown,
                    contentDescription = "Open",
                    modifier = modifier,
                    tint = Color.White
                )
            }
        }

        if (currentId == question.id) {
            Text(
                text = question.answer,
                color = Color(0XFFBDC1C6),
                fontSize = 12.sp,
                fontFamily = fontProductSansNormal
            )
        }
    }
    horizontalLine()
}