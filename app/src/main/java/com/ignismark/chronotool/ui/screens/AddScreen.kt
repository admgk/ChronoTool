package com.ignismark.chronotool.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(
    modifier: Modifier = Modifier,
    viewModel: AddScreenViewModel
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
                    viewModel.calculatePartialDuration()
                },
                label = {
                    Text(text = "Hours")
                }
            )
            OutlinedTextField(
                value = uiState.inputMinutes,
                onValueChange = {
                    viewModel.updateInputMinutes(it)
                    viewModel.calculatePartialDuration()
                },
                label = {
                    Text(text = "Minutes")
                }
            )
            OutlinedTextField(
                value = uiState.inputSeconds,
                onValueChange = {
                    viewModel.updateInputSeconds(it)
                    viewModel.calculatePartialDuration()
                },
                label = {
                    Text(text = "Seconds")
                }
            )
            OutlinedButton(
                onClick = {
                    viewModel.calculateTotalDuration()
                    viewModel.saveAndClearPartialDuration()
                    viewModel.updateInputHours("")
                    viewModel.updateInputMinutes("")
                    viewModel.updateInputSeconds("")
                }
            ) { Text(text = "Add") }

            HorizontalDivider()

            LazyHorizontalGrid(
                modifier = Modifier.fillMaxWidth().height(96.dp),
                rows = GridCells.Fixed(3),
                userScrollEnabled = true,
                horizontalArrangement = Arrangement.Start,
                verticalArrangement = Arrangement.Top,
            ) {
                items(uiState.valuesList.size) { index ->
                    Card {
                        Text(text = uiState.valuesList[index].toString())
                    }
                }
            }

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
                        value = uiState.totalDuration.inWholeMinutes.toString(),
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
                        value = uiState.totalDuration.inWholeSeconds.toString(),
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