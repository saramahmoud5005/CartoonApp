package com.example.cartoonapp.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.domain.model.NavigationItem

val items = listOf(
    NavigationItem(
        title = "Menu",
        selectedIcon = Icons.Default.Menu,
        unSelectedIcon = Icons.Default.Menu,
        hasNews = false
    ),
    NavigationItem(
        title = "Add",
        selectedIcon = Icons.Default.Add,
        unSelectedIcon = Icons.Default.Add,
        hasNews = false
    ),
)
@Composable
fun NavigationSideBar(
    items:List<NavigationItem>,
    selectedIndexItem:Int,
    onNavigate:(Int)->Unit
) {
    NavigationRail(
        header = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "menu")
            }
            FloatingActionButton(
                onClick = { /*TODO*/ },
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "add")
            }
        }
    ) {
        items.forEachIndexed { index, item ->
            NavigationRailItem(
                selected = selectedIndexItem == index,
                onClick = {
                    onNavigate(index)
                },
                icon = {
                    NavigationIcon(item = item, selected = selectedIndexItem == index)
                },
                label = {
                    Text(text = item.title)
                },
            )
        }
    }
}

@Composable
fun NavigationIcon(
    item: NavigationItem,
    selected:Boolean
){
    BadgedBox(
        badge = {
            if(item.badgeCount!=null){
                Badge{
                    Text(text = item.badgeCount.toString())
                }
            } else if(item.hasNews){
                Badge()
            }
        }
    ) {
        Icon(
            imageVector = if(selected) item.selectedIcon else item.unSelectedIcon,
            contentDescription = "Icon"
        )
    }
}