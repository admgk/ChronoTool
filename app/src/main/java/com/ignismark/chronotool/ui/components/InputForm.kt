package com.ignismark.chronotool.ui.components

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ignismark.chronotool.ui.screens.ChronoToolUiState
import com.ignismark.chronotool.ui.screens.ChronoToolViewModel

@Composable
fun InputForm(
    uiState: ChronoToolUiState,
    viewModel: ChronoToolViewModel
) {
    val inputHours = when (uiState.currentRoute) {
        ChronoToolRoutes.Convert -> uiState.convertInputHours
        ChronoToolRoutes.Add -> uiState.addInputHours
        ChronoToolRoutes.Subtract -> uiState.subtractInputHours
    }

    val inputMinutes = when (uiState.currentRoute) {
        ChronoToolRoutes.Convert -> uiState.convertInputMinutes
        ChronoToolRoutes.Add -> uiState.addInputMinutes
        ChronoToolRoutes.Subtract -> uiState.subtractInputMinutes
    }

    val inputSeconds = when (uiState.currentRoute) {
        ChronoToolRoutes.Convert -> uiState.convertInputSeconds
        ChronoToolRoutes.Add -> uiState.addInputSeconds
        ChronoToolRoutes.Subtract -> uiState.subtractInputSeconds
    }

    OutlinedTextField(
        value = inputHours,
        onValueChange = {
            viewModel.updateInputHours(it)
            viewModel.calculateDuration()
        },
        label = {
            Text(text = "Hours")
        }
    )
    OutlinedTextField(
        value = inputMinutes,
        onValueChange = {
            viewModel.updateInputMinutes(it)
            viewModel.calculateDuration()
        },
        label = {
            Text(text = "Minutes")
        }
    )
    OutlinedTextField(
        value = inputSeconds,
        onValueChange = {
            viewModel.updateInputSeconds(it)
            viewModel.calculateDuration()
        },
        label = {
            Text(text = "Seconds")
        }
    )
}