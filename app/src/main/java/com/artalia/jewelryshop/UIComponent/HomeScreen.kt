package com.artalia.jewelryshop.UIComponent

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.artalia.jewelryshop.Component.MyBottomBar

@Composable
fun HomeScreen (){
    val scaffoldState = rememberScaffoldState()
    Scaffold (
        bottomBar = {
            MyBottomBar()
        },
        scaffoldState = scaffoldState
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {

        }
    }
}