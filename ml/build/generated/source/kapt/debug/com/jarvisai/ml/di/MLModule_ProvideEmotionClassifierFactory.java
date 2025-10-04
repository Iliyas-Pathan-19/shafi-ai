package com.jarvisai.ml.di;

import android.content.Context;
import com.jarvisai.ml.emotion.EmotionClassifier;
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
public final class MLModule_ProvideEmotionClassifierFactory implements Factory<EmotionClassifier> {
  private final Provider<Context> contextProvider;

  private MLModule_ProvideEmotionClassifierFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public EmotionClassifier get() {
    return provideEmotionClassifier(contextProvider.get());
  }

  public static MLModule_ProvideEmotionClassifierFactory create(Provider<Context> contextProvider) {
    return new MLModule_ProvideEmotionClassifierFactory(contextProvider);
  }

  public static EmotionClassifier provideEmotionClassifier(Context context) {
    return Preconditions.checkNotNullFromProvides(MLModule.INSTANCE.provideEmotionClassifier(context));
  }
}
