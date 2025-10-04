package com.jarvisai.assistant.core.di;

import android.content.Context;
import com.jarvisai.assistant.core.voice.VoiceCloneRecorder;
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
public final class VoiceModule_ProvideVoiceCloneRecorderFactory implements Factory<VoiceCloneRecorder> {
  private final Provider<Context> contextProvider;

  private VoiceModule_ProvideVoiceCloneRecorderFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public VoiceCloneRecorder get() {
    return provideVoiceCloneRecorder(contextProvider.get());
  }

  public static VoiceModule_ProvideVoiceCloneRecorderFactory create(
      Provider<Context> contextProvider) {
    return new VoiceModule_ProvideVoiceCloneRecorderFactory(contextProvider);
  }

  public static VoiceCloneRecorder provideVoiceCloneRecorder(Context context) {
    return Preconditions.checkNotNullFromProvides(VoiceModule.INSTANCE.provideVoiceCloneRecorder(context));
  }
}
