package com.ntg.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale

@Composable
fun Card(
    modifier: Modifier = Modifier,
    card: ImageVector,
){
    Box {

        Image(
            modifier = Modifier.fillMaxWidth(),
            imageVector = card, contentDescription = null, contentScale = ContentScale.Crop)

    }
}