package com.younes.financetracker.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.younes.financetracker.data.local.entity.TransactionEntity
import com.younes.financetracker.presentation.utils.CurrencyUtils
import com.younes.financetracker.theme.PrimaryBlue
import com.younes.financetracker.theme.SurfaceDark

@Composable
fun MonthlyChart(
    transactions: List<TransactionEntity>
) {

    val expenses = transactions
        .filter { it.type == "expense" }
        .sumOf { it.amount }

    val maxAmount = 5000

    // Calculate bar height relative to the maximum monthly amount
    val barHeight = ((expenses / maxAmount) * 200).coerceAtMost(200.0)

    Column {

        Text(
            text = "Monthly spending",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {

            Box(
                modifier = Modifier
                    .width(42.dp)
                    .height(200.dp)
                    .background(
                        SurfaceDark,
                        RoundedCornerShape(10.dp)
                    )
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(barHeight.dp)
                        .align(Alignment.BottomCenter)
                        .background(
                            PrimaryBlue,
                            RoundedCornerShape(10.dp)
                        )
                )

            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = CurrencyUtils.format(expenses)
            )

            Text(
                text = "Mar",
                style = MaterialTheme.typography.bodySmall
            )

        }

    }

}