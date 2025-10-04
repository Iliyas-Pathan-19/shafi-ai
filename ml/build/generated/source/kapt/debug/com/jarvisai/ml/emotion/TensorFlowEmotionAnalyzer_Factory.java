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
public final class TensorFlowEmotionAnalyzer_Factory implements Factory<TensorFlowEmotionAnalyzer> {
  private final Provider<Context> contextProvider;

  private TensorFlowEmotionAnalyzer_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public TensorFlowEmotionAnalyzer get() {
    return newInstance(contextProvider.get());
  }

  public static TensorFlowEmotionAnalyzer_Factory create(Provider<Context> contextProvider) {
    return new TensorFlowEmotionAnalyzer_Factory(contextProvider);
  }

  public static TensorFlowEmotionAnalyzer newInstance(Context context) {
    return new TensorFlowEmotionAnalyzer(context);
  }
}
