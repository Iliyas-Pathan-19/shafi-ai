package com.jarvisai.assistant.core.di;

import android.content.Context;
import com.jarvisai.assistant.core.tts.JarvisTTS;
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
public final class VoiceModule_ProvideJarvisTTSFactory implements Factory<JarvisTTS> {
  private final Provider<Context> contextProvider;

  private VoiceModule_ProvideJarvisTTSFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public JarvisTTS get() {
    return provideJarvisTTS(contextProvider.get());
  }

  public static VoiceModule_ProvideJarvisTTSFactory create(Provider<Context> contextProvider) {
    return new VoiceModule_ProvideJarvisTTSFactory(contextProvider);
  }

  public static JarvisTTS provideJarvisTTS(Context context) {
    return Preconditions.checkNotNullFromProvides(VoiceModule.INSTANCE.provideJarvisTTS(context));
  }
}
