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
public final class CallHandler_Factory implements Factory<CallHandler> {
  private final Provider<Context> contextProvider;

  private CallHandler_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public CallHandler get() {
    return newInstance(contextProvider.get());
  }

  public static CallHandler_Factory create(Provider<Context> contextProvider) {
    return new CallHandler_Factory(contextProvider);
  }

  public static CallHandler newInstance(Context context) {
    return new CallHandler(context);
  }
}
