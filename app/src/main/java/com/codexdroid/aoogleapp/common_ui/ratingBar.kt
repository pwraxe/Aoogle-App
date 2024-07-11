package com.codexdroid.aoogleapp.common_ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ratingBar(modifier: Modifier = Modifier, rating: Int = 4) {

    Row {
        repeat(rating) {
            Icon(
                imageVector = Icons.Default.StarRate,
                contentDescription = "Star",
                tint = Color(0XFFF6D165),
                modifier = modifier.size(12.dp)
            )
        }
        Icon(
            imageVector = Icons.Default.StarRate,
            contentDescription = "Star",
            tint = Color(0XFF80868B),
            modifier = modifier.size(12.dp)
        )
    }
}