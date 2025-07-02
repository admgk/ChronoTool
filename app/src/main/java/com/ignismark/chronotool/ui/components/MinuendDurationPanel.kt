package com.ignismark.chronotool.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MinuendDurationPanel(
    hours: String,
    minutes: String,
    seconds: String,
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = hours,
            onValueChange = { },
            label = {
                Text(text = "H")
            },
            readOnly = true,
            modifier = Modifier.weight(1f)
        )
        OutlinedTextField(
            value = minutes,
            onValueChange = { },
            label = {
                Text(text = "M")
            },
            readOnly = true,
            modifier = Modifier.weight(1f)
        )
        OutlinedTextField(
            value = seconds,
            onValueChange = { },
            label = {
                Text(text = "S")
            },
            readOnly = true,
            modifier = Modifier.weight(1f)
        )
    }
}