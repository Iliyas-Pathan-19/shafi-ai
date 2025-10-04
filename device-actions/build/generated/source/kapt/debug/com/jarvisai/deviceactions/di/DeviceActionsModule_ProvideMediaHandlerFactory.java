package com.jarvisai.deviceactions.di;

import android.content.Context;
import com.jarvisai.deviceactions.handler.MediaHandler;
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
public final class DeviceActionsModule_ProvideMediaHandlerFactory implements Factory<MediaHandler> {
  private final Provider<Context> contextProvider;

  private DeviceActionsModule_ProvideMediaHandlerFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public MediaHandler get() {
    return provideMediaHandler(contextProvider.get());
  }

  public static DeviceActionsModule_ProvideMediaHandlerFactory create(
      Provider<Context> contextProvider) {
    return new DeviceActionsModule_ProvideMediaHandlerFactory(contextProvider);
  }

  public static MediaHandler provideMediaHandler(Context context) {
    return Preconditions.checkNotNullFromProvides(DeviceActionsModule.INSTANCE.provideMediaHandler(context));
  }
}
