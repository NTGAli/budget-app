package com.ntg.budgetapp

import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ntg.budgetapp.model.countryList
import com.ntg.budgetapp.ui.theme.ChunLiBlue100
import com.ntg.budgetapp.ui.theme.ChunLiBlue200
import com.ntg.budgetapp.ui.theme.ChunLiBlue300
import com.ntg.budgetapp.ui.theme.ChunLiBlue400
import com.ntg.budgetapp.ui.theme.ChunLiBlue500
import com.ntg.budgetapp.ui.theme.Primary
import com.ntg.budgetapp.ui.theme.Void300
import com.ntg.budgetapp.ui.theme.Void900
import com.ntg.designsystem.components.AmountReport
import com.ntg.designsystem.components.BottomNavigation
import com.ntg.designsystem.components.Button
import com.ntg.designsystem.components.ButtonSize
import com.ntg.designsystem.components.ButtonType
import com.ntg.designsystem.components.Card
import com.ntg.designsystem.components.Chips
import com.ntg.designsystem.components.CircleChart
import com.ntg.designsystem.components.TextField
import com.ntg.designsystem.components.DetailsTable
import com.ntg.designsystem.components.ImagePicker
import com.ntg.designsystem.components.MessageBox
import com.ntg.designsystem.components.SampleItem
import com.ntg.designsystem.components.Table
import com.ntg.designsystem.components.TextCheckBox
import com.ntg.designsystem.components.TextDivider
import com.ntg.designsystem.components.TextRadio
import com.ntg.designsystem.components.TransactionItem
import com.ntg.designsystem.components.UserData
import com.ntg.designsystem.components.UserDataTable
import com.ntg.designsystem.model.DonutChartData
import com.ntg.designsystem.model.DonutChartDataCollection
import com.ntg.designsystem.model.NavigationItem
import com.ntg.designsystem.model.TableData
import com.ntg.designsystem.model.TextDividerType
import com.ntg.designsystem.model.UserDataTableItem


