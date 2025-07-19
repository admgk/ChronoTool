package com.ignismark.chronotool.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.ignismark.chronotool.ui.components.ButtonPanel
import com.ignismark.chronotool.ui.components.HistoryHorizontalGrid
import com.ignismark.chronotool.ui.components.InputForm
import com.ignismark.chronotool.ui.components.MinuendDurationPanel
import com.ignismark.chronotool.ui.components.NumericKeyboard
import com.ignismark.chronotool.ui.components.ResultBoard
import com.ignismark.chronotool.ui.utils.ChronoToolRoutes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubtractScreen(
    modifier: Modifier = Modifier,
    viewModel: SubtractScreenViewModel,
    navController: NavHostController
) {

    BackHandler {
        navController.navigate(route = ChronoToolRoutes.Add.title)
    }

    val uiState = viewModel.uiState.collectAsState().value

    Surface(
        modifier = modifier
    ) {

        Column {
            MinuendDurationPanel(
                hours = viewModel.getMinuendHours(),
                minutes = viewModel.getMinuendMinutes(),
                seconds = viewModel.getMinuendSeconds()
            )

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

            ButtonPanel(
                isSet = true,
                isSubtract = true,
                isClear = true,
                onClickSet = {
                    viewModel.setMinuendDuration()
                    viewModel.clearResults()
                    viewModel.clearInputForm()
                },
                onClickSubtract = {
                    viewModel.subtractDuration()
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

            NumericKeyboard(
                onKeyClick = {
                    viewModel.updateInputValue(it)
                }
            )
        }
    }
}