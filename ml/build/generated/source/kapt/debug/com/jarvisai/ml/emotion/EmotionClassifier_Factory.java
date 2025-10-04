package com.jarvisai.ml.emotion;

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
public final class EmotionClassifier_Factory implements Factory<EmotionClassifier> {
  private final Provider<Context> contextProvider;

  private EmotionClassifier_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public EmotionClassifier get() {
    return newInstance(contextProvider.get());
  }

  public static EmotionClassifier_Factory create(Provider<Context> contextProvider) {
    return new EmotionClassifier_Factory(contextProvider);
  }

  public static EmotionClassifier newInstance(Context context) {
    return new EmotionClassifier(context);
  }
}
