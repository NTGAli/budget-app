package com.ntg.model

import androidx.compose.ui.graphics.painter.Painter

data class NavigationItem(
    val id: Int,
    val title: String,
    val painter: Painter,
    val selectedPainter: Painter,
    val isSelected: Boolean,
    )
