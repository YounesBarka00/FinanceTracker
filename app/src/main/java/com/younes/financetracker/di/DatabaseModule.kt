package com.younes.financetracker.di

import android.content.Context
import androidx.room.Room
import com.younes.financetracker.data.local.database.FinanceDatabase
import com.younes.financetracker.data.local.dao.TransactionDao
import com.younes.financetracker.data.local.dao.BudgetDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    // Provides the Room database instance for dependency injection
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): FinanceDatabase {

        return Room.databaseBuilder(
            context,
            FinanceDatabase::class.java,
            "finance_database"
        )
            .fallbackToDestructiveMigration()
            .build()

    }

    @Provides
    fun provideTransactionDao(
        database: FinanceDatabase
    ): TransactionDao {

        return database.transactionDao()

    }

    @Provides
    fun provideBudgetDao(
        database: FinanceDatabase
    ): BudgetDao {
        return database.budgetDao()
    }

}