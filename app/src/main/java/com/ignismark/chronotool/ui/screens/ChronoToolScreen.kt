package com.ignismark.chronotool.ui.screens

import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.ignismark.chronotool.ui.components.ButtonPanel
import com.ignismark.chronotool.ui.components.HistoryHorizontalGrid
import com.ignismark.chronotool.ui.components.InputForm
import com.ignismark.chronotool.ui.components.NumericKeyboard
import com.ignismark.chronotool.ui.components.ResultBoard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChronoToolScreen(
    modifier: Modifier = Modifier,
    viewModel: ChronoToolScreenViewModel
) {

    val activity = LocalActivity.current
    BackHandler {
        activity?.moveTaskToBack(true)
    }

    val uiState = viewModel.uiState.collectAsState().value

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        ResultBoard(
            hms = viewModel.getDurationHMS(),
            ms = viewModel.getDurationMS(),
            s = viewModel.getDurationS()
        )

        HorizontalDivider()

        HistoryHorizontalGrid(uiState.valuesList)

        HorizontalDivider()

        InputForm(
            hours = uiState.inputHours,
            minutes = uiState.inputMinutes,
            seconds = uiState.inputSeconds,
            focusedField = uiState.inputFormFocus,
            onClick = {
                viewModel.updateInputFormFocus(it)
            }
        )

        HorizontalDivider()

        NumericKeyboard(
            onKeyClick = {
                viewModel.updateInputValue(it)
            }
        )

        HorizontalDivider()

        ButtonPanel(
            isAdd = true,
            isClear = true,
            isSubtract = true,
            onClickAdd = {
                viewModel.addDuration()
                viewModel.clearInputForm()
            },
            onClickClear = {
                viewModel.clearScreen()
            },
            onClickSubtract = {
                viewModel.subtractDuration()
                viewModel.clearInputForm()
            }
        )
    }
}