package com.ignismark.chronotool.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.ignismark.chronotool.ui.components.InputFormField
import com.ignismark.chronotool.ui.utils.calculateDuration
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.time.Duration

class SubtractScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SubtractScreenUiState())
    val uiState: StateFlow<SubtractScreenUiState> = _uiState.asStateFlow()

    fun updateInputFormFocus(inputFormField: InputFormField) {
        _uiState.value = _uiState.value.copy(inputFormFocus = inputFormField)
    }

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

    fun clearResults() {
        _uiState.value = _uiState.value.copy(
            valuesList = emptyList(),
            outputDuration = Duration.ZERO
        )
    }

    fun clearScreen() {
        _uiState.value = _uiState.value.copy(
            inputHours = "",
            inputMinutes = "",
            inputSeconds = "",
            valuesList = emptyList(),
            minuendDuration = Duration.ZERO,
            outputDuration = Duration.ZERO
        )
    }

    fun subtractDuration() {
        val inputDuration = calculateInputDuration()
        if (inputDuration != Duration.ZERO) {
            _uiState.value = _uiState.value.copy(valuesList = _uiState.value.valuesList + inputDuration)
            if (_uiState.value.outputDuration == Duration.ZERO) {
                _uiState.value = _uiState.value.copy(outputDuration = _uiState.value.minuendDuration)
            }
            val duration = _uiState.value.outputDuration - inputDuration
            _uiState.value = _uiState.value.copy(outputDuration = duration)
        }
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
                SubtractScreenViewModel()
            }
        }
    }
}

data class SubtractScreenUiState(
    val inputHours: String = "",
    val inputMinutes: String = "",
    val inputSeconds: String = "",
    val inputFormFocus: InputFormField = InputFormField.NONE,
    val valuesList: List<Duration> = emptyList(),
    val minuendDuration: Duration = Duration.ZERO,
    val outputDuration: Duration = Duration.ZERO
)
