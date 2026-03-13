package com.younes.financetracker.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.younes.financetracker.presentation.utils.CurrencyManager
import com.younes.financetracker.theme.PrimaryBlue

@Composable
fun CurrencyButton(
    currency: String,
    onClick: () -> Unit
) {

    val isSelected = CurrencyManager.currentCurrency == currency

    Button(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor =
                if (isSelected) PrimaryBlue
                else MaterialTheme.colorScheme.surface
        ),
        modifier = Modifier
            .border(
                width = 1.dp,
                color = PrimaryBlue,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 4.dp)
    ) {

        Text(currency)

    }

}