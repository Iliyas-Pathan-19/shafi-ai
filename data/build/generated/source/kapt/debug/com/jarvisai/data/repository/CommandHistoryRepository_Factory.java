package com.jarvisai.data.repository;

import com.jarvisai.data.dao.CommandHistoryDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class CommandHistoryRepository_Factory implements Factory<CommandHistoryRepository> {
  private final Provider<CommandHistoryDao> commandHistoryDaoProvider;

  private CommandHistoryRepository_Factory(Provider<CommandHistoryDao> commandHistoryDaoProvider) {
    this.commandHistoryDaoProvider = commandHistoryDaoProvider;
  }

  @Override
  public CommandHistoryRepository get() {
    return newInstance(commandHistoryDaoProvider.get());
  }

  public static CommandHistoryRepository_Factory create(
      Provider<CommandHistoryDao> commandHistoryDaoProvider) {
    return new CommandHistoryRepository_Factory(commandHistoryDaoProvider);
  }

  public static CommandHistoryRepository newInstance(CommandHistoryDao commandHistoryDao) {
    return new CommandHistoryRepository(commandHistoryDao);
  }
}
