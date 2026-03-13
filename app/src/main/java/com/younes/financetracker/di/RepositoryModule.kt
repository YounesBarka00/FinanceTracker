package com.younes.financetracker.di

import com.younes.financetracker.data.local.dao.TransactionDao
import com.younes.financetracker.data.local.dao.BudgetDao
import com.younes.financetracker.data.repository.TransactionRepositoryImpl
import com.younes.financetracker.domain.repository.TransactionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideTransactionRepository(
        transactionDao: TransactionDao,
        budgetDao: BudgetDao
    ): TransactionRepository {

        return TransactionRepositoryImpl(
            transactionDao = transactionDao,
            budgetDao = budgetDao
        )
    }

}