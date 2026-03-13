package com.younes.financetracker.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.younes.financetracker.data.local.entity.TransactionEntity
import com.younes.financetracker.presentation.utils.CurrencyUtils
import com.younes.financetracker.theme.ExpenseRed
import com.younes.financetracker.theme.IncomeGreen
import java.text.SimpleDateFormat
import java.util.*
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.ui.input.pointer.pointerInput

@Composable
fun TransactionItem(
    transaction: TransactionEntity,
    onDelete: (TransactionEntity) -> Unit
) {

    var showDialog by remember { mutableStateOf(false) }

    val formatter = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())

    val amountColor =
        if (transaction.type == "income") IncomeGreen else ExpenseRed

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .pointerInput(Unit) {
                // Allow swipe left gesture to delete a transaction
                detectHorizontalDragGestures { change, dragAmount ->
                    if (dragAmount < -50) {
                        onDelete(transaction)
                    }
                }
            },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    )
     {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column {

                Text(
                    text = transaction.title,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = transaction.category,
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = formatter.format(Date(transaction.date)),
                    style = MaterialTheme.typography.bodySmall
                )

            }

            Column(
                horizontalAlignment = androidx.compose.ui.Alignment.End
            ) {

                Text(
                    text = CurrencyUtils.format(transaction.amount),
                    color = amountColor,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(6.dp))

                TextButton(
                    onClick = { showDialog = true }
                ) {
                    Text("Delete")
                }

            }

        }

    }

    if (showDialog) {

        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        onDelete(transaction)
                        showDialog = false
                    }
                ) {
                    Text("Delete")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showDialog = false }
                ) {
                    Text("Cancel")
                }
            },
            title = { Text("Delete transaction") },
            text = { Text("Are you sure you want to delete this transaction?") }
        )

    }

}