package com.ntg.designsystem.components

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ntg.budgetapp.core.designsystem.R
import com.ntg.designsystem.util.detectCardType
import com.ntg.designsystem.util.mask

@Composable
fun Card(
    modifier: Modifier = Modifier,
    card: ImageVector,
    cardNumber: String,
    name: String,
    fullView: Boolean = false
) {

    var imageModifier by remember {
        mutableStateOf(Modifier.fillMaxWidth())
    }

    var height by remember {
        mutableStateOf(0.dp)
    }

    val localDensity = LocalDensity.current


    val animatedHeight = if (height != 0.dp) {
        animateIntAsState(
            targetValue = if (!fullView) height.value.toInt() else 150,
            label = "alpha",
            animationSpec = tween(
                500
            )
        )
    } else {
        animateIntAsState(
            targetValue = if (!fullView) 500 else 150,
            label = "alpha",
            animationSpec = tween(
                500
            )
        )
    }


    val animatedAlpha by animateFloatAsState(
        targetValue = if (animatedHeight.value == height.value.toInt()) 1f else 0f,
        label = "alpha",
        animationSpec = tween(
            300
        )
    )


//    if (fullView){
////        modifier.height(172.dp)
//        imageModifier= Modifier.fillMaxWidth().height(172.dp).clip(RoundedCornerShape(20.dp))
//        Log.d("HHHHHH", height.toString())
//    }else{
//        imageModifier = Modifier.fillMaxWidth()
////        modifier.height(475.dp)
//    }

//    modifier.height(100.dp)

    Log.d("animatedHeight", animatedHeight.value.toString())

    Box(
        modifier
            .height(animatedHeight.value.dp)
            .onGloballyPositioned { layoutCoordinates ->
//        if (!fullView){
//            height = 500
//        }
                Log.d("LLLLLLLLLLLL", height.toString())

            }) {

        Image(
            modifier = imageModifier
                .clip(RoundedCornerShape(20.dp))
                .onGloballyPositioned { layoutCoordinates ->
//                if (!fullView){
                    if (height == 0.dp) {
                        height = with(localDensity) { layoutCoordinates.size.height.toDp() }
                    }
//                }
                    Log.d("LLLLLLLLLLLL --- :", height.toString())

                },
            imageVector = card, contentDescription = null, contentScale = ContentScale.Crop
        )

        Image(
            modifier = Modifier
                .padding(start = 24.dp, top = (height / 3))
                .alpha(animatedAlpha)
                .width(48.dp)
                .height(24.dp),
            imageVector = ImageVector.vectorResource(id = R.drawable.emv_chip),
            contentDescription = null
        )

        CardInfo(
            modifier = Modifier.align(Alignment.BottomCenter),
            cardNumber = cardNumber, name = name, fullView
        )

        if (detectCardType(cardNumber) != -1 && !fullView) {
            Icon(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(24.dp)
                    .alpha(animatedAlpha),
                painter = painterResource(id = detectCardType(cardNumber)),
                contentDescription = null
            )
        }

//        Box(modifier = Modifier
//            .fillMaxWidth()
//            .height(172.dp)
//            .background(Color.Black))
    }
}

@Composable
private fun CardInfo(
    modifier: Modifier,
    cardNumber: String,
    name: String,
    fullView: Boolean,
) {

    val animatedAlpha by animateFloatAsState(
        targetValue = if (!fullView) 0f else 1f,
        label = "alpha",
        animationSpec = tween(
            500
        )
    )




    Column(
        modifier = modifier
            .padding(bottom = 32.dp)
    ) {

        Text(
            modifier = Modifier
                .padding(top = 32.dp, bottom = 16.dp)
                .alpha(animatedAlpha),
            text = "350,000$",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
        )

        Text(
            text = cardNumber.mask("####  ####  ####  ####  ####  ####"), style = TextStyle(
                fontFamily = IPMFont, fontSize = 24.sp, fontWeight = FontWeight.Medium
            ),
            maxLines = 1
        )

        Row(
            modifier = Modifier
                .padding(top = 8.dp)
                .alpha(1 - animatedAlpha)
        ) {
            Text(
                text = name, style = TextStyle(
                    fontFamily = IPMFont, fontWeight = FontWeight.Normal, fontSize = 14.sp
                )
            )
        }
    }

//        if (!fullView){
//
//        }else{
//            Spacer(modifier = Modifier.padding(vertical = 8.dp))
//        }


}


val IPMFont = FontFamily(
    Font(R.font.ipm_regular, FontWeight.Normal),
    Font(R.font.ipm_bold, FontWeight.Bold)
)
