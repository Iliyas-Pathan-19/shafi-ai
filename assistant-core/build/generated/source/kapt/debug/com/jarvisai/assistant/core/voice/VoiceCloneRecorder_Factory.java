package com.jarvisai.assistant.core.voice;

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
public final class VoiceCloneRecorder_Factory implements Factory<VoiceCloneRecorder> {
  private final Provider<Context> contextProvider;

  private VoiceCloneRecorder_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public VoiceCloneRecorder get() {
    return newInstance(contextProvider.get());
  }

  public static VoiceCloneRecorder_Factory create(Provider<Context> contextProvider) {
    return new VoiceCloneRecorder_Factory(contextProvider);
  }

  public static VoiceCloneRecorder newInstance(Context context) {
    return new VoiceCloneRecorder(context);
  }
}
