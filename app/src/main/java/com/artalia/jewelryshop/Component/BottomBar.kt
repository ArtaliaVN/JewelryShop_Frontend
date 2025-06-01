package com.artalia.jewelryshop.Component

import androidx.compose.foundation.layout.imePadding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artalia.jewelryshop.R

@Composable
@Preview
fun MyBottomBar(){
    val bottomMenuItemsList = prepareBottomMenu()
    val context = LocalContext.current
    var selectedItem by rememberSaveable { mutableStateOf("Home") }
    var selectedIndex by rememberSaveable { mutableIntStateOf(0) }
    BottomAppBar(
        modifier = Modifier
            .imePadding(),
        backgroundColor = colorResource(R.color.grey),
        elevation = 3.dp
    ) {
        bottomMenuItemsList.forEachIndexed {index, bottomMenuItem ->
            BottomNavigationItem(
                selected = (selectedItem == bottomMenuItem.label),
                onClick = {
                    selectedItem = bottomMenuItem.label
                    selectedIndex = index
                },
                icon = {
                    Icon(
                        imageVector =   if(selectedIndex == index)
                            bottomMenuItem.selectedIcon
                                        else
                            bottomMenuItem.unselectedIcon,
                        contentDescription = null
                    )
                }
            )
        }
    }
}

data class BottomMenuItem(
    val label:String, val selectedIcon: ImageVector, val unselectedIcon: ImageVector
)

@Composable
fun prepareBottomMenu():List<BottomMenuItem>{
    val bottomMenuItemList = arrayListOf<BottomMenuItem>()
    bottomMenuItemList.add(BottomMenuItem(label = "Home", selectedIcon = Icons.Filled.Home, unselectedIcon = Icons.Outlined.Home))
    bottomMenuItemList.add(BottomMenuItem(label = "Search", selectedIcon = Icons.Rounded.Search, unselectedIcon = Icons.Outlined.Search))
    bottomMenuItemList.add(BottomMenuItem(label = "Cart", selectedIcon = Icons.Filled.ShoppingCart, unselectedIcon = Icons.Outlined.ShoppingCart))
    bottomMenuItemList.add(BottomMenuItem(label = "Wishlist", selectedIcon = Icons.Filled.Favorite, unselectedIcon = Icons.Outlined.FavoriteBorder))
    bottomMenuItemList.add(BottomMenuItem(label = "Profile", selectedIcon = Icons.Filled.AccountCircle, unselectedIcon = Icons.Outlined.AccountCircle))
    return bottomMenuItemList
}