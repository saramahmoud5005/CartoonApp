package com.example.domain.model

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title: String,
    val selectedIcon:ImageVector,
    val unSelectedIcon:ImageVector,
    val hasNews:Boolean,
    val badgeCount:Int?=null
)

