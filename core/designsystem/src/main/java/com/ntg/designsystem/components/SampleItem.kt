package com.ntg.designsystem.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ntg.designsystem.R

@Composable
fun SampleItem(
    modifier: Modifier = Modifier,
    icon: Painter,
    title: String,
    setDivider: Boolean = true,
    onCLick: () -> Unit
) {

    Column {
        Row(
            modifier = modifier
                .clickable {
                    onCLick.invoke()
                }
                .padding(16.dp)
            ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = icon, contentDescription = null)

            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp),
                text = title, style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onSurfaceVariant))
            Icon(painter = painterResource(id = R.drawable.direction_right_01), contentDescription = null)
        }
        if (setDivider){
            Divider(
                modifier = Modifier.padding(horizontal = 16.dp),
                thickness = 1.dp)
        }
    }

}