package com.ignismark.chronotool.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NumericKeyboard(onKeyClick: (String) -> Unit) {
    val keys = listOf(
        listOf("1", "2", "3"),
        listOf("4", "5", "6"),
        listOf("7", "8", "9"),
        listOf("C", "0", "<")
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        keys.forEach { rowKeys ->
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                rowKeys.forEach { key ->
                    Button(
                        onClick = { onKeyClick(key) },
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                    ) {
                        Text(
                            text = key,
                            fontSize = 24.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun NumericKeyboardPreview() {
    NumericKeyboard(onKeyClick = {})
}