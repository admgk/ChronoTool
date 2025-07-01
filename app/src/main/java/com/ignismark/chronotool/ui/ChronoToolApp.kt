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
import com.ignismark.chronotool.ui.screens.ConvertScreen
import com.ignismark.chronotool.ui.screens.ConvertScreenViewModel
import com.ignismark.chronotool.ui.screens.SubtractScreen
import com.ignismark.chronotool.ui.screens.SubtractScreenViewModel

@Composable
fun ChronoToolApp() {

    val convertViewModel: ConvertScreenViewModel =
        viewModel(factory = ConvertScreenViewModel.Factory)
    val addViewModel: AddScreenViewModel =
        viewModel(factory = AddScreenViewModel.Factory)
    val subtractViewModel: SubtractScreenViewModel =
        viewModel(factory = SubtractScreenViewModel.Factory)

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
                ConvertScreen(
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
                SubtractScreen(
                    modifier = Modifier.padding(innerPadding),
                    viewModel = subtractViewModel
                )
            }
        }
    }
}