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

class ChronoConvertViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ChronoConvertUiState())
    val uiState: StateFlow<ChronoConvertUiState> = _uiState.asStateFlow()

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

    fun getHours(): String {
        return _uiState.value.outputDuration.toComponents { hours, minutes, seconds, nanoseconds
            -> hours }.toString()
    }

    fun getMinutes(): String {
        return _uiState.value.outputDuration.toComponents { hours, minutes, seconds, nanoseconds
            -> minutes }.toString()
    }

    fun getSeconds(): String {
        return _uiState.value.outputDuration.toComponents { hours, minutes, seconds, nanoseconds
            -> seconds }.toString()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                ChronoConvertViewModel()
            }
        }
    }
}

data class ChronoConvertUiState(
    val inputHours: String = "",
    val inputMinutes: String = "",
    val inputSeconds: String = "",
    val outputDuration: Duration = Duration.ZERO
)