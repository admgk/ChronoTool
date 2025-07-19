package com.ignismark.chronotool.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
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
            readOnly = true,
            label = {
                Text(text = "Hours")
            },
            singleLine = true
        )
        OutlinedTextField(
            value = minutes,
            onValueChange = {},
            modifier = Modifier.clickable { onClick(InputFormField.MINUTES) },
            enabled = false,
            readOnly = true,
            label = {
                Text(text = "Minutes")
            },
            singleLine = true,
        )
        OutlinedTextField(
            value = seconds,
            onValueChange = {},
            modifier = Modifier.clickable { onClick(InputFormField.SECONDS) },
            enabled = false,
            readOnly = true,
            label = {
                Text(text = "Seconds")
            },
            singleLine = true,
        )
    }
}

enum class InputFormField {
    NONE,
    HOURS,
    MINUTES,
    SECONDS
}
