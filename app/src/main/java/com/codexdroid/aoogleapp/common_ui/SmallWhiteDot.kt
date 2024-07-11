package com.codexdroid.aoogleapp.common_ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun smallDot(modifier: Modifier = Modifier) {
    Canvas(modifier.padding(horizontal = 8.dp)) {
        drawCircle(color = Color.White, radius = 3f)
    }
}