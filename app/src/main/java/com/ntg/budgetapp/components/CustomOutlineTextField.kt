package com.ntg.budgetapp.components

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.ntg.budgetapp.R
import com.ntg.budgetapp.ui.theme.ChunLiBlue500
import com.ntg.budgetapp.ui.theme.ChunLiBlue600
import com.ntg.budgetapp.ui.theme.ChunLiBlue700
import com.ntg.budgetapp.ui.theme.CoralRed600
import com.ntg.budgetapp.ui.theme.GreenishTeal600
import com.ntg.budgetapp.ui.theme.Primary
import com.ntg.budgetapp.ui.theme.Typography
import com.ntg.budgetapp.ui.theme.Void100
import com.ntg.budgetapp.ui.theme.Void200
import com.ntg.budgetapp.ui.theme.Void300
import com.ntg.budgetapp.ui.theme.Void400
import com.ntg.budgetapp.ui.theme.Void500
import com.ntg.budgetapp.ui.theme.Void600
import com.ntg.budgetapp.ui.theme.Void900

@Composable
fun CustomOutlineTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: String? = null,
    placeholder: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    errorWithoutBorder: Boolean = false,
    errorText: String? = null,
    isOk: Boolean = false,
    okWithoutBorder: Boolean = false,
    okText: String? = null,
    isWarning: Boolean = false,
    warningWithoutBorder: Boolean = false,
    warningText: String? = null,
    showSupportingText: Boolean = false,
    isCountryShowing: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {

    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier,
            enabled = enabled,
            readOnly = readOnly,
            textStyle = Typography.labelLarge,
            label = {
                Text(
                    text = label.orEmpty(),
                    style = Typography.labelSmall.copy(
                        fontWeight = FontWeight.SemiBold,
                    )
                )
            },
            placeholder = {
                Text(
                    text = placeholder.orEmpty(),
                    style = Typography.labelSmall
                )
            },
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon ?: {
                when {
                    isError || errorWithoutBorder -> {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_remove_circle),
                            contentDescription = "remove_circle",
                            tint = CoralRed600
                        )
                    }

                    isOk || okWithoutBorder -> {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_check_circle),
                            contentDescription = "check_circle",
                            tint = GreenishTeal600
                        )
                    }

                    isWarning || warningWithoutBorder -> {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_warning_error),
                            contentDescription = "warning_circle",
                            tint = Color.Yellow
                        )
                    }
                }
            },
            prefix = prefix,
            suffix = suffix,
            supportingText = if (showSupportingText) {
                {
                    when {
                        isError && errorText.isNullOrEmpty() -> {
                            throw IllegalArgumentException("errorText is required when isError is true")
                        }

                        isOk && okText.isNullOrEmpty() -> {
                            throw IllegalArgumentException("okText is required when isOk is true")
                        }

                        isWarning && warningText.isNullOrEmpty() -> {
                            throw IllegalArgumentException("warningText is required when isWarning is true")
                        }

                        isError && !errorText.isNullOrEmpty() -> {
                            Text(
                                text = errorText,
                                color = CoralRed600,
                                style = Typography.labelSmall.copy(
                                    fontWeight = FontWeight.SemiBold,
                                )
                            )
                        }

                        isOk && !okText.isNullOrEmpty() -> {
                            Text(
                                text = okText,
                                color = GreenishTeal600,
                                style = Typography.labelSmall.copy(
                                    fontWeight = FontWeight.SemiBold,
                                )
                            )
                        }

                        isWarning && !warningText.isNullOrEmpty() -> {
                            Text(
                                text = warningText,
                                color = Color.Yellow,
                                style = Typography.labelSmall.copy(
                                    fontWeight = FontWeight.SemiBold,
                                )
                            )
                        }
                    }
                }
            } else null,
            isError = isError,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = true,
            maxLines = 1,
            minLines = 1,
            interactionSource = interactionSource,
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = if (readOnly) Void500 else ChunLiBlue500,
                unfocusedBorderColor = Void500,
                disabledBorderColor = when {
                    isOk -> {
                        GreenishTeal600
                    }

                    isWarning -> {
                        Color.Yellow
                    }

                    isError -> {
                        CoralRed600
                    }

                    readOnly -> {
                        Void500
                    }

                    else -> {
                        Void200
                    }
                },
                errorBorderColor = if (readOnly) Void500 else CoralRed600,
                focusedLabelColor = Void500,
                unfocusedLabelColor = Void400,
                disabledLabelColor = Void500,
                errorLabelColor = Void500,
                focusedPlaceholderColor = Void300,
                unfocusedPlaceholderColor = Void300,
                disabledPlaceholderColor = Void300,
                errorPlaceholderColor = Void300,
                focusedTrailingIconColor = Void500,
                unfocusedTrailingIconColor = Void500,
                disabledTrailingIconColor = Void500,
                errorTrailingIconColor = Void500,
                cursorColor = ChunLiBlue500,
                focusedTextColor = Void900,
                unfocusedTextColor = Void900,
                disabledTextColor = when {
                    isCountryShowing -> {
                        Void900
                    }

                    readOnly -> {
                        Void500
                    }

                    else -> {
                        Void200
                    }
                },
                errorTextColor = Void900,
            )
        )
    }
}

/*
focusedTextColor = Color.Black,
unfocusedTextColor =Color.Black,
disabledTextColor =Color.Black,
errorTextColor =Color.Black,
focusedContainerColor =Color.Black,
unfocusedContainerColor =Color.Black,
disabledContainerColor =Color.Black,
errorContainerColor =Color.Black,
cursorColor =Color.Black,
errorCursorColor =Color.Black,
selectionColors =Color.Black,
focusedBorderColor =Color.Black,
unfocusedBorderColor =Color.Black,
disabledBorderColor =Color.Black,
errorBorderColor =Color.Black,
focusedLeadingIconColor =Color.Black,
unfocusedLeadingIconColor =Color.Black,
disabledLeadingIconColor =Color.Black,
errorLeadingIconColor =Color.Black,
focusedTrailingIconColor =Color.Black,
unfocusedTrailingIconColor =Color.Black,
disabledTrailingIconColor =Color.Black,
errorTrailingIconColor =Color.Black,
focusedLabelColor =Color.Black,
unfocusedLabelColor =Color.Black,
disabledLabelColor =Color.Black,
errorLabelColor =Color.Black,
focusedPlaceholderColor =Color.Black,
unfocusedPlaceholderColor =Color.Black,
disabledPlaceholderColor =Color.Black,
errorPlaceholderColor =Color.Black,
focusedSupportingTextColor =Color.Black,
unfocusedSupportingTextColor =Color.Black,
disabledSupportingTextColor =Color.Black,
errorSupportingTextColor =Color.Black,
focusedPrefixColor =Color.Black,
unfocusedPrefixColor =Color.Black,
disabledPrefixColor =Color.Black,
errorPrefixColor =Color.Black,
focusedSuffixColor =Color.Black,
unfocusedSuffixColor =Color.Black,
disabledSuffixColor =Color.Black,
errorSuffixColor =Color.Black,*/
