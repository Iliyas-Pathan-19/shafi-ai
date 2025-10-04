package com.jarvisai.deviceactions.di;

import android.content.Context;
import com.jarvisai.deviceactions.handler.CallHandler;
import com.jarvisai.deviceactions.handler.DeviceActionHandler;
import com.jarvisai.deviceactions.handler.MediaHandler;
import com.jarvisai.deviceactions.handler.MessageHandler;
import com.jarvisai.deviceactions.handler.NavigationHandler;
import com.jarvisai.deviceactions.handler.SystemActionHandler;
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
public final class DeviceActionsModule_ProvideDeviceActionHandlerFactory implements Factory<DeviceActionHandler> {
  private final Provider<Context> contextProvider;

  private final Provider<CallHandler> callHandlerProvider;

  private final Provider<MessageHandler> messageHandlerProvider;

  private final Provider<MediaHandler> mediaHandlerProvider;

  private final Provider<NavigationHandler> navigationHandlerProvider;

  private final Provider<SystemActionHandler> systemActionHandlerProvider;

  private DeviceActionsModule_ProvideDeviceActionHandlerFactory(Provider<Context> contextProvider,
      Provider<CallHandler> callHandlerProvider, Provider<MessageHandler> messageHandlerProvider,
      Provider<MediaHandler> mediaHandlerProvider,
      Provider<NavigationHandler> navigationHandlerProvider,
      Provider<SystemActionHandler> systemActionHandlerProvider) {
    this.contextProvider = contextProvider;
    this.callHandlerProvider = callHandlerProvider;
    this.messageHandlerProvider = messageHandlerProvider;
    this.mediaHandlerProvider = mediaHandlerProvider;
    this.navigationHandlerProvider = navigationHandlerProvider;
    this.systemActionHandlerProvider = systemActionHandlerProvider;
  }

  @Override
  public DeviceActionHandler get() {
    return provideDeviceActionHandler(contextProvider.get(), callHandlerProvider.get(), messageHandlerProvider.get(), mediaHandlerProvider.get(), navigationHandlerProvider.get(), systemActionHandlerProvider.get());
  }

  public static DeviceActionsModule_ProvideDeviceActionHandlerFactory create(
      Provider<Context> contextProvider, Provider<CallHandler> callHandlerProvider,
      Provider<MessageHandler> messageHandlerProvider, Provider<MediaHandler> mediaHandlerProvider,
      Provider<NavigationHandler> navigationHandlerProvider,
      Provider<SystemActionHandler> systemActionHandlerProvider) {
    return new DeviceActionsModule_ProvideDeviceActionHandlerFactory(contextProvider, callHandlerProvider, messageHandlerProvider, mediaHandlerProvider, navigationHandlerProvider, systemActionHandlerProvider);
  }

  public static DeviceActionHandler provideDeviceActionHandler(Context context,
      CallHandler callHandler, MessageHandler messageHandler, MediaHandler mediaHandler,
      NavigationHandler navigationHandler, SystemActionHandler systemActionHandler) {
    return Preconditions.checkNotNullFromProvides(DeviceActionsModule.INSTANCE.provideDeviceActionHandler(context, callHandler, messageHandler, mediaHandler, navigationHandler, systemActionHandler));
  }
}
