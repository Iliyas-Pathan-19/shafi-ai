package com.jarvisai.assistant.core.di;

import android.content.Context;
import com.jarvisai.assistant.core.wakeword.WakeWordDetector;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class VoiceModule_ProvideWakeWordDetectorFactory implements Factory<WakeWordDetector> {
  private final Provider<Context> contextProvider;

  private VoiceModule_ProvideWakeWordDetectorFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public WakeWordDetector get() {
    return provideWakeWordDetector(contextProvider.get());
  }

  public static VoiceModule_ProvideWakeWordDetectorFactory create(
      Provider<Context> contextProvider) {
    return new VoiceModule_ProvideWakeWordDetectorFactory(contextProvider);
  }

  public static WakeWordDetector provideWakeWordDetector(Context context) {
    return Preconditions.checkNotNullFromProvides(VoiceModule.INSTANCE.provideWakeWordDetector(context));
  }
}
