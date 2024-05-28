package com.ntg.insert_transaction

import android.util.Log
import android.widget.TimePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ntg.common.util.formatDate
import com.ntg.common.util.getCurrentTime
import com.ntg.designsystem.components.Button
import com.ntg.designsystem.components.ButtonSize
import com.ntg.designsystem.components.ButtonStyle
import com.ntg.designsystem.components.ButtonType
import com.ntg.designsystem.components.Chips
import com.ntg.designsystem.components.DatePicker
import com.ntg.designsystem.components.ImagePicker
import com.ntg.designsystem.components.SwitchText
import com.ntg.designsystem.components.TextDivider
import com.ntg.designsystem.components.TextField
import com.ntg.designsystem.components.TimePicker
import java.util.Calendar
import java.util.Date

@Composable
fun TransactionInputRute() {
    TransactionInputScreen()
}


@Composable
fun TransactionInputScreen() {


    Scaffold {
        Content(it)
    }


}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
private fun Content(
    paddingValues: PaddingValues
) {

    val focused = remember { mutableStateOf("") }
    val tag = remember { mutableStateOf("") }
    val tags = remember {
        mutableStateListOf<String>()
    }

    val dateSelected = remember { mutableStateOf(formatDate(Date(System.currentTimeMillis()))) }
    val timeSelected = remember { mutableStateOf(getCurrentTime()) }

    val showDatePicker = remember {
        mutableStateOf(false)
    }

    val showTimePicker = remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier.fillMaxHeight()) {
        Column(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .verticalScroll(rememberScrollState())
                .padding(bottom = 64.dp)
        ) {

            SwitchText(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                firstText = "Outcome", secondText = "Income"
            )

            TextField(
                modifier = Modifier.padding(top = 16.dp),
                value = focused,
                label = "Amount",
                trailingIcon = { Text(text = "lbs", color = MaterialTheme.colorScheme.outline) }
            )

            TextField(
                modifier = Modifier.padding(top = 16.dp),
                value = dateSelected,
                label = "Date",
                readOnly = true
            ) {
                showDatePicker.value= true
            }

            TextField(
                modifier = Modifier.padding(top = 16.dp),
                value = timeSelected,
                label = "Time",
                readOnly = true
            ){
                showTimePicker.value = true
            }

            ImagePicker(
                modifier = Modifier.padding(top = 24.dp)
            )

            TextField(
                modifier = Modifier.padding(top = 16.dp),
                value = focused,
                label = "Category",
            )

            TextDivider(
                modifier = Modifier.padding(top = 16.dp),
                title = "Tags"
            )


            TextField(
                modifier = Modifier.padding(top = 16.dp),
                value = tag,
                label = "Tag",
                trailingIcon = {
                    IconButton(onClick = {
                        if (tag.value.isNotEmpty()){
                            tags.add(tag.value)
                            tag.value = ""
                        }
                    }) {
                        Icon(imageVector = Icons.Rounded.Add, contentDescription = null)
                    }
                }
            )

            FlowRow(
                modifier = Modifier.padding(8.dp),
            ) {
                repeat(tags.size) { index ->
                    Chips(
                        modifier = Modifier.padding(top = 8.dp, end = 8.dp),
                        dismiss = false,
                        title = tags[index],
                        isSelected = true
                    ) {

                    }
                }
            }


            TextField(
                modifier = Modifier.padding(top = 24.dp),
                value = focused,
                label = "Description",
                singleLine = false,
                maxLine = 5,
                minLine = 5
            )


            Spacer(modifier = Modifier.padding(64.dp))

        }


        BottomBar()

    }

//    val date = remember {
//        Calendar.getInstance().apply {
//            set(Calendar.YEAR, 2023)
//            set(Calendar.MONTH, 7)
//            set(Calendar.DAY_OF_MONTH, 23)
//        }.timeInMillis
//    }

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = System.currentTimeMillis(),
        yearRange = 2015..2030
    )


    val context = LocalContext.current

    // date picker component
    DatePicker(showDatePicker){
        dateSelected.value = formatDate(it)
    }


    TimePicker(showTimePicker = showTimePicker){
        timeSelected.value = it
    }


}


@Composable
private fun BoxScope.BottomBar() {

    Column(
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .background(MaterialTheme.colorScheme.background)
    ) {
        HorizontalDivider(color = MaterialTheme.colorScheme.surfaceVariant)
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 32.dp),
            text = "submit", size = ButtonSize.XL
        )
    }

}
