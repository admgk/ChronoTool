package com.ignismark.chronotool.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.time.Duration

@Composable
fun HistoryHorizontalGrid(
    valuesList: List<Duration>,
) {
    LazyHorizontalGrid(
        modifier = Modifier
            .fillMaxWidth()
            .height(36.dp)
            .padding(horizontal = 8.dp, vertical = 4.dp),
        rows = GridCells.Fixed(1),
        userScrollEnabled = true,
        horizontalArrangement = Arrangement.Start,
        verticalArrangement = Arrangement.Top,
    ) {
        items(valuesList.size) { index ->
            Card(
                modifier = Modifier
                    .aspectRatio(3.5f)
                    .padding(2.dp),
                border = BorderStroke(1.dp, Color.Black)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = valuesList[index]
                        .toComponents { hours, minutes, seconds, nanoseconds ->
                            "${hours}H ${minutes}M ${seconds}S" }
                    )
                }
            }
        }
    }
}