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
public final class NavigationHandler_Factory implements Factory<NavigationHandler> {
  private final Provider<Context> contextProvider;

  private NavigationHandler_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public NavigationHandler get() {
    return newInstance(contextProvider.get());
  }

  public static NavigationHandler_Factory create(Provider<Context> contextProvider) {
    return new NavigationHandler_Factory(contextProvider);
  }

  public static NavigationHandler newInstance(Context context) {
    return new NavigationHandler(context);
  }
}
