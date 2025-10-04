package com.jarvisai.assistant.core.parser;

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
public final class IntentParser_Factory implements Factory<IntentParser> {
  @Override
  public IntentParser get() {
    return newInstance();
  }

  public static IntentParser_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static IntentParser newInstance() {
    return new IntentParser();
  }

  private static final class InstanceHolder {
    static final IntentParser_Factory INSTANCE = new IntentParser_Factory();
  }
}
