package com.ignismark.chronotool.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

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
    Row {
        if (isAdd) {
            OutlinedButton(
                onClick = onClickAdd
            ) { Text(text = "Add") }
        }

        if (isSet) {
            OutlinedButton(
                onClick = onClickSet
            ) { Text(text = "Set") }
        }

        if (isSubtract) {
            OutlinedButton(
                onClick = onClickSubtract
            ) { Text(text = "Subtract") }
        }

        if (isClear) {
            OutlinedButton(
                onClick = onClickClear
            ) { Text(text = "Clear") }
        }
    }
}