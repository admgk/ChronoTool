package com.ignismark.chronotool.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ignismark.chronotool.ui.components.ChronoToolNavigationBar
import com.ignismark.chronotool.ui.components.ChronoToolTopBar
import com.ignismark.chronotool.ui.components.ChronoToolRoutes
import com.ignismark.chronotool.ui.screens.AddScreen
import com.ignismark.chronotool.ui.screens.AddScreenViewModel
import com.ignismark.chronotool.ui.screens.ChronoConvert
import com.ignismark.chronotool.ui.screens.ChronoConvertViewModel

@Composable
fun ChronoToolApp() {

    val convertViewModel: ChronoConvertViewModel =
        viewModel(factory = ChronoConvertViewModel.Factory)
    val addViewModel: AddScreenViewModel =
        viewModel(factory = AddScreenViewModel.Factory)
    val navController: NavHostController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { ChronoToolTopBar() },
        bottomBar = { ChronoToolNavigationBar(navController) }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = ChronoToolRoutes.Convert.title
        ) {
            composable(route = ChronoToolRoutes.Convert.title) {
                ChronoConvert(
                    modifier = Modifier.padding(innerPadding),
                    viewModel = convertViewModel
                )
            }
            composable(route = ChronoToolRoutes.Add.title) {
                AddScreen(
                    modifier = Modifier.padding(innerPadding),
                    viewModel = addViewModel
                )
            }
            composable(route = ChronoToolRoutes.Subtract.title) {
                ChronoConvert(
                    modifier = Modifier.padding(innerPadding),
                    viewModel = convertViewModel
                )
            }
        }
    }
}