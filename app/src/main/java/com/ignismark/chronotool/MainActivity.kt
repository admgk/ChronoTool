package com.ignismark.chronotool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.ignismark.chronotool.ui.components.ChronoToolNavigationBar
import com.ignismark.chronotool.ui.components.ChronoToolTopBar
import com.ignismark.chronotool.ui.screens.ChronoConvert
import com.ignismark.chronotool.ui.theme.ChronoToolTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChronoToolTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { ChronoToolTopBar() },
                    bottomBar = { ChronoToolNavigationBar() }
                ) { innerPadding ->
                    ChronoConvert(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}