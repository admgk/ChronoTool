package com.ignismark.chronotool.ui.utils

import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

fun calculateDuration(
    inputHours: String,
    inputMinutes: String,
    inputSeconds: String
) : Duration {
    val hours = inputHours.trim().toLongOrNull() ?: 0
    val minutes = inputMinutes.trim().toLongOrNull() ?: 0
    val seconds = inputSeconds.trim().toLongOrNull() ?: 0
    val duration = hours.hours + minutes.minutes + seconds.seconds
    return duration
}
