package com.jarvisai.deviceactions.handler;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
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
public final class DeviceActionHandlerImpl_Factory implements Factory<DeviceActionHandlerImpl> {
  private final Provider<Context> contextProvider;

  private final Provider<CallHandler> callHandlerProvider;

  private final Provider<MessageHandler> messageHandlerProvider;

  private final Provider<MediaHandler> mediaHandlerProvider;

  private final Provider<NavigationHandler> navigationHandlerProvider;

  private final Provider<SystemActionHandler> systemActionHandlerProvider;

  private DeviceActionHandlerImpl_Factory(Provider<Context> contextProvider,
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
  public DeviceActionHandlerImpl get() {
    return newInstance(contextProvider.get(), callHandlerProvider.get(), messageHandlerProvider.get(), mediaHandlerProvider.get(), navigationHandlerProvider.get(), systemActionHandlerProvider.get());
  }

  public static DeviceActionHandlerImpl_Factory create(Provider<Context> contextProvider,
      Provider<CallHandler> callHandlerProvider, Provider<MessageHandler> messageHandlerProvider,
      Provider<MediaHandler> mediaHandlerProvider,
      Provider<NavigationHandler> navigationHandlerProvider,
      Provider<SystemActionHandler> systemActionHandlerProvider) {
    return new DeviceActionHandlerImpl_Factory(contextProvider, callHandlerProvider, messageHandlerProvider, mediaHandlerProvider, navigationHandlerProvider, systemActionHandlerProvider);
  }

  public static DeviceActionHandlerImpl newInstance(Context context, CallHandler callHandler,
      MessageHandler messageHandler, MediaHandler mediaHandler, NavigationHandler navigationHandler,
      SystemActionHandler systemActionHandler) {
    return new DeviceActionHandlerImpl(context, callHandler, messageHandler, mediaHandler, navigationHandler, systemActionHandler);
  }
}
