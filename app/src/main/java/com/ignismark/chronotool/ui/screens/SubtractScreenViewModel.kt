package com.ignismark.chronotool.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

class SubtractScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SubtractScreenUiState())
    val uiState: StateFlow<SubtractScreenUiState> = _uiState.asStateFlow()

    fun updateInputHours(input: String) {
        _uiState.value = _uiState.value.copy(inputHours = input)
    }

    fun updateInputMinutes(input: String) {
        _uiState.value = _uiState.value.copy(inputMinutes = input)
    }

    fun updateInputSeconds(input: String) {
        _uiState.value = _uiState.value.copy(inputSeconds = input)
    }

    fun saveAndClearSubtrahendDuration() {
        val duration = _uiState.value.subtrahendDuration
        if (duration != Duration.ZERO) {
            _uiState.value = _uiState.value.copy(valuesList = _uiState.value.valuesList + duration)
            _uiState.value = _uiState.value.copy(subtrahendDuration = Duration.ZERO)
        }
    }

    fun calculateTemporaryDuration() {
        val hours = _uiState.value.inputHours.toLongOrNull() ?: 0
        val minutes = _uiState.value.inputMinutes.toLongOrNull() ?: 0
        val seconds = _uiState.value.inputSeconds.toLongOrNull() ?: 0
        val duration = hours.hours + minutes.minutes + seconds.seconds
        _uiState.value = _uiState.value.copy(temporaryDuration = duration)
    }

    fun clearTemporaryDuration() {
        _uiState.value = _uiState.value.copy(
            inputHours = "",
            inputMinutes = "",
            inputSeconds = "",
            temporaryDuration = Duration.ZERO)
    }

    fun clearScreen() {
        _uiState.value = _uiState.value.copy(
            inputHours = "",
            inputMinutes = "",
            inputSeconds = "",
            valuesList = emptyList(),
            temporaryDuration = Duration.ZERO,
            minuendDuration = Duration.ZERO,
            subtrahendDuration = Duration.ZERO,
            differenceDuration = Duration.ZERO
        )
    }

    fun setMinuendDuration() {
        val duration = _uiState.value.temporaryDuration
        _uiState.value = _uiState.value.copy(minuendDuration = duration)
    }

    fun setSubtrahendDuration() {
        val duration = _uiState.value.temporaryDuration
        _uiState.value = _uiState.value.copy(subtrahendDuration = duration)
    }

    fun calculateDifferenceDuration() {
        val duration = _uiState.value.minuendDuration - _uiState.value.subtrahendDuration
        _uiState.value = _uiState.value.copy(differenceDuration = duration)
    }

    fun updateMinuendDuration() {
        val duration = _uiState.value.differenceDuration
        _uiState.value = _uiState.value.copy(minuendDuration = duration)
    }

    fun getDifferenceHours(): String {
        return _uiState.value.differenceDuration.toComponents { hours, minutes, seconds, nanoseconds
            -> hours }.toString()
    }

    fun getDifferenceMinutes(): String {
        return _uiState.value.differenceDuration.toComponents { hours, minutes, seconds, nanoseconds
            -> minutes }.toString()
    }

    fun getDifferenceSeconds(): String {
        return _uiState.value.differenceDuration.toComponents { hours, minutes, seconds, nanoseconds
            -> seconds }.toString()
    }

    fun getMinuendHours(): String {
        return _uiState.value.minuendDuration.toComponents { hours, minutes, seconds, nanoseconds
            -> hours }.toString()
    }

    fun getMinuendMinutes(): String {
        return _uiState.value.minuendDuration.toComponents { hours, minutes, seconds, nanoseconds
            -> minutes }.toString()
    }

    fun getMinuendSeconds(): String {
        return _uiState.value.minuendDuration.toComponents { hours, minutes, seconds, nanoseconds
            -> seconds }.toString()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                SubtractScreenViewModel()
            }
        }
    }
}

data class SubtractScreenUiState(
    val inputHours: String = "",
    val inputMinutes: String = "",
    val inputSeconds: String = "",
    val valuesList: List<Duration> = emptyList(),
    val temporaryDuration: Duration = Duration.ZERO,
    val minuendDuration: Duration = Duration.ZERO,
    val subtrahendDuration: Duration = Duration.ZERO,
    val differenceDuration: Duration = Duration.ZERO
)