package com.ignismark.chronotool.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.ignismark.chronotool.ui.utils.calculateDuration
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.time.Duration

class ConvertScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ConvertScreenUiState())
    val uiState: StateFlow<ConvertScreenUiState> = _uiState.asStateFlow()

    fun updateInputHours(input: String) {
        _uiState.value = _uiState.value.copy(inputHours = input)
    }

    fun updateInputMinutes(input: String) {
        _uiState.value = _uiState.value.copy(inputMinutes = input)
    }

    fun updateInputSeconds(input: String) {
        _uiState.value = _uiState.value.copy(inputSeconds = input)
    }

    fun calculateOutputDuration() : Duration {
        return calculateDuration(
            inputHours = _uiState.value.inputHours,
            inputMinutes = _uiState.value.inputMinutes,
            inputSeconds = _uiState.value.inputSeconds
        )
    }

    fun updateOutputDuration() {
        val duration = calculateOutputDuration()
        _uiState.value = _uiState.value.copy(outputDuration = duration)
    }

    fun getDurationHMS(): List<String> {
        return _uiState.value.outputDuration.toComponents { hours, minutes, seconds, nanoseconds
            -> listOf(hours.toString(), minutes.toString(), seconds.toString()) }
    }

    fun getDurationMS(): List<String> {
        val minutes = _uiState.value.outputDuration.inWholeMinutes.toString()
        val seconds = _uiState.value.outputDuration.toComponents { hours, minutes, seconds, nanoseconds
            -> seconds }.toString()
        return listOf(minutes, seconds)
    }

    fun getDurationS(): String {
        return _uiState.value.outputDuration.inWholeSeconds.toString()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                ConvertScreenViewModel()
            }
        }
    }
}

data class ConvertScreenUiState(
    val inputHours: String = "",
    val inputMinutes: String = "",
    val inputSeconds: String = "",
    val outputDuration: Duration = Duration.ZERO
)