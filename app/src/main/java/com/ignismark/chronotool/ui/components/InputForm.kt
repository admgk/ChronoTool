package com.ignismark.chronotool.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun InputForm(
    hours: String,
    minutes: String,
    seconds: String,
    onChangeHours: (String) -> Unit,
    onChangeMinutes: (String) -> Unit,
    onChangeSeconds: (String) -> Unit,
) {

    Column {
        OutlinedTextField(
            value = hours,
            onValueChange = onChangeHours,
            label = {
                Text(text = "Hours")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = minutes,
            onValueChange = onChangeMinutes,
            label = {
                Text(text = "Minutes")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = seconds,
            onValueChange = onChangeSeconds,
            label = {
                Text(text = "Seconds")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}
