package com.ntg.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Chips(
    modifier: Modifier,
    title: String = "",
    dismiss: Boolean,
    icon: Painter? = null,
    onClick:()-> Unit
){

    Row(
        modifier = modifier.background(shape = RoundedCornerShape(64.dp), color = MaterialTheme.colorScheme.surface)
            .clip(RoundedCornerShape(64.dp))
            .clickable { onClick.invoke() }
            .padding(horizontal = 8.dp)
            ,
        verticalAlignment = Alignment.CenterVertically) {

        if (icon == null){

            Text(
                modifier = Modifier.padding(vertical = 4.dp),
                text = title, style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.onSurface))
            if (dismiss){
                Icon(
                    modifier = Modifier.padding(start = 4.dp),
                    painter = painterResource(id = R.drawable.remove_circle), contentDescription = "dismiss")
            }
        }else{
            Icon(
                modifier = Modifier.padding(vertical = 6.dp, horizontal = 8.dp),
                painter = icon, contentDescription = null)
        }

    }


}