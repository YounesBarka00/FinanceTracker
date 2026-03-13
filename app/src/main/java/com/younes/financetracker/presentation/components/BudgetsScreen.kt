package com.younes.financetracker.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.younes.financetracker.data.local.entity.BudgetEntity
import com.younes.financetracker.presentation.viewmodel.TransactionViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BudgetsScreen(
    viewModel: TransactionViewModel = hiltViewModel()
) {

    val budgets by viewModel.budgets.collectAsState()
    val transactions by viewModel.transactions.collectAsState()

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val categories = listOf(
        "Salary",
        "Food",
        "Transport",
        "Shopping",
        "Bills",
        "Entertainment",
        "Other"
    )

    var category by remember { mutableStateOf("") }
    var limit by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp)
        ) {

            Text(
                text = "Budgets",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(20.dp))

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {

                OutlinedTextField(
                    value = category,
                    onValueChange = {},
                    readOnly = true,
                    placeholder = { Text("Select category") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded)
                    },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp)
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {

                    categories.forEach { cat ->

                        DropdownMenuItem(
                            text = { Text(cat) },
                            onClick = {
                                category = cat
                                expanded = false
                            }
                        )

                    }

                }

            }

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = limit,
                onValueChange = { limit = it },
                label = { Text("Budget limit") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {

                    val limitValue = limit.toDoubleOrNull()

                    if (limitValue != null && category.isNotBlank()) {

                        viewModel.insertBudget(
                            BudgetEntity(
                                category = category,
                                limit = limitValue
                            )
                        )

                        scope.launch {
                            snackbarHostState.showSnackbar("Budget added")
                        }

                        limit = ""
                        category = ""

                    }

                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp)
            ) {

                Text("Add Budget")

            }

            Spacer(modifier = Modifier.height(30.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(budgets) { budget ->
                    // Calculate how much has been spent in this category
                    val spent = transactions
                        .filter {
                            it.category == budget.category && it.type == "expense"
                        }
                        .sumOf { it.amount }

                    val remaining = budget.limit - spent
                    // Calculate progress toward the budget limit
                    val progress =
                        (spent / budget.limit).coerceAtMost(1.0)

                    BudgetCard(
                        budget = budget,
                        spent = spent,
                        remaining = remaining,
                        progress = progress.toFloat(),
                        onDelete = {

                            viewModel.deleteBudget(budget)

                            scope.launch {
                                snackbarHostState.showSnackbar("Budget deleted")
                            }

                        }
                    )

                }

            }

        }

    }

}