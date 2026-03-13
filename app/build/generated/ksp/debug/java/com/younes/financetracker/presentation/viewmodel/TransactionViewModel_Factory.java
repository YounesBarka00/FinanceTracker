package com.younes.financetracker.presentation.viewmodel;

import com.younes.financetracker.domain.repository.TransactionRepository;
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
public final class TransactionViewModel_Factory implements Factory<TransactionViewModel> {
  private final Provider<TransactionRepository> repositoryProvider;

  public TransactionViewModel_Factory(Provider<TransactionRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public TransactionViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static TransactionViewModel_Factory create(
      Provider<TransactionRepository> repositoryProvider) {
    return new TransactionViewModel_Factory(repositoryProvider);
  }

  public static TransactionViewModel newInstance(TransactionRepository repository) {
    return new TransactionViewModel(repository);
  }
}
