package com.jarvisai.deviceactions.di;

import android.content.Context;
import com.jarvisai.deviceactions.handler.MessageHandler;
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
public final class DeviceActionsModule_ProvideMessageHandlerFactory implements Factory<MessageHandler> {
  private final Provider<Context> contextProvider;

  private DeviceActionsModule_ProvideMessageHandlerFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public MessageHandler get() {
    return provideMessageHandler(contextProvider.get());
  }

  public static DeviceActionsModule_ProvideMessageHandlerFactory create(
      Provider<Context> contextProvider) {
    return new DeviceActionsModule_ProvideMessageHandlerFactory(contextProvider);
  }

  public static MessageHandler provideMessageHandler(Context context) {
    return Preconditions.checkNotNullFromProvides(DeviceActionsModule.INSTANCE.provideMessageHandler(context));
  }
}