@Composable
fun TextFieldScreen(id: Int?) {
    val selectedCountry = countryList.find { it.id == id }
    val context = LocalContext.current
    var default = remember { mutableStateOf("Test") }
    val defaultLabel by remember { mutableStateOf("Default") }

    var disabled = remember { mutableStateOf("Test") }
    val disabledLabel by remember { mutableStateOf("Disabled") }

    var focused = remember { mutableStateOf("") }
    val focusedLabel by remember { mutableStateOf("Focused") }

    var dropdown = remember { mutableStateOf(selectedCountry?.name ?: "") }
    val dropdownLabel by remember { mutableStateOf("Country") }

    var unit = remember { mutableStateOf("Select") }
    val unitLabel by remember { mutableStateOf("Unit") }

    var success = remember { mutableStateOf("Test") }
    val successLabel by remember { mutableStateOf("success") }

    var successLine = remember { mutableStateOf("Test") }
    val successLineLabel by remember { mutableStateOf("SuccessLine") }

    var successHelpText = remember { mutableStateOf("Test") }
    val successHelpTextLabel by remember { mutableStateOf("successHelpText") }

    var error = remember { mutableStateOf("Test") }
    val errorLabel by remember { mutableStateOf("error") }

    var errorLine = remember { mutableStateOf("Test") }
    val errorLineLabel by remember { mutableStateOf("errorLine") }

    var errorHelpText = remember { mutableStateOf("Test") }
    val errorHelpTextLabel by remember { mutableStateOf("errorHelpText") }

    var warning = remember { mutableStateOf("Test") }
    val warningLabel by remember { mutableStateOf("warning") }

    var warningLine = remember { mutableStateOf("Test") }
    val warningLineLabel by remember { mutableStateOf("warningLine") }

    var warningHelpText = remember { mutableStateOf("Test") }
    val warningHelpTextLabel by remember { mutableStateOf("warningHelpText") }


    Log.d("idddddd", "$id")

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

                Text(text = "Default", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                TextField(
                    value = default,
                    label = defaultLabel,
                    enabled = false,
                    readOnly = true
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Disabled", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                TextField(
                    value = disabled,
                    label = disabledLabel,
                    enabled = false
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Focused", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                TextField(
                    value = focused,
                    label = focusedLabel,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Dropdown", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                TextField(
                    isCountryShowing = true,
                    modifier = Modifier.clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
//                        navController.navigate(ScreenPath.countryScreen.route)
//                        Toast.makeText(
//                            context,
//                            "Hiiii333",
//                            Toast.LENGTH_SHORT
//                        ).show()
                    },
                    value = error,
                    label = dropdownLabel,
                    enabled = false,
                    trailingIcon = {
                        if (dropdown.value.isNotEmpty()) {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                painter = painterResource(id = R.drawable.ic_down_arrow),
                                contentDescription = "drop_down",
                                tint = Primary
                            )
                        } else {
                            Icon(
                                modifier = Modifier.size(14.dp),
                                painter = painterResource(id = R.drawable.ic_drop_down),
                                contentDescription = "drop_down",
                                tint = Void900
                            )
                        }
                    },
                    leadingIcon = {
                        if (selectedCountry?.flag != null) {
                            Image(
                                modifier = Modifier.size(24.dp),
                                painter = painterResource(id = selectedCountry.flag),
                                contentDescription = "Flag"
                            )
                        } else {
                            Image(
                                modifier = Modifier.size(24.dp),
                                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                contentDescription = "Flag"
                            )
                        }
                    },
                    placeholder = "Select"
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Unit", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                TextField(
                    value = unit,
                    label = unitLabel,
                    trailingIcon = { Text(text = "lbs", color = Void300) }
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Success", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                TextField(
                    readOnly = true,
                    isOk = true,
                    value = success,
                    label = successLabel,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "SuccessLine", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                TextField(
                    isOk = true,
                    enabled = false,
                    value = successLine,
                    label = successLineLabel,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "SuccessHelpText", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                TextField(
                    isOk = true,
                    okText = "test",
                    enabled = false,
                    showSupportingText = true,
                    value = successHelpText,
                    label = successHelpTextLabel,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Error", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                TextField(
                    readOnly = true,
                    isError = true,
                    value = error,
                    label = errorLabel,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "ErrorLine", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                TextField(
                    isError = true,
                    enabled = false,
                    value = errorLine,
                    label = errorLineLabel,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "ErrorHelpText", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                TextField(
                    isError = true,
                    errorText = "test",
                    enabled = false,
                    showSupportingText = true,
                    value = errorHelpText,
                    label = errorHelpTextLabel,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Warning", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                TextField(
                    readOnly = true,
                    isWarning = true,
                    value = warning,
                    label = warningLabel,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "WarningLine", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                TextField(
                    isWarning = true,
                    enabled = false,
                    value = warningLine,
                    label = warningLineLabel,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "WarningHelpText", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                TextField(
                    isWarning = true,
                    warningText = "test",
                    enabled = false,
                    showSupportingText = true,
                    value = warningHelpText,
                    label = warningHelpTextLabel,
                )








            val isChecked = remember {
                mutableStateOf(false)
            }

            Box {
                var click by remember {
                    mutableStateOf(false)
                }
                LazyColumn {
                    item {

                        TextFieldScreen(1)

                        Table(
                            modifier = Modifier.padding(
                                horizontal = 24.dp,
                                vertical = 24.dp
                            ),
                            items = listOf(
                                TableData(
                                    0,
                                    painterResource(id = R.drawable.diamond),
                                    "Salary",
                                    "30%",
                                    "20"
                                ),
                                TableData(
                                    0,
                                    painterResource(id = R.drawable.diamond),
                                    "Salary",
                                    "30%",
                                    "20"
                                ),
                                TableData(
                                    0,
                                    painterResource(id = R.drawable.diamond),
                                    "Salary",
                                    "30%",
                                    "20"
                                ),
                                TableData(
                                    0,
                                    painterResource(id = R.drawable.diamond),
                                    "Salary",
                                    "30%",
                                    "20"
                                )
                            ),
                            "Categories", "Count"
                        )

                        ImagePicker(
                            modifier = Modifier.padding(
                                horizontal = 24.dp,
                                vertical = 16.dp
                            )
                        )

                        UserDataTable(
                            modifier = Modifier.padding(horizontal = 24.dp),
                            items = listOf(
                                UserDataTableItem(0, "Full name", "test"),
                                UserDataTableItem(
                                    0, "Full name", "test", icon = painterResource(
                                        id = R.drawable.mobile
                                    )
                                ),
                                UserDataTableItem(0, "Full name", "test", isChecked = true)
                            )
                        ) {

                        }

                        UserData(email = "test@tt.com", name = "John", state = false)
                        UserData(email = "test@tt.com", name = "John", state = true)
                        UserData(
                            image = painterResource(id = R.drawable.sample_profile),
                            email = "test@tt.com",
                            name = "John",
                            state = true
                        )


                        SampleItem(
                            icon = painterResource(id = R.drawable.user_circle),
                            title = "Account Information"
                        ) {}

                        AmountReport(
                            modifier = Modifier.padding(
                                horizontal = 32.dp,
                                vertical = 24.dp
                            ),
                            outcome = 10000,
                            income = 500000
                        )

                        TextDivider(title = "Helle world")
                        TextDivider(
                            modifier = Modifier.padding(vertical = 16.dp),
                            title = "Helle world",
                            type = TextDividerType.CENTER
                        )


                        TextCheckBox(
                            title = "Test",
                            isChecked = isChecked
                        ) {
                            isChecked.value = !isChecked.value
                        }

                        TextRadio(
                            title = "Test Radio",
                            isChecked = isChecked
                        ) {
                            isChecked.value = !isChecked.value
                        }


                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                            text = "Test button",
                            loading = click,
                            size = ButtonSize.XL
                        ) {
                            click = !click
                        }

                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                            text = "Test button",
                            loading = click,
                            size = ButtonSize.LG
                        ) {
                            click = !click
                        }


                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                            text = "Test button",
                            loading = click,
                            size = ButtonSize.MD
                        ) {
                            click = !click
                        }


                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                            text = "Test button",
                            loading = click,
                            size = ButtonSize.XS
                        ) {
                            click = !click
                        }


                        MessageBox(
                            modifier = Modifier.padding(top = 16.dp),
                            text = "Image Backup Available Only with Paid Subscription Plans",
                            type = ButtonType.Primary
                        )

                        MessageBox(
                            modifier = Modifier.padding(top = 16.dp),
                            text = "Image Backup Available Only with Paid Subscription Plans",
                            type = ButtonType.Secondary
                        )

                        MessageBox(
                            modifier = Modifier.padding(top = 16.dp),
                            text = "Image Backup Available Only with Paid Subscription Plans",
                            type = ButtonType.Success
                        )

                        MessageBox(
                            modifier = Modifier.padding(top = 16.dp),
                            text = "Image Backup Available Only with Paid Subscription Plans",
                            type = ButtonType.Error
                        )

                        MessageBox(
                            modifier = Modifier.padding(top = 16.dp),
                            text = "Image Backup Available Only with Paid Subscription Plans",
                            type = ButtonType.Primary,
                            textButton = "button"
                        )

                        MessageBox(
                            modifier = Modifier.padding(top = 16.dp),
                            text = "Image Backup Available Only with Paid Subscription Plans",
                            type = ButtonType.Primary,
                            icon = painterResource(
                                id = R.drawable.diamond
                            )
                        )

                        Card(
                            modifier = Modifier.padding(top = 24.dp),
                            card = ImageVector.vectorResource(R.drawable.card),
                            cardNumber = "4111111111111111",
                            name = "Ali Nateghi",
                            fullView = click
                        )


                        val viewData = DonutChartDataCollection(
                            listOf(
                                DonutChartData(
                                    1200.0f,
                                    ChunLiBlue500,
                                    title = "Food & Groceries"
                                ),
                                DonutChartData(
                                    1500.0f,
                                    ChunLiBlue400,
                                    title = "Rent"
                                ),
                                DonutChartData(
                                    300.0f,
                                    ChunLiBlue300,
                                    title = "Gas"
                                ),
                                DonutChartData(
                                    700.0f,
                                    ChunLiBlue200,
                                    title = "Online Purchases"
                                ),
                                DonutChartData(
                                    300.0f,
                                    ChunLiBlue100,
                                    title = "Clothing"
                                )
                            )
                        )


                        CircleChart(
                            modifier = Modifier.padding(
                                top = 24.dp
                            ), data = viewData
                        ) { selected ->
                            // 3
                            AnimatedContent(targetState = selected, label = "") {
                                val amount = it?.amount ?: viewData.totalAmount
                                val text = it?.title ?: "Total"

                                // 4
                                Column(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        "$${amount}",
                                    )
                                    Text(text)
                                }
                            }
                        }


                        Chips(
                            modifier = Modifier.padding(top = 24.dp),
                            title = "From: April 8,2024",
                            dismiss = true
                        ) {

                        }

                        Chips(
                            modifier = Modifier.padding(top = 24.dp),
                            title = "From: April 8,2024",
                            dismiss = false
                        ) {

                        }

                        Chips(
                            modifier = Modifier.padding(top = 24.dp),
                            icon = painterResource(id = R.drawable.plus),
                            dismiss = true
                        ) {

                        }


                        repeat(3) {

                            TransactionItem(
                                modifier = Modifier
                                    .padding(horizontal = 16.dp)
                                    .padding(top = 4.dp),
                                title = "Food & Drink",
                                time = 1713108246,
                                amount = 2300,
                                categoryIcon = painterResource(id = R.drawable.diamond),
                                onLongCLick = {},
                                onCLick = {}
                            )

                        }

                        DetailsTable(
                            modifier = Modifier.padding(horizontal = 32.dp),
                            items = listOf(
                                Pair("aaa", "aaa"),
                                Pair("aaa", "aaa"),
                                Pair("aaa", "aaa"),
                                Pair("aaa", "aaa")
                            )
                        )


                        Spacer(modifier = Modifier.padding(290.dp))
                    }
                }

                val navs = listOf<NavigationItem>(
                    NavigationItem(
                        1,
                        "test",
                        painterResource(id = R.drawable.home),
                        painterResource(id = R.drawable.home),
                        isSelected = true
                    ),
                    NavigationItem(
                        2,
                        "test",
                        painterResource(id = R.drawable.user_circle),
                        painterResource(id = R.drawable.user_circle),
                        isSelected = false
                    )
                )

                BottomNavigation(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    items = navs,
                    onCLick = {}
                )
            }
            }
    }
}