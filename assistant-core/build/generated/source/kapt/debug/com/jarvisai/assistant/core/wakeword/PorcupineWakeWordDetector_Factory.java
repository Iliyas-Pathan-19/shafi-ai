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
public final class PorcupineWakeWordDetector_Factory implements Factory<PorcupineWakeWordDetector> {
  private final Provider<Context> contextProvider;

  private PorcupineWakeWordDetector_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public PorcupineWakeWordDetector get() {
    return newInstance(contextProvider.get());
  }

  public static PorcupineWakeWordDetector_Factory create(Provider<Context> contextProvider) {
    return new PorcupineWakeWordDetector_Factory(contextProvider);
  }

  public static PorcupineWakeWordDetector newInstance(Context context) {
    return new PorcupineWakeWordDetector(context);
  }
}
