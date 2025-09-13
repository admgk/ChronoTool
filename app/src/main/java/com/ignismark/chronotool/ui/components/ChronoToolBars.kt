package com.ignismark.chronotool.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import com.ignismark.chronotool.R
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.runtime.getValue
import com.ignismark.chronotool.ui.utils.ChronoToolRoutes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChronoToolTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(text = "Chrono Tool")
        }
    )
}