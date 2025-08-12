package com.ignismark.chronotool.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonPanel(
    isAdd: Boolean = false,
    isSet: Boolean = false,
    isSubtract: Boolean = false,
    isClear: Boolean = false,
    onClickAdd: () -> Unit = {},
    onClickSet: () -> Unit = {},
    onClickSubtract: () -> Unit = {},
    onClickClear: () -> Unit = {}
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 4.dp, bottom = 4.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isAdd) {
            OutlinedButton(
                onClick = onClickAdd,
                modifier = Modifier.padding(end = 8.dp)
            ) { Text(text = "Add") }
        }

        if (isSet) {
            OutlinedButton(
                onClick = onClickSet,
                modifier = Modifier.padding(end = 8.dp)
            ) { Text(text = "Set") }
        }

        if (isSubtract) {
            OutlinedButton(
                onClick = onClickSubtract,
                modifier = Modifier.padding(end = 8.dp)
            ) { Text(text = "Subtract") }
        }

        if (isClear) {
            OutlinedButton(
                onClick = onClickClear
            ) { Text(text = "Clear") }
        }
    }
}