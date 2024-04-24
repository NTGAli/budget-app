package com.ntg.designsystem.components

import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ntg.designsystem.model.DonutChartData
import com.ntg.designsystem.model.DonutChartDataCollection
import kotlin.math.pow
import kotlin.math.sqrt

@Composable
fun CircleChart(
    modifier: Modifier = Modifier,
    chartSize: Dp = 350.dp,
    data: DonutChartDataCollection,
    gapPercentage: Float = 0.01f,
    selectionView: @Composable (selectedItem: DonutChartData?) -> Unit = {},
) {
    var selectedIndex by remember { mutableIntStateOf(-1) }
    val animationTargetState = (0..data.items.size).map {
        remember { mutableStateOf(DonutChartState()) }
    }
    val animValues = (0..data.items.size).map {
        animateDpAsState(
            targetValue = animationTargetState[it].value.stroke,
            animationSpec = TweenSpec(700), label = ""
        )
    }
    val anglesList: MutableList<DrawingAngles> = remember { mutableListOf() }
    val gapAngle = data.calculateGapAngle(gapPercentage)
    var center = Offset(0f, 0f)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 24.dp),
        contentAlignment = Alignment.Center,
    ) {
        Canvas(
            modifier = Modifier
                .size(chartSize)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = { tapOffset ->
                            handleCanvasTap(
                                center = center,
                                tapOffset = tapOffset,
                                anglesList = anglesList,
                                currentSelectedIndex = selectedIndex,
                                currentStrokeValues = animationTargetState.map { it.value.stroke.toPx() },
                                onItemSelected = { index ->
                                    selectedIndex = index
                                    animationTargetState[index].value = DonutChartState(
                                        DonutChartState.State.Selected
                                    )
                                },
                                onItemDeselected = { index ->
                                    animationTargetState[index].value = DonutChartState(
                                        DonutChartState.State.Unselected
                                    )
                                },
                                onNoItemSelected = {
                                    selectedIndex = -1
                                }
                            )
                        }
                    )
                },
            onDraw = {
                val defaultStrokeWidth = STROKE_SIZE_UNSELECTED.toPx()
                center = this.center
                anglesList.clear()
                var lastAngle = 0f
                data.items.forEachIndexed { ind, item ->
                    val sweepAngle = data.findSweepAngle(ind, gapPercentage)
                    anglesList.add(DrawingAngles(lastAngle, sweepAngle))
                    val strokeWidth = animValues[ind].value.toPx()
                    drawArc(
                        color = item.color,
                        startAngle = lastAngle,
                        sweepAngle = sweepAngle,
                        useCenter = false,
                        topLeft = Offset(defaultStrokeWidth / 2, defaultStrokeWidth / 2),
                        style = Stroke(strokeWidth, cap = StrokeCap.Butt),
                        size = Size(size.width - defaultStrokeWidth,
                            size.height - defaultStrokeWidth)
                    )
                    lastAngle += sweepAngle + gapAngle
                }
            }
        )
        selectionView(if (selectedIndex >= 0) data.items[selectedIndex] else null)
    }
}

private fun handleCanvasTap(
    center: Offset,
    tapOffset: Offset,
    anglesList: List<DrawingAngles>,
    currentSelectedIndex: Int,
    currentStrokeValues: List<Float>,
    onItemSelected: (Int) -> Unit = {},
    onItemDeselected: (Int) -> Unit = {},
    onNoItemSelected: () -> Unit = {},
) {
    val normalized = tapOffset.findNormalizedPointFromTouch(center)
    val touchAngle =
        calculateTouchAngleAccordingToCanvas(center, normalized)
    val distance = findTouchDistanceFromCenter(center, normalized)

    var selectedIndex = -1
    var newDataTapped = false

    anglesList.forEachIndexed { ind, angle ->
        val stroke = currentStrokeValues[ind]
        if (angle.isInsideAngle(touchAngle)) {
            if (distance > (center.x - stroke) &&
                distance < (center.x)
            ) {
                selectedIndex = ind
                newDataTapped = true
            }
        }
    }

    if (selectedIndex >= 0 && newDataTapped) {
        onItemSelected(selectedIndex)
    }
    if (currentSelectedIndex >= 0) {
        onItemDeselected(currentSelectedIndex)
        if (currentSelectedIndex == selectedIndex || !newDataTapped) {
            onNoItemSelected()
        }
    }
}

private fun DonutChartDataCollection.calculateGap(gapPercentage: Float): Float {
    if (this.items.isEmpty()) return 0f

    return (this.totalAmount / this.items.size) * gapPercentage
}

private fun DrawingAngles.isInsideAngle(angle: Float) = angle > this.start && angle < this.start + this.end


private fun findTouchDistanceFromCenter(center: Offset, touch: Offset) =
    sqrt((touch.x - center.x).pow(2) + (touch.y - center.y).pow(2))


private fun DonutChartDataCollection.getTotalAmountWithGapIncluded(gapPercentage: Float): Float {
    val gap = this.calculateGap(gapPercentage)
    return this.totalAmount + (this.items.size * gap)
}


private fun DonutChartDataCollection.calculateGapAngle(gapPercentage: Float): Float {
    val gap = this.calculateGap(gapPercentage)
    val totalAmountWithGap = this.getTotalAmountWithGapIncluded(gapPercentage)

    return (gap / totalAmountWithGap) * com.ntg.designsystem.components.TOTAL_ANGLE
}

private fun Offset.findNormalizedPointFromTouch(canvasCenter: Offset) =
    Offset(this.x, canvasCenter.y + (canvasCenter.y - this.y))


private fun calculateTouchAngleAccordingToCanvas(canvasCenter: Offset, normalizedPoint: Offset): Float {
    val angle = calculateTouchAngleInDegrees(canvasCenter, normalizedPoint)
    return adjustAngleToCanvas(angle).toFloat()
}

private fun adjustAngleToCanvas(angle: Double) = (angle + TOTAL_ANGLE) % TOTAL_ANGLE


private fun calculateTouchAngleInDegrees(canvasCenter: Offset, normalizedPoint: Offset): Double {
    val touchInRadian = kotlin.math.atan2(normalizedPoint.y - canvasCenter.y,
        normalizedPoint.x - canvasCenter.x)
    return touchInRadian * -180 / Math.PI // Convert radians to angle in degrees
}


private fun DonutChartDataCollection.findSweepAngle(
    index: Int,
    gapPercentage: Float
): Float {
    val amount = items[index].amount
    val gap = this.calculateGap(gapPercentage)
    val totalWithGap = getTotalAmountWithGapIncluded(gapPercentage)
    val gapAngle = this.calculateGapAngle(gapPercentage)
    return ((((amount + gap) / totalWithGap) * com.ntg.designsystem.components.TOTAL_ANGLE)) - gapAngle
}



private data class DrawingAngles(val start: Float, val end: Float)

private class DonutChartState(
    val state: State = State.Unselected
) {
    val stroke: Dp
        get() = when (state) {
            State.Selected -> STROKE_SIZE_SELECTED
            State.Unselected -> STROKE_SIZE_UNSELECTED
        }

    enum class State {
        Selected, Unselected
    }
}

private const val TOTAL_ANGLE = 360.0f
private val STROKE_SIZE_UNSELECTED = 40.dp
private val STROKE_SIZE_SELECTED = 60.dp