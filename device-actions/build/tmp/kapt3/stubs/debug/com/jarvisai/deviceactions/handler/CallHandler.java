package com.jarvisai.deviceactions.handler;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/jarvisai/deviceactions/handler/CallHandler;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContactPhoneNumber", "", "contactName", "handleCall", "Lcom/jarvisai/assistant/core/model/CommandResult;", "command", "Lcom/jarvisai/assistant/core/model/Command$Call;", "hasCallPermission", "", "hasContactsPermission", "makeCall", "phoneNumber", "device-actions_debug"})
public final class CallHandler {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    @javax.inject.Inject()
    public CallHandler(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.assistant.core.model.CommandResult handleCall(@org.jetbrains.annotations.NotNull()
    com.jarvisai.assistant.core.model.Command.Call command) {
        return null;
    }
    
    private final boolean hasCallPermission() {
        return false;
    }
    
    private final java.lang.String getContactPhoneNumber(java.lang.String contactName) {
        return null;
    }
    
    private final boolean hasContactsPermission() {
        return false;
    }
    
    private final com.jarvisai.assistant.core.model.CommandResult makeCall(java.lang.String phoneNumber, com.jarvisai.assistant.core.model.Command.Call command) {
        return null;
    }
}