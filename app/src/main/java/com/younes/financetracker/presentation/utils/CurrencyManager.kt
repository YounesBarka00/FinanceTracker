package com.younes.financetracker.presentation.utils

import androidx.compose.runtime.mutableStateOf

// Manages the currently selected currency used across the app
object CurrencyManager {

    val currencyState = mutableStateOf("USD")

    val currentCurrency: String
        get() = currencyState.value

    fun setCurrency(currency: String) {
        currencyState.value = currency
    }

    fun format(amount: Double): String {
        return when (currencyState.value) {
            "USD" -> "$%.2f".format(amount)
            "EUR" -> "€%.2f".format(amount)
            else -> "$%.2f".format(amount)
        }
    }
}