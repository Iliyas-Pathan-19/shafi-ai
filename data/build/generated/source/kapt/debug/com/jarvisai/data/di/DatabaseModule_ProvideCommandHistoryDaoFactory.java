package com.jarvisai.data.di;

import com.jarvisai.data.dao.CommandHistoryDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class DatabaseModule_ProvideCommandHistoryDaoFactory implements Factory<CommandHistoryDao> {
  @Override
  public CommandHistoryDao get() {
    return provideCommandHistoryDao();
  }

  public static DatabaseModule_ProvideCommandHistoryDaoFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CommandHistoryDao provideCommandHistoryDao() {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideCommandHistoryDao());
  }

  private static final class InstanceHolder {
    static final DatabaseModule_ProvideCommandHistoryDaoFactory INSTANCE = new DatabaseModule_ProvideCommandHistoryDaoFactory();
  }
}
