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

class AddScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(AddScreenUiState())
    val uiState: StateFlow<AddScreenUiState> = _uiState.asStateFlow()

    fun updateInputFormFocus(inputFormField: InputFormField) {
        _uiState.value = _uiState.value.copy(inputFormFocus = inputFormField)
    }

    fun updateInputValue(input: String) {
        when (_uiState.value.inputFormFocus) {
            InputFormField.HOURS ->
                when (input) {
                    "C" -> _uiState.value = _uiState.value.copy(inputHours = "")
                    "<" -> _uiState.value = _uiState.value.copy(
                        inputHours =_uiState.value.inputHours.dropLast(1)
                    )
                    else -> _uiState.value = _uiState.value.copy(
                        inputHours = _uiState.value.inputHours.plus(input)
                    )
                }
            InputFormField.MINUTES ->
                when (input) {
                    "C" -> _uiState.value = _uiState.value.copy(inputMinutes = "")
                    "<" -> _uiState.value = _uiState.value.copy(
                        inputMinutes =_uiState.value.inputMinutes.dropLast(1)
                    )
                    else -> _uiState.value = _uiState.value.copy(
                        inputMinutes = _uiState.value.inputMinutes.plus(input)
                    )
                }
            InputFormField.SECONDS ->
                when (input) {
                    "C" -> _uiState.value = _uiState.value.copy(inputSeconds = "")
                    "<" -> _uiState.value = _uiState.value.copy(
                        inputSeconds = _uiState.value.inputSeconds.dropLast(1)
                    )
                    else -> _uiState.value = _uiState.value.copy(
                        inputSeconds = _uiState.value.inputSeconds.plus(input)
                    )
                }
            else -> { }
        }
    }

    fun calculateInputDuration() : Duration {
        return calculateDuration(
            inputHours = _uiState.value.inputHours,
            inputMinutes = _uiState.value.inputMinutes,
            inputSeconds = _uiState.value.inputSeconds
        )
    }

    fun addDuration() {
        val inputDuration = calculateInputDuration()
        if (inputDuration != Duration.ZERO) {
            _uiState.value = _uiState.value.copy(valuesList = _uiState.value.valuesList + inputDuration)
            val totalDuration = _uiState.value.outputDuration + inputDuration
            _uiState.value = _uiState.value.copy(outputDuration = totalDuration)
        }
    }

    fun clearInputForm() {
        _uiState.value = _uiState.value.copy(
            inputHours = "",
            inputMinutes = "",
            inputSeconds = "",
            inputFormFocus = InputFormField.NONE
        )
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

    fun clearScreen() {
        _uiState.value = _uiState.value.copy(
            inputHours = "",
            inputMinutes = "",
            inputSeconds = "",
            inputFormFocus = InputFormField.NONE,
            valuesList = emptyList(),
            outputDuration = Duration.ZERO
        )
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                AddScreenViewModel()
            }
        }
    }
}

data class AddScreenUiState(
    val inputHours: String = "",
    val inputMinutes: String = "",
    val inputSeconds: String = "",
    val inputFormFocus: InputFormField = InputFormField.NONE,
    val valuesList: List<Duration> = emptyList(),
    val outputDuration: Duration = Duration.ZERO
)

