package com.younes.financetracker.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.younes.financetracker.data.local.dao.TransactionDao
import com.younes.financetracker.data.local.dao.BudgetDao
import com.younes.financetracker.data.local.entity.TransactionEntity
import com.younes.financetracker.data.local.entity.BudgetEntity

@Database(
    entities = [
        TransactionEntity::class,
        BudgetEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class FinanceDatabase : RoomDatabase() {

    abstract fun transactionDao(): TransactionDao

    abstract fun budgetDao(): BudgetDao

}