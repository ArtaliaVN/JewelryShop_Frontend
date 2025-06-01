package com.artalia.jewelryshop.Component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artalia.jewelryshop.R

@Composable
@Preview
fun SearchBar () {
    var searching by rememberSaveable { mutableStateOf("") }
    Column {
        Box(
            modifier = Modifier
                .align(Alignment.Start)
        ) {
            Text(
                "Welcome to Shining Gold!",
                color = colorResource(R.color.black),
                fontSize = 40.sp
            )
        }

        Spacer(Modifier.height(10.dp))

        TextField(
            value = searching,
            onValueChange = {searching = it},
            shape = RoundedCornerShape(10.dp),
            label = {},
            modifier = Modifier
                .height(60.dp)
                .width(320.dp),
        )
    }
}