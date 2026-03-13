package com.younes.financetracker.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.younes.financetracker.presentation.navigation.bottomNavItems
import com.younes.financetracker.presentation.navigation.Routes
import com.younes.financetracker.presentation.viewmodel.TransactionViewModel
import com.younes.financetracker.presentation.components.BudgetsScreen
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen(
    viewModel: TransactionViewModel = hiltViewModel()
) {

    val navController = rememberNavController()

    Scaffold(

        bottomBar = {

            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surface
            ) {

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                bottomNavItems.forEach { item ->

                    NavigationBarItem(
                        selected = currentRoute == item.route,

                        onClick = {

                            navController.navigate(item.route) {

                                popUpTo(Routes.HOME) {
                                    saveState = true
                                }

                                launchSingleTop = true
                                restoreState = true
                            }

                        },

                        label = {
                            Text(item.title)
                        },

                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.title
                            )
                        }

                    )

                }

            }

        }

    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = Routes.HOME,
            modifier = Modifier.padding(padding)
        ) {

            composable(Routes.HOME) {
                HomeScreen(viewModel)
            }

            composable(Routes.ANALYTICS) {
                AnalyticsScreen()
            }

            composable(Routes.ADD_TRANSACTION) {
                AddTransactionScreen(navController, viewModel)
            }

            composable(Routes.BUDGETS) {
                BudgetsScreen(viewModel)
            }

        }

    }

}