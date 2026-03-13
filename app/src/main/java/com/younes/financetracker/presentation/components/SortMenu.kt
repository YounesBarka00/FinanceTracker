package com.younes.financetracker.presentation.components

import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.foundation.layout.Box

@Composable
fun SortMenu(
    selected: TransactionSort,
    onSelected: (TransactionSort) -> Unit
) {

    var expanded by remember { mutableStateOf(false) }

    Box {

        Button(
            onClick = { expanded = true }
        ) {
            Text("Sort")
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {

            TransactionSort.values().forEach { sortType ->

                DropdownMenuItem(
                    text = { Text(sortType.name) },
                    onClick = {

                        onSelected(sortType)
                        expanded = false

                    }
                )

            }

        }

    }

}