package com.younes.financetracker.data.repository

import com.younes.financetracker.data.local.dao.TransactionDao
import com.younes.financetracker.data.local.dao.BudgetDao
import com.younes.financetracker.data.local.entity.TransactionEntity
import com.younes.financetracker.data.local.entity.BudgetEntity
import com.younes.financetracker.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TransactionRepositoryImpl @Inject constructor(
    private val transactionDao: TransactionDao,
    private val budgetDao: BudgetDao
) : TransactionRepository {


    override fun getTransactions(): Flow<List<TransactionEntity>> {
        return transactionDao.getAllTransactions()
    }

    override suspend fun insertTransaction(transaction: TransactionEntity) {
        transactionDao.insertTransaction(transaction)
    }

    override suspend fun deleteTransaction(transaction: TransactionEntity) {
        transactionDao.deleteTransaction(transaction)
    }

    override suspend fun deleteAllTransactions() {
        transactionDao.deleteAllTransactions()
    }

    override fun getBudgets(): Flow<List<BudgetEntity>> {
        return budgetDao.getBudgets()
    }

    override suspend fun insertBudget(budget: BudgetEntity) {
        budgetDao.insertBudget(budget)
    }

    override suspend fun deleteBudget(budget: BudgetEntity) {
        budgetDao.deleteBudget(budget)
    }

}