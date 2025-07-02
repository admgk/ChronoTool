package com.ignismark.chronotool.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ResultBoard(
    hms: List<String>,
    ms: List<String>,
    s: String,
) {
    Column {
        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = hms[0],
                onValueChange = { },
                label = {
                    Text(text = "H")
                },
                readOnly = true,
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = hms[1],
                onValueChange = { },
                label = {
                    Text(text = "M")
                },
                readOnly = true,
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = hms[2],
                onValueChange = { },
                label = {
                    Text(text = "S")
                },
                readOnly = true,
                modifier = Modifier.weight(1f)
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = ms[0],
                onValueChange = { },
                label = {
                    Text(text = "M")
                },
                readOnly = true,
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = ms[1],
                onValueChange = { },
                label = {
                    Text(text = "S")
                },
                readOnly = true,
                modifier = Modifier.weight(1f)
            )
        }
        Row {
            OutlinedTextField(
                value = s,
                onValueChange = { },
                label = {
                    Text(text = "S")
                },
                readOnly = true,
                modifier = Modifier.weight(1f)
            )
        }
    }
}