package com.jarvisai.data.dao;

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
public final class UserPreferencesDaoImpl_Factory implements Factory<UserPreferencesDaoImpl> {
  private final Provider<Context> contextProvider;

  private UserPreferencesDaoImpl_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public UserPreferencesDaoImpl get() {
    return newInstance(contextProvider.get());
  }

  public static UserPreferencesDaoImpl_Factory create(Provider<Context> contextProvider) {
    return new UserPreferencesDaoImpl_Factory(contextProvider);
  }

  public static UserPreferencesDaoImpl newInstance(Context context) {
    return new UserPreferencesDaoImpl(context);
  }
}
