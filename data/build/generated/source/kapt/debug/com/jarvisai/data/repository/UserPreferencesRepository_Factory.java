package com.jarvisai.data.repository;

import com.jarvisai.data.dao.UserPreferencesDao;
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
public final class UserPreferencesRepository_Factory implements Factory<UserPreferencesRepository> {
  private final Provider<UserPreferencesDao> userPreferencesDaoProvider;

  private UserPreferencesRepository_Factory(
      Provider<UserPreferencesDao> userPreferencesDaoProvider) {
    this.userPreferencesDaoProvider = userPreferencesDaoProvider;
  }

  @Override
  public UserPreferencesRepository get() {
    return newInstance(userPreferencesDaoProvider.get());
  }

  public static UserPreferencesRepository_Factory create(
      Provider<UserPreferencesDao> userPreferencesDaoProvider) {
    return new UserPreferencesRepository_Factory(userPreferencesDaoProvider);
  }

  public static UserPreferencesRepository newInstance(UserPreferencesDao userPreferencesDao) {
    return new UserPreferencesRepository(userPreferencesDao);
  }
}
