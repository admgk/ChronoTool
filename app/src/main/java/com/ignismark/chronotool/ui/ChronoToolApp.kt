package com.ignismark.chronotool.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ignismark.chronotool.ui.components.ChronoToolTopBar
import com.ignismark.chronotool.ui.screens.ChronoToolScreen
import com.ignismark.chronotool.ui.screens.ChronoToolScreenViewModel

@Composable
fun ChronoToolApp() {

    val addViewModel: ChronoToolScreenViewModel =
        viewModel(factory = ChronoToolScreenViewModel.Factory)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { ChronoToolTopBar() },
    ) { innerPadding ->

        ChronoToolScreen(
            modifier = Modifier.padding(innerPadding),
            viewModel = addViewModel
        )
    }
}