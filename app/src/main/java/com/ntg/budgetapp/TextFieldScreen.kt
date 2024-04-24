package com.ntg.budgetapp

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ntg.budgetapp.model.countryList
import com.ntg.budgetapp.nav.ScreenPath
import com.ntg.budgetapp.ui.theme.Primary
import com.ntg.budgetapp.ui.theme.Void300
import com.ntg.budgetapp.ui.theme.Void900
import com.ntg.designsystem.components.CustomOutlineTextField


@Composable
fun TextFieldScreen(id: Int?) {
    val selectedCountry = countryList.find { it.id == id }
    val context = LocalContext.current
    var default by remember { mutableStateOf("Test") }
    val defaultLabel by remember { mutableStateOf("Default") }

    var disabled by remember { mutableStateOf("Test") }
    val disabledLabel by remember { mutableStateOf("Disabled") }

    var focused by remember { mutableStateOf("") }
    val focusedLabel by remember { mutableStateOf("Focused") }

    var dropdown by remember { mutableStateOf(selectedCountry?.name ?: "") }
    val dropdownLabel by remember { mutableStateOf("Country") }

    var unit by remember { mutableStateOf("Select") }
    val unitLabel by remember { mutableStateOf("Unit") }

    var success by remember { mutableStateOf("Test") }
    val successLabel by remember { mutableStateOf("success") }

    var successLine by remember { mutableStateOf("Test") }
    val successLineLabel by remember { mutableStateOf("SuccessLine") }

    var successHelpText by remember { mutableStateOf("Test") }
    val successHelpTextLabel by remember { mutableStateOf("successHelpText") }

    var error by remember { mutableStateOf("Test") }
    val errorLabel by remember { mutableStateOf("error") }

    var errorLine by remember { mutableStateOf("Test") }
    val errorLineLabel by remember { mutableStateOf("errorLine") }

    var errorHelpText by remember { mutableStateOf("Test") }
    val errorHelpTextLabel by remember { mutableStateOf("errorHelpText") }

    var warning by remember { mutableStateOf("Test") }
    val warningLabel by remember { mutableStateOf("warning") }

    var warningLine by remember { mutableStateOf("Test") }
    val warningLineLabel by remember { mutableStateOf("warningLine") }

    var warningHelpText by remember { mutableStateOf("Test") }
    val warningHelpTextLabel by remember { mutableStateOf("warningHelpText") }


    Log.d("idddddd", "$id")

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

                Text(text = "Default", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                CustomOutlineTextField(
                    value = default,
                    onValueChange = {
                        default = it
                    },
                    label = defaultLabel,
                    enabled = false,
                    readOnly = true
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Disabled", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                CustomOutlineTextField(
                    value = disabled,
                    onValueChange = {
                        disabled = it
                    },
                    label = disabledLabel,
                    enabled = false
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Focused", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                CustomOutlineTextField(
                    value = focused,
                    onValueChange = {
                        focused = it
                    },
                    label = focusedLabel,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Dropdown", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                CustomOutlineTextField(
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
                    value = if (selectedCountry?.name?.isEmpty() == true) dropdown else selectedCountry?.name
                        ?: "",
                    onValueChange = {
                        dropdown = it
                    },
                    label = dropdownLabel,
                    enabled = false,
                    trailingIcon = {
                        if (dropdown.isNotEmpty()) {
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
                CustomOutlineTextField(
                    value = unit,
                    onValueChange = {
                        unit = it
                    },
                    label = unitLabel,
                    trailingIcon = { Text(text = "lbs", color = Void300) }
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Success", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                CustomOutlineTextField(
                    readOnly = true,
                    isOk = true,
                    value = success,
                    onValueChange = {
                        success = it
                    },
                    label = successLabel,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "SuccessLine", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                CustomOutlineTextField(
                    isOk = true,
                    enabled = false,
                    value = successLine,
                    onValueChange = {
                        successLine = it
                    },
                    label = successLineLabel,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "SuccessHelpText", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                CustomOutlineTextField(
                    isOk = true,
                    okText = "test",
                    enabled = false,
                    showSupportingText = true,
                    value = successHelpText,
                    onValueChange = {
                        successHelpText = it
                    },
                    label = successHelpTextLabel,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Error", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                CustomOutlineTextField(
                    readOnly = true,
                    isError = true,
                    value = error,
                    onValueChange = {
                        error = it
                    },
                    label = errorLabel,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "ErrorLine", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                CustomOutlineTextField(
                    isError = true,
                    enabled = false,
                    value = errorLine,
                    onValueChange = {
                        errorLine = it
                    },
                    label = errorLineLabel,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "ErrorHelpText", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                CustomOutlineTextField(
                    isError = true,
                    errorText = "test",
                    enabled = false,
                    showSupportingText = true,
                    value = errorHelpText,
                    onValueChange = {
                        errorHelpText = it
                    },
                    label = errorHelpTextLabel,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Warning", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                CustomOutlineTextField(
                    readOnly = true,
                    isWarning = true,
                    value = warning,
                    onValueChange = {
                        warning = it
                    },
                    label = warningLabel,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "WarningLine", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                CustomOutlineTextField(
                    isWarning = true,
                    enabled = false,
                    value = warningLine,
                    onValueChange = {
                        warningLine = it
                    },
                    label = warningLineLabel,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "WarningHelpText", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(1.dp))
                CustomOutlineTextField(
                    isWarning = true,
                    warningText = "test",
                    enabled = false,
                    showSupportingText = true,
                    value = warningHelpText,
                    onValueChange = {
                        warningHelpText = it
                    },
                    label = warningHelpTextLabel,
                )
            }
    }
}