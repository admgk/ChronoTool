package com.ignismark.chronotool.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.ignismark.chronotool.ui.components.ChronoToolRoutes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

class ChronoToolViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ChronoToolUiState())
    val uiState: StateFlow<ChronoToolUiState> = _uiState.asStateFlow()

    fun updateCurrentRoute(route: ChronoToolRoutes) {
        _uiState.value = _uiState.value.copy(currentRoute = route)
    }

    fun updateInputHours(input: String) {
        when (_uiState.value.currentRoute) {
            ChronoToolRoutes.Convert -> {
                _uiState.value = _uiState.value.copy(convertInputHours = input)
            }
            ChronoToolRoutes.Add -> {
                _uiState.value = _uiState.value.copy(addInputHours = input)
            }
            ChronoToolRoutes.Subtract -> {
                _uiState.value = _uiState.value.copy(subtractInputHours = input)
            }
        }
    }

    fun updateInputMinutes(input: String) {
        when (_uiState.value.currentRoute) {
            ChronoToolRoutes.Convert -> {
                _uiState.value = _uiState.value.copy(convertInputMinutes = input)
            }
            ChronoToolRoutes.Add -> {
                _uiState.value = _uiState.value.copy(addInputMinutes = input)
            }
            ChronoToolRoutes.Subtract -> {
                _uiState.value = _uiState.value.copy(subtractInputMinutes = input)
            }
        }
    }

    fun updateInputSeconds(input: String) {
        when (_uiState.value.currentRoute) {
            ChronoToolRoutes.Convert -> {
                _uiState.value = _uiState.value.copy(convertInputSeconds = input)
            }
            ChronoToolRoutes.Add -> {
                _uiState.value = _uiState.value.copy(addInputSeconds = input)
            }
            ChronoToolRoutes.Subtract -> {
                _uiState.value = _uiState.value.copy(subtractInputSeconds = input)
            }
        }
    }

    fun calculateDuration() {
        val hours = _uiState.value.convertInputHours.toLongOrNull() ?: 0
        val minutes = _uiState.value.convertInputMinutes.toLongOrNull() ?: 0
        val seconds = _uiState.value.convertInputSeconds.toLongOrNull() ?: 0
        val duration = hours.hours + minutes.minutes + seconds.seconds
        _uiState.value = _uiState.value.copy(convertOutputDuration = duration)
    }

    fun saveAndClearPartialDuration() {
        val duration = _uiState.value.partialDuration
        if (duration != Duration.ZERO) {
            _uiState.value = _uiState.value.copy(valuesList = _uiState.value.valuesList + duration)
            _uiState.value = _uiState.value.copy(partialDuration = Duration.ZERO)
        }
    }

    fun calculatePartialDuration() {
        val hours = _uiState.value.addInputHours.toLongOrNull() ?: 0
        val minutes = _uiState.value.addInputMinutes.toLongOrNull() ?: 0
        val seconds = _uiState.value.addInputSeconds.toLongOrNull() ?: 0
        val duration = hours.hours + minutes.minutes + seconds.seconds
        _uiState.value = _uiState.value.copy(partialDuration = duration)
    }

    fun calculateTotalDuration() {
        val duration = _uiState.value.partialDuration + _uiState.value.totalDuration
        _uiState.value = _uiState.value.copy(totalDuration = duration)
    }

    fun getHours(): String {
        return _uiState.value.convertOutputDuration.toComponents { hours, minutes, seconds, nanoseconds
            -> hours }.toString()
    }

    fun getMinutes(): String {
        return _uiState.value.convertOutputDuration.toComponents { hours, minutes, seconds, nanoseconds
            -> minutes }.toString()
    }

    fun getSeconds(): String {
        return _uiState.value.convertOutputDuration.toComponents { hours, minutes, seconds, nanoseconds
            -> seconds }.toString()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                ChronoToolViewModel()
            }
        }
    }
}

data class ChronoToolUiState(
    val currentRoute: ChronoToolRoutes = ChronoToolRoutes.Convert,
    val convertInputHours: String = "",
    val addInputHours: String = "",
    val subtractInputHours: String = "",
    val convertInputMinutes: String = "",
    val addInputMinutes: String = "",
    val subtractInputMinutes: String = "",
    val convertInputSeconds: String = "",
    val addInputSeconds: String = "",
    val subtractInputSeconds: String = "",
    val convertOutputDuration: Duration = Duration.ZERO,
    val valuesList: List<Duration> = emptyList(),
    val partialDuration: Duration = Duration.ZERO,
    val totalDuration: Duration = Duration.ZERO
)
