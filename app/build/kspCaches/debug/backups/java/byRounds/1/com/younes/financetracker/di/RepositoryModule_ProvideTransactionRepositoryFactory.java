package com.younes.financetracker.di;

import com.younes.financetracker.data.local.dao.BudgetDao;
import com.younes.financetracker.data.local.dao.TransactionDao;
import com.younes.financetracker.domain.repository.TransactionRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class RepositoryModule_ProvideTransactionRepositoryFactory implements Factory<TransactionRepository> {
  private final Provider<TransactionDao> transactionDaoProvider;

  private final Provider<BudgetDao> budgetDaoProvider;

  public RepositoryModule_ProvideTransactionRepositoryFactory(
      Provider<TransactionDao> transactionDaoProvider, Provider<BudgetDao> budgetDaoProvider) {
    this.transactionDaoProvider = transactionDaoProvider;
    this.budgetDaoProvider = budgetDaoProvider;
  }

  @Override
  public TransactionRepository get() {
    return provideTransactionRepository(transactionDaoProvider.get(), budgetDaoProvider.get());
  }

  public static RepositoryModule_ProvideTransactionRepositoryFactory create(
      Provider<TransactionDao> transactionDaoProvider, Provider<BudgetDao> budgetDaoProvider) {
    return new RepositoryModule_ProvideTransactionRepositoryFactory(transactionDaoProvider, budgetDaoProvider);
  }

  public static TransactionRepository provideTransactionRepository(TransactionDao transactionDao,
      BudgetDao budgetDao) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideTransactionRepository(transactionDao, budgetDao));
  }
}
