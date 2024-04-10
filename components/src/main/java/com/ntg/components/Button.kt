package com.ntg.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun Button(
    modifier: Modifier = Modifier,
    text: String,
    imageStart: ImageVector? = null,
    imageEnd: ImageVector? = null,
    painterStart: Painter? = null,
    painterEnd: Painter? = null,
){

}


enum class ButtonStyle{
    Container,
    Outline,
    TextOnly
}

enum class ButtonType{
    Primary,
    Secondary,
    Success,
    Danger,
    Warning
}

enum class ButtonSize{
    XL,
    LG,
    MD,
    SM,
    XS
}