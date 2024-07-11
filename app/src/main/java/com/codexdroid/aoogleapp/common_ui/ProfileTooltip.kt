package com.codexdroid.aoogleapp.common_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ProfileTooltipPreview(modifier: Modifier = Modifier) {
    ProfileTooltip({})
}

@Composable
fun ProfileTooltip(
    onClose: () -> Unit,
    modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .background(
                color = Color(0XFF3C4043),
                shape = RoundedCornerShape(6.dp)
            )
    ) {

        Row (modifier = modifier.padding(4.dp)) {

            Column {
                Text(
                    text = "Google Account",
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Text(
                    text = "Akshay Pawar",
                    color = Color.White)
                Text(
                    text = "pawarakshay13@gmail.com",
                    color = Color.White)
            }

            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "",
                tint = Color.White,
                modifier = modifier
                    .clickable { onClose() }
            )
        }
    }
}