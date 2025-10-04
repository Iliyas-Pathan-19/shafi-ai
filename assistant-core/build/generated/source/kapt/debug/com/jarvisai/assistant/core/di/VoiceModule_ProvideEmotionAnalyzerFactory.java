package com.jarvisai.assistant.core.di;

import android.content.Context;
import com.jarvisai.assistant.core.emotion.EmotionAnalyzer;
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
public final class VoiceModule_ProvideEmotionAnalyzerFactory implements Factory<EmotionAnalyzer> {
  private final Provider<Context> contextProvider;

  private VoiceModule_ProvideEmotionAnalyzerFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public EmotionAnalyzer get() {
    return provideEmotionAnalyzer(contextProvider.get());
  }

  public static VoiceModule_ProvideEmotionAnalyzerFactory create(
      Provider<Context> contextProvider) {
    return new VoiceModule_ProvideEmotionAnalyzerFactory(contextProvider);
  }

  public static EmotionAnalyzer provideEmotionAnalyzer(Context context) {
    return Preconditions.checkNotNullFromProvides(VoiceModule.INSTANCE.provideEmotionAnalyzer(context));
  }
}
