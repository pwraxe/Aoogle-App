package com.codexdroid.aoogleapp.common_ui

import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun horizontalLine(modifier: Modifier = Modifier) {
    HorizontalDivider(modifier = modifier, color = Color(0XFF313335))
}

@Composable
fun verticalLine(modifier: Modifier = Modifier) {
    VerticalDivider(modifier = modifier, color = Color(0XFF313335))
}