package com.ignismark.chronotool.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.ignismark.chronotool.ui.components.HistoryHorizontalGrid
import com.ignismark.chronotool.ui.components.InputForm

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubtractScreen(
    modifier: Modifier = Modifier,
    viewModel: SubtractScreenViewModel
) {

    val uiState = viewModel.uiState.collectAsState().value

    Surface(
        modifier = modifier
    ) {

        Column {
            Row(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = viewModel.getMinuendHours(),
                    onValueChange = { },
                    label = {
                        Text(text = "H")
                    },
                    readOnly = true,
                    modifier = Modifier.weight(1f)
                )
                OutlinedTextField(
                    value = viewModel.getMinuendMinutes(),
                    onValueChange = { },
                    label = {
                        Text(text = "M")
                    },
                    readOnly = true,
                    modifier = Modifier.weight(1f)
                )
                OutlinedTextField(
                    value = viewModel.getMinuendSeconds(),
                    onValueChange = { },
                    label = {
                        Text(text = "S")
                    },
                    readOnly = true,
                    modifier = Modifier.weight(1f)
                )
            }

            HorizontalDivider()

            InputForm(
                hours = uiState.inputHours,
                minutes = uiState.inputMinutes,
                seconds = uiState.inputSeconds,
                onChangeHours = {
                    viewModel.updateInputHours(it)
                },
                onChangeMinutes = {
                    viewModel.updateInputMinutes(it)
                },
                onChangeSeconds = {
                    viewModel.updateInputSeconds(it)
                }
            )

            Row {
                OutlinedButton(
                    onClick = {
                        viewModel.setMinuendDuration()
                        viewModel.clearInputForm()
                    }
                ) { Text(text = "Set") }

                OutlinedButton(
                    onClick = {
                        viewModel.subtractDuration()
                        viewModel.clearInputForm()
                    }
                ) { Text(text = "Subtract") }

                OutlinedButton(
                    onClick = {
                        viewModel.clearScreen()
                    }
                ) { Text(text = "Clear") }
            }

            HorizontalDivider()

            HistoryHorizontalGrid(uiState.valuesList)

            HorizontalDivider()

            Column {
                Row(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = viewModel.getDifferenceHours(),
                        onValueChange = { },
                        label = {
                            Text(text = "H")
                        },
                        readOnly = true,
                        modifier = Modifier.weight(1f)
                    )
                    OutlinedTextField(
                        value = viewModel.getDifferenceMinutes(),
                        onValueChange = { },
                        label = {
                            Text(text = "M")
                        },
                        readOnly = true,
                        modifier = Modifier.weight(1f)
                    )
                    OutlinedTextField(
                        value = viewModel.getDifferenceSeconds(),
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
                        value = uiState.differenceDuration.inWholeMinutes.toString(),
                        onValueChange = { },
                        label = {
                            Text(text = "M")
                        },
                        readOnly = true,
                        modifier = Modifier.weight(1f)
                    )
                    OutlinedTextField(
                        value = viewModel.getDifferenceSeconds(),
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
                        value = uiState.differenceDuration.inWholeSeconds.toString(),
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