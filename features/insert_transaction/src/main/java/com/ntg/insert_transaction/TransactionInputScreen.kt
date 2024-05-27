package com.ntg.insert_transaction

import android.util.Log
import android.view.SurfaceControl.Transaction
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.ntg.designsystem.components.Button
import com.ntg.designsystem.components.ButtonSize
import com.ntg.designsystem.components.ButtonStyle
import com.ntg.designsystem.components.ButtonType
import com.ntg.designsystem.components.Chips
import com.ntg.designsystem.components.ImagePicker
import com.ntg.designsystem.components.SwitchText
import com.ntg.designsystem.components.TextDivider
import com.ntg.designsystem.components.TextField
import java.util.Calendar

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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Content(
    paddingValues: PaddingValues
) {

    var focused by remember { mutableStateOf("") }
    val focusedLabel by remember { mutableStateOf("Focused") }

    var showDatePicker by remember {
        mutableStateOf(true)
    }

    Box(modifier = Modifier.fillMaxHeight()) {
        Column(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .verticalScroll(rememberScrollState())
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
                onValueChange = {
                    focused = it
                },
                label = "Date & Time",
            )


            TextField(
                modifier = Modifier.padding(top = 16.dp),
                value = focused,
                onValueChange = {
                    focused = it
                },
                label = "Amount",
                trailingIcon = { Text(text = "lbs", color = MaterialTheme.colorScheme.outline) }
            )

            ImagePicker(
                modifier = Modifier.padding(top = 24.dp)
            )

            TextField(
                modifier = Modifier.padding(top = 16.dp),
                value = focused,
                onValueChange = {
                    focused = it
                },
                label = "Category",
            )

            TextDivider(
                modifier = Modifier.padding(top = 16.dp),
                title = "Tags"
            )

            Chips(
                modifier = Modifier.padding(top = 16.dp),
                dismiss = false,
                iconVector = Icons.Default.Add
            ) {

            }

            TextField(
                modifier = Modifier.padding(top = 24.dp),
                value = focused,
                onValueChange = {
                    focused = it
                },
                label = "Description",
                singleLine = false,
                maxLine = 5,
                minLine = 5
            )

        }


        BottomBar()

    }

    val date = remember {
        Calendar.getInstance().apply {
            set(Calendar.YEAR, 2023)
            set(Calendar.MONTH, 7)
            set(Calendar.DAY_OF_MONTH, 23)
        }.timeInMillis
    }

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = System.currentTimeMillis(),
        yearRange = 2015..2030
    )

    val context = LocalContext.current

    // date picker component
    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { /*TODO*/ },
            confirmButton = {
                Button(text = "Select", style = ButtonStyle.TextOnly, size = ButtonSize.MD) {
                    val selectedDate = Calendar.getInstance().apply {
                        timeInMillis = datePickerState.selectedDateMillis!!
                    }

                    Toast.makeText(
                        context,
                        "Selected date ${selectedDate.time} saved",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
            dismissButton = {
                Button(
                    text = "Close",
                    style = ButtonStyle.TextOnly,
                    type = ButtonType.Error,
                    size = ButtonSize.MD
                ){
                    showDatePicker = false
                }
            },
        )
        {
            DatePicker(state = datePickerState)
        }
    }

}


@Composable
private fun BoxScope.BottomBar() {

    Column(
        modifier = Modifier.align(Alignment.BottomCenter)
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
