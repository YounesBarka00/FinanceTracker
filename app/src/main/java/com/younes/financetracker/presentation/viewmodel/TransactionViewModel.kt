package com.younes.financetracker.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.younes.financetracker.data.local.entity.BudgetEntity
import com.younes.financetracker.data.local.entity.TransactionEntity
import com.younes.financetracker.domain.repository.TransactionRepository
import com.younes.financetracker.presentation.utils.CurrencyManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val repository: TransactionRepository
) : ViewModel() {

    val transactions: StateFlow<List<TransactionEntity>> =
        repository.getTransactions().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    val budgets: StateFlow<List<BudgetEntity>> =
        repository.getBudgets().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addTransaction(transaction: TransactionEntity) {
        viewModelScope.launch { repository.insertTransaction(transaction) }
    }

    fun deleteTransaction(transaction: TransactionEntity) {
        viewModelScope.launch { repository.deleteTransaction(transaction) }
    }

    fun insertBudget(budget: BudgetEntity) {
        viewModelScope.launch { repository.insertBudget(budget) }
    }

    fun deleteBudget(budget: BudgetEntity) {
        viewModelScope.launch { repository.deleteBudget(budget) }
    }

    fun setCurrency(currency: String) {
        CurrencyManager.setCurrency(currency)
    }
}