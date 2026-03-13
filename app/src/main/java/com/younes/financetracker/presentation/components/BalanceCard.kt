package com.younes.financetracker.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.younes.financetracker.data.local.entity.TransactionEntity
import com.younes.financetracker.theme.DashboardStart
import com.younes.financetracker.theme.DashboardEnd
import com.younes.financetracker.presentation.utils.CurrencyManager

@Composable
fun BalanceCard(
    transactions: List<TransactionEntity>
) {
// Calculate income, expenses, and total balance from transactions
    val income = transactions.filter { it.type == "income" }.sumOf { it.amount }
    val expenses = transactions.filter { it.type == "expense" }.sumOf { it.amount }
    val balance = income - expenses

    val gradient = Brush.horizontalGradient(
        colors = listOf(DashboardStart, DashboardEnd)
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = gradient,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(24.dp)
    ) {

        Text(
            text = "Total Balance",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = CurrencyManager.format(balance),
            fontSize = 40.sp,
            color = MaterialTheme.colorScheme.onPrimary
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column {
                Text(
                    text = "Income",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = CurrencyManager.format(income),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }

            Column {
                Text(
                    text = "Expenses",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = CurrencyManager.format(expenses),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }

        }

    }
}