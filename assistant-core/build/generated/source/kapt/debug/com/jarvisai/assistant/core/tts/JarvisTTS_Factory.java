package com.jarvisai.assistant.core.tts;

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
public final class JarvisTTS_Factory implements Factory<JarvisTTS> {
  private final Provider<Context> contextProvider;

  private JarvisTTS_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public JarvisTTS get() {
    return newInstance(contextProvider.get());
  }

  public static JarvisTTS_Factory create(Provider<Context> contextProvider) {
    return new JarvisTTS_Factory(contextProvider);
  }

  public static JarvisTTS newInstance(Context context) {
    return new JarvisTTS(context);
  }
}
