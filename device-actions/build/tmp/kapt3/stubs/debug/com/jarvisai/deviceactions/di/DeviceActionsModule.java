package com.jarvisai.deviceactions.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J:\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0012\u0010\u0012\u001a\u00020\r2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0013\u001a\u00020\u000b2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0014\u001a\u00020\u000f2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0015\u001a\u00020\u00112\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0016"}, d2 = {"Lcom/jarvisai/deviceactions/di/DeviceActionsModule;", "", "()V", "provideCallHandler", "Lcom/jarvisai/deviceactions/handler/CallHandler;", "context", "Landroid/content/Context;", "provideDeviceActionHandler", "Lcom/jarvisai/deviceactions/handler/DeviceActionHandler;", "callHandler", "messageHandler", "Lcom/jarvisai/deviceactions/handler/MessageHandler;", "mediaHandler", "Lcom/jarvisai/deviceactions/handler/MediaHandler;", "navigationHandler", "Lcom/jarvisai/deviceactions/handler/NavigationHandler;", "systemActionHandler", "Lcom/jarvisai/deviceactions/handler/SystemActionHandler;", "provideMediaHandler", "provideMessageHandler", "provideNavigationHandler", "provideSystemActionHandler", "device-actions_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DeviceActionsModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.jarvisai.deviceactions.di.DeviceActionsModule INSTANCE = null;
    
    private DeviceActionsModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.deviceactions.handler.CallHandler provideCallHandler(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.deviceactions.handler.MessageHandler provideMessageHandler(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.deviceactions.handler.MediaHandler provideMediaHandler(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.deviceactions.handler.NavigationHandler provideNavigationHandler(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.deviceactions.handler.SystemActionHandler provideSystemActionHandler(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.deviceactions.handler.DeviceActionHandler provideDeviceActionHandler(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.jarvisai.deviceactions.handler.CallHandler callHandler, @org.jetbrains.annotations.NotNull()
    com.jarvisai.deviceactions.handler.MessageHandler messageHandler, @org.jetbrains.annotations.NotNull()
    com.jarvisai.deviceactions.handler.MediaHandler mediaHandler, @org.jetbrains.annotations.NotNull()
    com.jarvisai.deviceactions.handler.NavigationHandler navigationHandler, @org.jetbrains.annotations.NotNull()
    com.jarvisai.deviceactions.handler.SystemActionHandler systemActionHandler) {
        return null;
    }
}