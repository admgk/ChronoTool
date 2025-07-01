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

    fun calculateInputDuration() : Duration {
        return calculateDuration(
            inputHours = _uiState.value.inputHours,
            inputMinutes = _uiState.value.inputMinutes,
            inputSeconds = _uiState.value.inputSeconds
        )
    }

    fun setMinuendDuration() {
        val inputDuration = calculateInputDuration()
        if (inputDuration != Duration.ZERO) {
            _uiState.value = _uiState.value.copy(minuendDuration = inputDuration)
        }
    }

    fun clearInputForm() {
        _uiState.value = _uiState.value.copy(
            inputHours = "",
            inputMinutes = "",
            inputSeconds = ""
        )
    }

    fun subtractDuration() {
        val inputDuration = calculateInputDuration()
        if (inputDuration != Duration.ZERO) {
            _uiState.value = _uiState.value.copy(valuesList = _uiState.value.valuesList + inputDuration)
            if (_uiState.value.differenceDuration == Duration.ZERO) {
                _uiState.value = _uiState.value.copy(differenceDuration = _uiState.value.minuendDuration)
            }
            val duration = _uiState.value.differenceDuration - inputDuration
            _uiState.value = _uiState.value.copy(differenceDuration = duration)
        }
    }

    fun clearScreen() {
        _uiState.value = _uiState.value.copy(
            inputHours = "",
            inputMinutes = "",
            inputSeconds = "",
            valuesList = emptyList(),
            minuendDuration = Duration.ZERO,
            differenceDuration = Duration.ZERO
        )
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
    val minuendDuration: Duration = Duration.ZERO,
    val differenceDuration: Duration = Duration.ZERO
)
