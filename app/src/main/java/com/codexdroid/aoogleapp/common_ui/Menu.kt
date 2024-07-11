package com.codexdroid.aoogleapp.common_ui

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codexdroid.aoogleapp.R
import com.codexdroid.aoogleapp.ui.theme.fontProductSansBold
import com.codexdroid.aoogleapp.ui.theme.fontProductSansNormal

@Preview
@Composable
fun TopMenuPreview(modifier: Modifier = Modifier) {
    TopMenu({},{})
}

@Composable
fun TopMenu(
    onClickGoogle: () -> Unit,
    onClickedImages: () -> Unit,
    modifier: Modifier = Modifier) {

    Row (verticalAlignment = Alignment.CenterVertically, modifier = modifier.padding(end = 10.dp)){

        Box (modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {

            Text(
                text = "Google",
                fontSize = 25.sp,
                fontFamily = fontProductSansBold,
                color = Color.White,
                style = TextStyle(fontFamily = fontProductSansNormal),
                modifier = modifier
                    .align(alignment = Alignment.Center)
                    .clickable {
                        onClickGoogle()
                    }
            )

            Row(
                modifier = modifier.align(alignment = Alignment.TopEnd),
                verticalAlignment = Alignment.CenterVertically) {

                IconButton(
                    onClick = {},
                    modifier = modifier) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
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
                        .clickable { onClickedImages() }
                )
            }
        }
    }
}