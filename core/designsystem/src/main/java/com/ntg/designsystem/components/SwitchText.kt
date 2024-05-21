package com.ntg.designsystem.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.ntg.designsystem.model.SwitchTextColor

@Composable
fun SwitchText(
    modifier: Modifier = Modifier,
    firstText: String,
    secondText: String,
    color: SwitchTextColor = defaultSwitchTextColor()
){



    Box(
        modifier = modifier
            .onGloballyPositioned {
                Log.d("onGloballyPositioned", "${it.parentLayoutCoordinates?.size?.height?.dp} --- ${it.parentLayoutCoordinates?.size?.width?.dp}")
            }
    ) {
        
        Box(modifier = Modifier
            .onSizeChanged {
                IntSize(500,200)
            }
//            .height()
            .background(Color.Blue)

        )
        
        Row {

            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 16.dp)
                    .clip(RoundedCornerShape(8.dp)),
                text = firstText, style = MaterialTheme.typography.labelMedium.copy(color = color.firstColor))


            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 16.dp)
                    .clip(RoundedCornerShape(8.dp)),
                text = secondText, style = MaterialTheme.typography.labelMedium.copy(color = color.firstColor))


        }
    }

}


@Composable
private fun defaultSwitchTextColor(): SwitchTextColor{
    return SwitchTextColor(
        firstColor = MaterialTheme.colorScheme.error,
        secondColor = MaterialTheme.colorScheme.tertiary,
        firstBackColor = MaterialTheme.colorScheme.errorContainer,
        secondBackColor = MaterialTheme.colorScheme.tertiaryContainer
    )
}