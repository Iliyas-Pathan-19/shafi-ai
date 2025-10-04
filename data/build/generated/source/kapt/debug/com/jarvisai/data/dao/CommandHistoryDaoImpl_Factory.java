package com.jarvisai.data.dao;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class CommandHistoryDaoImpl_Factory implements Factory<CommandHistoryDaoImpl> {
  @Override
  public CommandHistoryDaoImpl get() {
    return newInstance();
  }

  public static CommandHistoryDaoImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CommandHistoryDaoImpl newInstance() {
    return new CommandHistoryDaoImpl();
  }

  private static final class InstanceHolder {
    static final CommandHistoryDaoImpl_Factory INSTANCE = new CommandHistoryDaoImpl_Factory();
  }
}
