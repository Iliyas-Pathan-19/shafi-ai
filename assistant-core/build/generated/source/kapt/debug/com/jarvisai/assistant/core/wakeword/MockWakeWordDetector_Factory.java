package com.jarvisai.assistant.core.wakeword;

import android.content.Context;
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
public final class MockWakeWordDetector_Factory implements Factory<MockWakeWordDetector> {
  private final Provider<Context> contextProvider;

  private MockWakeWordDetector_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public MockWakeWordDetector get() {
    return newInstance(contextProvider.get());
  }

  public static MockWakeWordDetector_Factory create(Provider<Context> contextProvider) {
    return new MockWakeWordDetector_Factory(contextProvider);
  }

  public static MockWakeWordDetector newInstance(Context context) {
    return new MockWakeWordDetector(context);
  }
}
