package com.ignismark.chronotool.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun ChronoConvert(
    modifier: Modifier = Modifier,
    viewModel: ChronoConvertViewModel
) {
    ConvertScreen(
        modifier = modifier,
        viewModel = viewModel
    )
}

@Composable
fun ConvertScreen(
    modifier: Modifier = Modifier,
    viewModel: ChronoConvertViewModel
) {

    val uiState = viewModel.uiState.collectAsState().value

    Surface(
        modifier = modifier
    ) {
        Column {
            OutlinedTextField(
                value = uiState.inputHours,
                onValueChange = {
                    viewModel.updateInputHours(it)
                    viewModel.calculateDuration()
                },
                label = {
                    Text(text = "Hours")
                }
            )
            OutlinedTextField(
                value = uiState.inputMinutes,
                onValueChange = {
                    viewModel.updateInputMinutes(it)
                    viewModel.calculateDuration()
                },
                label = {
                    Text(text = "Minutes")
                }
            )
            OutlinedTextField(
                value = uiState.inputSeconds,
                onValueChange = {
                    viewModel.updateInputSeconds(it)
                    viewModel.calculateDuration()
                },
                label = {
                    Text(text = "Seconds")
                }
            )
            HorizontalDivider()
            Column {
                Row(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = viewModel.getHours(),
                        onValueChange = { },
                        label = {
                            Text(text = "H")
                        },
                        readOnly = true,
                        modifier = Modifier.weight(1f)
                    )
                    OutlinedTextField(
                        value = viewModel.getMinutes(),
                        onValueChange = { },
                        label = {
                            Text(text = "M")
                        },
                        readOnly = true,
                        modifier = Modifier.weight(1f)
                    )
                    OutlinedTextField(
                        value = viewModel.getSeconds(),
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
                        value = uiState.outputDuration.inWholeMinutes.toString(),
                        onValueChange = { },
                        label = {
                            Text(text = "M")
                        },
                        readOnly = true,
                        modifier = Modifier.weight(1f)
                    )
                    OutlinedTextField(
                        value = viewModel.getSeconds(),
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
                        value = uiState.outputDuration.inWholeSeconds.toString(),
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
    }
}