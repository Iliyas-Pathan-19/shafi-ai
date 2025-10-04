package com.jarvisai.assistant.core.emotion;

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
public final class EmotionAnalyzerImpl_Factory implements Factory<EmotionAnalyzerImpl> {
  private final Provider<Context> contextProvider;

  private EmotionAnalyzerImpl_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public EmotionAnalyzerImpl get() {
    return newInstance(contextProvider.get());
  }

  public static EmotionAnalyzerImpl_Factory create(Provider<Context> contextProvider) {
    return new EmotionAnalyzerImpl_Factory(contextProvider);
  }

  public static EmotionAnalyzerImpl newInstance(Context context) {
    return new EmotionAnalyzerImpl(context);
  }
}
