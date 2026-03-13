package com.younes.financetracker.domain.repository

import com.younes.financetracker.data.local.entity.TransactionEntity
import com.younes.financetracker.data.local.entity.BudgetEntity
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {


    fun getTransactions(): Flow<List<TransactionEntity>>

    suspend fun insertTransaction(transaction: TransactionEntity)

    suspend fun deleteTransaction(transaction: TransactionEntity)

    suspend fun deleteAllTransactions()


    fun getBudgets(): Flow<List<BudgetEntity>>

    suspend fun insertBudget(budget: BudgetEntity)

    suspend fun deleteBudget(budget: BudgetEntity)

}