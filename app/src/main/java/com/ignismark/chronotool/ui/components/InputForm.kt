package com.ignismark.chronotool.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

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
            }
        )
        OutlinedTextField(
            value = minutes,
            onValueChange = onChangeMinutes,
            label = {
                Text(text = "Minutes")
            }
        )
        OutlinedTextField(
            value = seconds,
            onValueChange = onChangeSeconds,
            label = {
                Text(text = "Seconds")
            }
        )
    }
}
