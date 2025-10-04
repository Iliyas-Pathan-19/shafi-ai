package com.jarvisai.data.di;

import android.content.Context;
import com.jarvisai.data.dao.UserPreferencesDao;
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
public final class DatabaseModule_ProvideUserPreferencesDaoFactory implements Factory<UserPreferencesDao> {
  private final Provider<Context> contextProvider;

  private DatabaseModule_ProvideUserPreferencesDaoFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public UserPreferencesDao get() {
    return provideUserPreferencesDao(contextProvider.get());
  }

  public static DatabaseModule_ProvideUserPreferencesDaoFactory create(
      Provider<Context> contextProvider) {
    return new DatabaseModule_ProvideUserPreferencesDaoFactory(contextProvider);
  }

  public static UserPreferencesDao provideUserPreferencesDao(Context context) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideUserPreferencesDao(context));
  }
}
