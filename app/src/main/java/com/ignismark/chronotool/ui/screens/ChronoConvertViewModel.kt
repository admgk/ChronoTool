package com.ignismark.chronotool.ui.screens

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

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

    fun calculateDuration() {
        val hours = _uiState.value.inputHours.toLongOrNull() ?: 0
        val minutes = _uiState.value.inputMinutes.toLongOrNull() ?: 0
        val seconds = _uiState.value.inputSeconds.toLongOrNull() ?: 0
        val duration = hours.hours + minutes.minutes + seconds.seconds
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
}

data class ChronoConvertUiState(
    val inputHours: String = "",
    val inputMinutes: String = "",
    val inputSeconds: String = "",
    val outputDuration: Duration = Duration.ZERO
)