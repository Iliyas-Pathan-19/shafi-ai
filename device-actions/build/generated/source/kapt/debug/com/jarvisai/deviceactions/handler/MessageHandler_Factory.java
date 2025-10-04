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
public final class MessageHandler_Factory implements Factory<MessageHandler> {
  private final Provider<Context> contextProvider;

  private MessageHandler_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public MessageHandler get() {
    return newInstance(contextProvider.get());
  }

  public static MessageHandler_Factory create(Provider<Context> contextProvider) {
    return new MessageHandler_Factory(contextProvider);
  }

  public static MessageHandler newInstance(Context context) {
    return new MessageHandler(context);
  }
}
