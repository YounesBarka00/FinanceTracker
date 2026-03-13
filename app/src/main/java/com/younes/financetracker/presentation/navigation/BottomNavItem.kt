package com.younes.financetracker.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val title: String,
    val route: String,
    val icon: ImageVector
)

val bottomNavItems = listOf(

    BottomNavItem(
        title = "Home",
        route = "home",
        icon = Icons.Default.Home
    ),

    BottomNavItem(
        title = "Analytics",
        route = "analytics",
        icon = Icons.Filled.ShowChart
    ),

    BottomNavItem(
        title = "Add",
        route = "add_transaction",
        icon = Icons.Default.AddCircle
    ),

    BottomNavItem(
        title = "Budgets",
        route = "budgets",
        icon = Icons.Default.AccountBalance
    )

)