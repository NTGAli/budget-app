package com.ntg.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun MessageBox(
    modifier: Modifier = Modifier,
    text: String,
    type: ButtonType = ButtonType.Primary,
    textButton: String? = null,
    icon: Painter?= null,
    buttonClick:() -> Unit = {}
){

    var background = MaterialTheme.colorScheme.primaryContainer
    var textColor = MaterialTheme.colorScheme.primary

    when(type){
        ButtonType.Primary -> {
            background = MaterialTheme.colorScheme.primaryContainer
            textColor = MaterialTheme.colorScheme.primary
        }
        ButtonType.Secondary -> {
            background = MaterialTheme.colorScheme.secondaryContainer
            textColor = MaterialTheme.colorScheme.secondary
        }
        ButtonType.Success -> {
            background = MaterialTheme.colorScheme.tertiaryContainer
            textColor = MaterialTheme.colorScheme.tertiary
        }
        ButtonType.Error -> {
            background = MaterialTheme.colorScheme.errorContainer
            textColor = MaterialTheme.colorScheme.error
        }
    }


    Row(
        modifier = modifier
            .background(color = background, shape = RoundedCornerShape(8.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {

        if (icon != null){
            Icon(
                modifier = Modifier.padding(end = 4.dp).size(16.dp),
                painter = icon, contentDescription = "icon", tint = textColor)
        }

        Text(text = text, style = MaterialTheme.typography.labelSmall, color = textColor)

        if (textButton != null){
            Button(
                modifier = Modifier.padding(start = 8.dp),
                text = textButton, type = type, style = ButtonStyle.Outline, size = ButtonSize.XS){
                buttonClick.invoke()
            }
        }

    }

}