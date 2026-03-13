package com.younes.financetracker.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.younes.financetracker.presentation.components.*
import com.younes.financetracker.presentation.viewmodel.TransactionViewModel
import com.younes.financetracker.theme.BackgroundDark

@Composable
fun HomeScreen(
    viewModel: TransactionViewModel = hiltViewModel()
) {

    val transactions by viewModel.transactions.collectAsState()

    var searchQuery by remember { mutableStateOf("") }

    val filteredTransactions = transactions.filter {
        it.title.contains(searchQuery, true) ||
                it.category.contains(searchQuery, true)
    }

    Scaffold(
        containerColor = BackgroundDark
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            item {

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    CurrencyButton("USD") {
                        viewModel.setCurrency("USD")
                    }

                    CurrencyButton("EUR") {
                        viewModel.setCurrency("EUR")
                    }

                }

                Spacer(modifier = Modifier.height(14.dp))

                DashboardCard(transactions)

                IncomeExpenseChart(transactions)

                MonthlyChart(transactions)

                Spacer(modifier = Modifier.height(10.dp))

                SearchBar(
                    query = searchQuery,
                    onQueryChange = { searchQuery = it }
                )

                Text(
                    text = "Recent Transactions",
                    style = MaterialTheme.typography.titleLarge
                )
            }

            items(filteredTransactions.take(5)) { transaction ->

                TransactionItem(
                    transaction = transaction,
                    onDelete = {
                        viewModel.deleteTransaction(it)
                    }
                )

            }

            item {
                Spacer(modifier = Modifier.height(120.dp))
            }

        }

    }

}