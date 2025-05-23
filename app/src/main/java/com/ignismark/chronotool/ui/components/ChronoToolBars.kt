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
import com.ignismark.chronotool.R

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
fun ChronoToolNavigationBar() {
    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = ImageVector.vectorResource(R.drawable.cycle_24dp), contentDescription = "Convert") },
            label = { Text(text = "Convert") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = ImageVector.vectorResource(R.drawable.add_24dp), contentDescription = "Add") },
            label = { Text(text = "Add") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = ImageVector.vectorResource(R.drawable.remove_24dp), contentDescription = "Subtract") },
            label = { Text(text = "Subtract") }
        )
    }
}