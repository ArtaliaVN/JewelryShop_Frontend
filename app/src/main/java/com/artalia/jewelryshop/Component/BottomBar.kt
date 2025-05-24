package com.artalia.jewelryshop.Component

import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artalia.jewelryshop.R

@Composable
@Preview
fun MyBottomBar(){
    val bottomMenuItemsList = prepareBottomMenu()
    val context = LocalContext.current
    var selectedItem by remember { mutableStateOf("Home") }

    BottomAppBar(
        backgroundColor = colorResource(R.color.grey),
        elevation = 3.dp
    ) {
        bottomMenuItemsList.forEach { bottomMenuItem ->
            BottomNavigationItem(
                selected = (selectedItem == bottomMenuItem.label),
                onClick = {
                    selectedItem = bottomMenuItem.label
                    if(selectedItem == "cart"){

                    }
                    else{

                    }
                },
                icon = {
                    Icon(
                        painter = bottomMenuItem.icon,
                        contentDescription = null
                    )
                }
            )
        }
    }
}

data class BottomMenuItem(
    val label:String, val icon: Painter
)

@Composable
fun prepareBottomMenu():List<BottomMenuItem>{
    val bottomMenuItemList = arrayListOf<BottomMenuItem>()
    bottomMenuItemList.add(BottomMenuItem(label = "Home", icon = painterResource(R.drawable.ic_launcher_foreground)))
    bottomMenuItemList.add(BottomMenuItem(label = "Search", icon = painterResource(R.drawable.ic_launcher_foreground)))
    bottomMenuItemList.add(BottomMenuItem(label = "Cart", icon = painterResource(R.drawable.ic_launcher_foreground)))
    bottomMenuItemList.add(BottomMenuItem(label = "Profile", icon = painterResource(R.drawable.ic_launcher_foreground)))
    return bottomMenuItemList
}