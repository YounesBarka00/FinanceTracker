package com.younes.financetracker.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.younes.financetracker.data.local.entity.TransactionEntity
import androidx.compose.ui.graphics.Color
import com.younes.financetracker.theme.IncomeGreen
import com.younes.financetracker.theme.ExpenseRed

@Composable
fun IncomeExpenseChart(transactions: List<TransactionEntity>) {

    val income = transactions.filter { it.type == "income" }.sumOf { it.amount }
    val expense = transactions.filter { it.type == "expense" }.sumOf { it.amount }

    val total = income + expense
    // Calculate percentage distribution of income vs expenses

    val incomePercent = if (total == 0.0) 0f else (income / total).toFloat()
    val expensePercent = if (total == 0.0) 0f else (expense / total).toFloat()

    Column {

        Text(
            text = "Income vs Expenses",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(10.dp))

        LinearProgressIndicator(
            progress = { incomePercent },
            color = IncomeGreen,
            trackColor = Color.LightGray,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(6.dp))

        LinearProgressIndicator(
            progress = { expensePercent },
            color = ExpenseRed,
            trackColor = Color.LightGray,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Income ${(incomePercent * 100).toInt()}%  •  Expenses ${(expensePercent * 100).toInt()}%"
        )

    }
}