package com.younes.financetracker.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

// datastore instance used to persist user settings such as selected currency
private val Context.dataStore by preferencesDataStore("settings")

class CurrencyDataStore(private val context: Context) {

    companion object {
        val CURRENCY_KEY = stringPreferencesKey("currency")
    }

    val currencyFlow = context.dataStore.data.map { preferences ->
        preferences[CURRENCY_KEY] ?: "USD"
    }

    suspend fun saveCurrency(currency: String) {

        context.dataStore.edit { preferences ->
            preferences[CURRENCY_KEY] = currency
        }

    }

}