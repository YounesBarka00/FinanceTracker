package com.younes.financetracker.data.repository;

import com.younes.financetracker.data.local.dao.BudgetDao;
import com.younes.financetracker.data.local.dao.TransactionDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class TransactionRepositoryImpl_Factory implements Factory<TransactionRepositoryImpl> {
  private final Provider<TransactionDao> transactionDaoProvider;

  private final Provider<BudgetDao> budgetDaoProvider;

  public TransactionRepositoryImpl_Factory(Provider<TransactionDao> transactionDaoProvider,
      Provider<BudgetDao> budgetDaoProvider) {
    this.transactionDaoProvider = transactionDaoProvider;
    this.budgetDaoProvider = budgetDaoProvider;
  }

  @Override
  public TransactionRepositoryImpl get() {
    return newInstance(transactionDaoProvider.get(), budgetDaoProvider.get());
  }

  public static TransactionRepositoryImpl_Factory create(
      Provider<TransactionDao> transactionDaoProvider, Provider<BudgetDao> budgetDaoProvider) {
    return new TransactionRepositoryImpl_Factory(transactionDaoProvider, budgetDaoProvider);
  }

  public static TransactionRepositoryImpl newInstance(TransactionDao transactionDao,
      BudgetDao budgetDao) {
    return new TransactionRepositoryImpl(transactionDao, budgetDao);
  }
}
