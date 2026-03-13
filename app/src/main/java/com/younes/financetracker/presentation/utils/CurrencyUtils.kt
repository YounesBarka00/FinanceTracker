package com.younes.financetracker.presentation.utils

object CurrencyUtils {

    private const val USD_TO_EUR = 0.92

    // Converts amounts depending on the selected currency
    fun convert(amount: Double): Double {

        return when (CurrencyManager.currentCurrency) {

            "EUR" -> amount * USD_TO_EUR

            else -> amount

        }

    }

    fun format(amount: Double): String {

        val converted = convert(amount)

        return CurrencyManager.format(converted)

    }

}