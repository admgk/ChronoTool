package com.ignismark.chronotool.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InputForm(
    hours: String,
    minutes: String,
    seconds: String,
    focusedField: InputFormField,
    onClick: (InputFormField) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = hours,
            onValueChange = {},
            modifier = Modifier.clickable { onClick(InputFormField.HOURS) },
            enabled = false,
            label = {
                Text(text = "Hours")
            },
            singleLine = true,
            colors = when (focusedField) {
                InputFormField.HOURS -> OutlinedTextFieldDefaults.colors().copy(
                    disabledTextColor = MaterialTheme.colorScheme.primary,
                    disabledIndicatorColor = MaterialTheme.colorScheme.primary,
                    disabledPlaceholderColor = MaterialTheme.colorScheme.primary,
                    disabledLabelColor = MaterialTheme.colorScheme.primary
                )
                else -> OutlinedTextFieldDefaults.colors().copy(
                    disabledTextColor = MaterialTheme.colorScheme.onSurface,
                    disabledIndicatorColor = MaterialTheme.colorScheme.outline,
                    disabledPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    disabledLabelColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        )
        OutlinedTextField(
            value = minutes,
            onValueChange = {},
            modifier = Modifier.clickable { onClick(InputFormField.MINUTES) },
            enabled = false,
            label = {
                Text(text = "Minutes")
            },
            singleLine = true,
            colors = when (focusedField) {
                InputFormField.MINUTES -> OutlinedTextFieldDefaults.colors().copy(
                    disabledTextColor = MaterialTheme.colorScheme.primary,
                    disabledIndicatorColor = MaterialTheme.colorScheme.primary,
                    disabledPlaceholderColor = MaterialTheme.colorScheme.primary,
                    disabledLabelColor = MaterialTheme.colorScheme.primary
                )
                else -> OutlinedTextFieldDefaults.colors().copy(
                    disabledTextColor = MaterialTheme.colorScheme.onSurface,
                    disabledIndicatorColor = MaterialTheme.colorScheme.outline,
                    disabledPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    disabledLabelColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        )
        OutlinedTextField(
            value = seconds,
            onValueChange = {},
            modifier = Modifier.clickable { onClick(InputFormField.SECONDS) },
            enabled = false,
            label = {
                Text(text = "Seconds")
            },
            singleLine = true,
            colors = when (focusedField) {
                InputFormField.SECONDS -> OutlinedTextFieldDefaults.colors().copy(
                    disabledTextColor = MaterialTheme.colorScheme.primary,
                    disabledIndicatorColor = MaterialTheme.colorScheme.primary,
                    disabledPlaceholderColor = MaterialTheme.colorScheme.primary,
                    disabledLabelColor = MaterialTheme.colorScheme.primary
                )
                else -> OutlinedTextFieldDefaults.colors().copy(
                    disabledTextColor = MaterialTheme.colorScheme.onSurface,
                    disabledIndicatorColor = MaterialTheme.colorScheme.outline,
                    disabledPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    disabledLabelColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        )
    }
}

enum class InputFormField {
    NONE,
    HOURS,
    MINUTES,
    SECONDS
}
