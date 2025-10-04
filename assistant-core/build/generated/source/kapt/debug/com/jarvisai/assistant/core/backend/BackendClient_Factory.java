package com.jarvisai.assistant.core.backend;

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
public final class BackendClient_Factory implements Factory<BackendClient> {
  @Override
  public BackendClient get() {
    return newInstance();
  }

  public static BackendClient_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static BackendClient newInstance() {
    return new BackendClient();
  }

  private static final class InstanceHolder {
    static final BackendClient_Factory INSTANCE = new BackendClient_Factory();
  }
}
