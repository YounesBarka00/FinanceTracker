package com.younes.financetracker.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BudgetProgress(
    category: String,
    spent: Double,
    budget: Double
) {

    var showDialog by remember { mutableStateOf(false) }
    var newBudget by remember { mutableStateOf(budget.toString()) }

    val progress = (spent / budget).toFloat().coerceIn(0f, 1f)

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(category)

            TextButton(
                onClick = { showDialog = true }
            ) {
                Text("${spent.toInt()} / ${budget.toInt()}")
            }

        }

        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )
        Spacer(
            modifier = Modifier.height(12.dp)
        )
        if (showDialog) {

            AlertDialog(
                onDismissRequest = { showDialog = false },

                title = { Text("Edit Budget") },

                text = {

                    OutlinedTextField(
                        value = newBudget,
                        onValueChange = { newBudget = it },
                        label = { Text("New Budget") }
                    )

                },

                confirmButton = {

                    Button(
                        onClick = {
                            showDialog = false
                        }
                    ) {
                        Text("Save")
                    }

                }
            )
        }
    }
}