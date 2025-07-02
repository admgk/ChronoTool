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

@Composable
fun ChronoToolNavigationBar(
    navController: NavController
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        NavigationBarItem(
            selected = currentRoute == ChronoToolRoutes.Convert.title,
            onClick = { navController.navigate(ChronoToolRoutes.Convert.title) },
            icon = { Icon(imageVector = ImageVector.vectorResource(R.drawable.cycle_24dp), contentDescription = "Convert") },
            label = { Text(text = "Convert") }
        )
        NavigationBarItem(
            selected = currentRoute == ChronoToolRoutes.Add.title,
            onClick = { navController.navigate(ChronoToolRoutes.Add.title) },
            icon = { Icon(imageVector = ImageVector.vectorResource(R.drawable.add_24dp), contentDescription = "Add") },
            label = { Text(text = "Add") }
        )
        NavigationBarItem(
            selected = currentRoute == ChronoToolRoutes.Subtract.title,
            onClick = { navController.navigate(ChronoToolRoutes.Subtract.title) },
            icon = { Icon(imageVector = ImageVector.vectorResource(R.drawable.remove_24dp), contentDescription = "Subtract") },
            label = { Text(text = "Subtract") }
        )
    }
}