package com.ignismark.chronotool.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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

            OutlinedTextField(
                value = uiState.inputHours,
                onValueChange = {
                    viewModel.updateInputHours(it)
                    viewModel.calculateTemporaryDuration()
                },
                label = {
                    Text(text = "Hours")
                }
            )
            OutlinedTextField(
                value = uiState.inputMinutes,
                onValueChange = {
                    viewModel.updateInputMinutes(it)
                    viewModel.calculateTemporaryDuration()
                },
                label = {
                    Text(text = "Minutes")
                }
            )
            OutlinedTextField(
                value = uiState.inputSeconds,
                onValueChange = {
                    viewModel.updateInputSeconds(it)
                    viewModel.calculateTemporaryDuration()
                },
                label = {
                    Text(text = "Seconds")
                }
            )

            Row {
                OutlinedButton(
                    onClick = {
                        viewModel.setMinuendDuration()
                        viewModel.clearTemporaryDuration()
                    }
                ) { Text(text = "Set") }

                OutlinedButton(
                    onClick = {
                        viewModel.setSubtrahendDuration()
                        viewModel.clearTemporaryDuration()
                        viewModel.calculateDifferenceDuration()
                        viewModel.updateMinuendDuration()
                        viewModel.saveAndClearSubtrahendDuration()
                    }
                ) { Text(text = "Subtract") }

                OutlinedButton(
                    onClick = {
                        viewModel.clearScreen()
                    }
                ) { Text(text = "Clear") }
            }

            HorizontalDivider()

            LazyHorizontalGrid(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp),
                rows = GridCells.Fixed(3),
                userScrollEnabled = true,
                horizontalArrangement = Arrangement.Start,
                verticalArrangement = Arrangement.Top,
            ) {
                items(uiState.valuesList.size) { index ->
                    Card(
                        modifier = Modifier
                            .aspectRatio(3f)
                            .padding(2.dp),
                        border = BorderStroke(1.dp, Color.Black)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = uiState
                                .valuesList[index]
                                .toComponents { hours, minutes, seconds, nanoseconds ->
                                "${hours}H ${minutes}M ${seconds}S" }
                            )
                        }
                    }
                }
            }

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