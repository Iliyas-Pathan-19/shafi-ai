package com.jarvisai.deviceactions.handler;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/jarvisai/deviceactions/handler/MessageHandler;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContactPhoneNumber", "", "contactName", "handleMessage", "Lcom/jarvisai/assistant/core/model/CommandResult;", "command", "Lcom/jarvisai/assistant/core/model/Command$Message;", "isAppInstalled", "", "packageName", "sendGenericMessage", "sendInstagramMessage", "sendSms", "sendTelegramMessage", "sendTwitterMessage", "sendWhatsAppMessage", "device-actions_debug"})
public final class MessageHandler {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    @javax.inject.Inject()
    public MessageHandler(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.assistant.core.model.CommandResult handleMessage(@org.jetbrains.annotations.NotNull()
    com.jarvisai.assistant.core.model.Command.Message command) {
        return null;
    }
    
    private final com.jarvisai.assistant.core.model.CommandResult sendSms(com.jarvisai.assistant.core.model.Command.Message command) {
        return null;
    }
    
    private final com.jarvisai.assistant.core.model.CommandResult sendWhatsAppMessage(com.jarvisai.assistant.core.model.Command.Message command) {
        return null;
    }
    
    private final com.jarvisai.assistant.core.model.CommandResult sendTelegramMessage(com.jarvisai.assistant.core.model.Command.Message command) {
        return null;
    }
    
    private final com.jarvisai.assistant.core.model.CommandResult sendInstagramMessage(com.jarvisai.assistant.core.model.Command.Message command) {
        return null;
    }
    
    private final com.jarvisai.assistant.core.model.CommandResult sendTwitterMessage(com.jarvisai.assistant.core.model.Command.Message command) {
        return null;
    }
    
    private final com.jarvisai.assistant.core.model.CommandResult sendGenericMessage(com.jarvisai.assistant.core.model.Command.Message command) {
        return null;
    }
    
    private final java.lang.String getContactPhoneNumber(java.lang.String contactName) {
        return null;
    }
    
    private final boolean isAppInstalled(java.lang.String packageName) {
        return false;
    }
}