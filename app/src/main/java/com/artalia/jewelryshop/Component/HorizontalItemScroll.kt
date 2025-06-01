package com.artalia.jewelryshop.Component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalItemScroll(){
    LazyRow (
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {

    }
}