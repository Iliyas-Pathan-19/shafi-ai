package com.jarvisai.assistant.core.asr;

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
public final class VoskASR_Factory implements Factory<VoskASR> {
  private final Provider<Context> contextProvider;

  private VoskASR_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public VoskASR get() {
    return newInstance(contextProvider.get());
  }

  public static VoskASR_Factory create(Provider<Context> contextProvider) {
    return new VoskASR_Factory(contextProvider);
  }

  public static VoskASR newInstance(Context context) {
    return new VoskASR(context);
  }
}
