package com.jarvisai.deviceactions.di

import android.content.Context
import com.jarvisai.deviceactions.handler.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DeviceActionsModule {
    
    @Provides
    @Singleton
    fun provideCallHandler(@ApplicationContext context: Context): CallHandler {
        return CallHandler(context)
    }
    
    @Provides
    @Singleton
    fun provideMessageHandler(@ApplicationContext context: Context): MessageHandler {
        return MessageHandler(context)
    }
    
    @Provides
    @Singleton
    fun provideMediaHandler(@ApplicationContext context: Context): MediaHandler {
        return MediaHandler(context)
    }
    
    @Provides
    @Singleton
    fun provideNavigationHandler(@ApplicationContext context: Context): NavigationHandler {
        return NavigationHandler(context)
    }
    
    @Provides
    @Singleton
    fun provideSystemActionHandler(@ApplicationContext context: Context): SystemActionHandler {
        return SystemActionHandler(context)
    }
    
    @Provides
    @Singleton
    fun provideDeviceActionHandler(
        @ApplicationContext context: Context,
        callHandler: CallHandler,
        messageHandler: MessageHandler,
        mediaHandler: MediaHandler,
        navigationHandler: NavigationHandler,
        systemActionHandler: SystemActionHandler
    ): DeviceActionHandler {
        return DeviceActionHandlerImpl(
            context = context,
            callHandler = callHandler,
            messageHandler = messageHandler,
            mediaHandler = mediaHandler,
            navigationHandler = navigationHandler,
            systemActionHandler = systemActionHandler
        )
    }
}
