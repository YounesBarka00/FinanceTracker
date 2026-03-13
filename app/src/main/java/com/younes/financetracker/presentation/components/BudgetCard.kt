package com.younes.financetracker.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.younes.financetracker.data.local.entity.BudgetEntity
import com.younes.financetracker.presentation.utils.CurrencyManager
import com.younes.financetracker.theme.ExpenseRed
import com.younes.financetracker.theme.IncomeGreen
import com.younes.financetracker.theme.CardDark

@Composable
fun BudgetCard(
    budget: BudgetEntity,
    spent: Double,
    remaining: Double,
    progress: Float,
    onDelete: () -> Unit
) {
    // Change progress bar color depending on how close the user is to the budget limit
    val progressColor =
        when {
            progress >= 1f -> ExpenseRed
            progress >= 0.8f -> MaterialTheme.colorScheme.secondary
            else -> IncomeGreen
        }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardDark
        )
    ) {

        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = budget.category,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "${CurrencyManager.format(spent)} / ${CurrencyManager.format(budget.limit)}"
                )

            }

            Spacer(modifier = Modifier.height(12.dp))

            LinearProgressIndicator(
                progress = { progress },
                color = progressColor,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Remaining: ${CurrencyManager.format(remaining)}"
            )

            Spacer(modifier = Modifier.height(14.dp))

            Button(
                onClick = onDelete,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp)
            ) {

                Text("Delete Budget")

            }

        }

    }

}