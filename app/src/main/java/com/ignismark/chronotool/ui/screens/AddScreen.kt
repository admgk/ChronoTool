package com.ignismark.chronotool.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.ignismark.chronotool.ui.components.ButtonPanel
import com.ignismark.chronotool.ui.components.HistoryHorizontalGrid
import com.ignismark.chronotool.ui.components.InputForm
import com.ignismark.chronotool.ui.components.ResultBoard

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

            HorizontalDivider()

            ButtonPanel(
                isAdd = true,
                isClear = true,
                onClickAdd = {
                    viewModel.addDuration()
                    viewModel.clearInputForm()
                },
                onClickClear = {
                    viewModel.clearScreen()
                }
            )

            HorizontalDivider()

            HistoryHorizontalGrid(uiState.valuesList)

            HorizontalDivider()

            ResultBoard(
                hms = viewModel.getDurationHMS(),
                ms = viewModel.getDurationMS(),
                s = viewModel.getDurationS()
            )
        }
    }
}