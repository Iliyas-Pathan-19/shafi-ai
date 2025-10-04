package com.jarvisai.deviceactions.handler;

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
public final class MediaHandler_Factory implements Factory<MediaHandler> {
  private final Provider<Context> contextProvider;

  private MediaHandler_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public MediaHandler get() {
    return newInstance(contextProvider.get());
  }

  public static MediaHandler_Factory create(Provider<Context> contextProvider) {
    return new MediaHandler_Factory(contextProvider);
  }

  public static MediaHandler newInstance(Context context) {
    return new MediaHandler(context);
  }
}
