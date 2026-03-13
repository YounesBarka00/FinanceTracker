package com.younes.financetracker.presentation.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.younes.financetracker.presentation.viewmodel.TransactionViewModel
import androidx.compose.ui.graphics.Color
import com.younes.financetracker.presentation.utils.CurrencyUtils

@Composable
fun AnalyticsScreen(
    viewModel: TransactionViewModel = hiltViewModel()
) {

    val transactions by viewModel.transactions.collectAsState()

    // Calculate total expenses grouped by category
    val categoryTotals = transactions
        .filter { it.type == "expense" }
        .groupBy { it.category }
        .mapValues { entry -> entry.value.sumOf { it.amount } }

    val total = categoryTotals.values.sum()

    val colors = listOf(
        Color(0xFFEF4444),
        Color(0xFF3B82F6),
        Color(0xFF22C55E),
        Color(0xFFF59E0B),
        Color(0xFF8B5CF6)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Expense Analytics",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(40.dp))

        if (total == 0.0) {

            Text("No expense data yet")

        } else {

            Canvas(
                modifier = Modifier.size(240.dp)
            ) {

                var startAngle = -90f

                categoryTotals.entries.forEachIndexed { index, entry ->

                    val sweep = (entry.value / total * 360).toFloat()

                    drawArc(
                        color = colors[index % colors.size],
                        startAngle = startAngle,
                        sweepAngle = sweep,
                        useCenter = false,
                        style = Stroke(
                            width = 70f,
                            cap = StrokeCap.Round
                        ),
                        size = Size(size.width, size.height)
                    )

                    startAngle += sweep
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                categoryTotals.entries.forEachIndexed { index, entry ->

                    val percent = (entry.value / total * 100).toInt()

                    Column {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(entry.key)

                            Text("${percent}%")

                        }

                        LinearProgressIndicator(
                            progress = { (entry.value / total).toFloat() },
                            color = colors[index % colors.size],
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp)
                        )

                        Text(
                            CurrencyUtils.format(entry.value),
                            style = MaterialTheme.typography.bodySmall
                        )

                    }

                }

            }

        }

    }

}