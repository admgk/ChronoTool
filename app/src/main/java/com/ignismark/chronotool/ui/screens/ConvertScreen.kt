package com.ignismark.chronotool.ui.screens

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.ignismark.chronotool.ui.components.ButtonPanel
import com.ignismark.chronotool.ui.components.InputForm
import com.ignismark.chronotool.ui.components.ResultBoard

@Composable
fun ConvertScreen(
    modifier: Modifier = Modifier,
    viewModel: ConvertScreenViewModel
) {

    val activity = (LocalContext.current as? Activity)
    BackHandler {
        activity?.moveTaskToBack(true)
    }

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
                    viewModel.updateOutputDuration()
                },
                onChangeMinutes = {
                    viewModel.updateInputMinutes(it)
                    viewModel.updateOutputDuration()
                },
                onChangeSeconds = {
                    viewModel.updateInputSeconds(it)
                    viewModel.updateOutputDuration()
                }
            )

            HorizontalDivider()

            ButtonPanel(
                isClear = true,
                onClickClear = {
                    viewModel.clearScreen()
                }
            )

            HorizontalDivider()

            ResultBoard(
                hms = viewModel.getDurationHMS(),
                ms = viewModel.getDurationMS(),
                s = viewModel.getDurationS()
            )
        }
    }
}