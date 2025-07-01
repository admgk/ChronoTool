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

class AddScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(AddScreenUiState())
    val uiState: StateFlow<AddScreenUiState> = _uiState.asStateFlow()

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

    fun addDuration() {
        val inputDuration = calculateInputDuration()
        if (inputDuration != Duration.ZERO) {
            _uiState.value = _uiState.value.copy(valuesList = _uiState.value.valuesList + inputDuration)
            val totalDuration = _uiState.value.totalDuration + inputDuration
            _uiState.value = _uiState.value.copy(totalDuration = totalDuration)
        }
    }

    fun clearInputForm() {
        _uiState.value = _uiState.value.copy(
            inputHours = "",
            inputMinutes = "",
            inputSeconds = ""
        )
    }

    fun getHours(): String {
        return _uiState.value.totalDuration.toComponents { hours, minutes, seconds, nanoseconds
            -> hours }.toString()
    }

    fun getMinutes(): String {
        return _uiState.value.totalDuration.toComponents { hours, minutes, seconds, nanoseconds
            -> minutes }.toString()
    }

    fun getSeconds(): String {
        return _uiState.value.totalDuration.toComponents { hours, minutes, seconds, nanoseconds
            -> seconds }.toString()
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
    val valuesList: List<Duration> = emptyList(),
    val totalDuration: Duration = Duration.ZERO
)

