package com.codexdroid.aoogleapp.utils

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp

@SuppressLint("QueryPermissionsNeeded")
@Composable
fun showSnack(
    message: String? = null,
    onDismissed:(Boolean) -> Unit,
    modifier: Modifier = Modifier) {

    val context = LocalContext.current
    val clipManager = LocalClipboardManager.current
    val localUri = LocalUriHandler.current


    Snackbar (
        action = {},
        modifier = modifier.padding(6.dp).animateContentSize(
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 10,
                easing = FastOutSlowInEasing
            )
        ),
        dismissAction = {},
        actionOnNewLine = true,
        shape = RoundedCornerShape(10.dp),
        containerColor = Color.White,
        contentColor = Color.Black,
    ) {

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
                //.align(alignment = Alignment.CenterHorizontally)
        ) {

            Text(
                text = message ?: "Nothing",
                modifier = modifier.weight(1f),
                color = Color.Black
            )

            TextButton(
                onClick = {

                    Intent(Intent.ACTION_SEND).apply {
                        type = "message/rfc822"
                        putExtra(Intent.EXTRA_EMAIL, arrayOf("pawarakshay13@gmail.com"))
                        putExtra(Intent.EXTRA_SUBJECT,"Aoogle App")
                        putExtra(Intent.EXTRA_TEXT,"Hello Akshay, \nI landed from your Aoogle app \n\n[type your message]")
                        setPackage("com.google.android.gm")
                        if (resolveActivity(context.packageManager) != null) {
                            context.startActivity(this)
                        }
                    }
                    onDismissed(false)
                }
            ) {
                Text(text = "Mail Me")
            }
        }
    }
}