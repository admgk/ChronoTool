package com.ignismark.chronotool.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MinuendDurationPanel(
    hours: String,
    minutes: String,
    seconds: String,
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = hours,
            onValueChange = { },
            label = {
                Text(text = "H")
            },
            readOnly = true,
            modifier = Modifier.weight(1f).padding(end = 8.dp)
        )
        OutlinedTextField(
            value = minutes,
            onValueChange = { },
            label = {
                Text(text = "M")
            },
            readOnly = true,
            modifier = Modifier.weight(1f).padding(end = 8.dp)
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