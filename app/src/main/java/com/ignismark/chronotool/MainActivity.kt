package com.ignismark.chronotool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ignismark.chronotool.ui.ChronoToolApp
import com.ignismark.chronotool.ui.theme.ChronoToolTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChronoToolTheme {
                ChronoToolApp()
            }
        }
    }
}