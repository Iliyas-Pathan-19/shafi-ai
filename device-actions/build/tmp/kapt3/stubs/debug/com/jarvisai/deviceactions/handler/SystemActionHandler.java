package com.jarvisai.deviceactions.handler;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\fH\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J\b\u0010\u0015\u001a\u00020\fH\u0002J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\fH\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/jarvisai/deviceactions/handler/SystemActionHandler;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "audioManager$delegate", "Lkotlin/Lazy;", "adjustVolume", "Lcom/jarvisai/assistant/core/model/CommandResult;", "increase", "", "handleDeviceAction", "command", "Lcom/jarvisai/assistant/core/model/Command$DeviceAction;", "lockScreen", "muteVolume", "openLockScreenSettings", "takeScreenshot", "toggleBluetooth", "enable", "toggleWifi", "unlockScreen", "device-actions_debug"})
public final class SystemActionHandler {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy audioManager$delegate = null;
    
    @javax.inject.Inject()
    public SystemActionHandler(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    private final android.media.AudioManager getAudioManager() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.assistant.core.model.CommandResult handleDeviceAction(@org.jetbrains.annotations.NotNull()
    com.jarvisai.assistant.core.model.Command.DeviceAction command) {
        return null;
    }
    
    private final com.jarvisai.assistant.core.model.CommandResult lockScreen() {
        return null;
    }
    
    private final com.jarvisai.assistant.core.model.CommandResult openLockScreenSettings() {
        return null;
    }
    
    private final com.jarvisai.assistant.core.model.CommandResult unlockScreen() {
        return null;
    }
    
    private final com.jarvisai.assistant.core.model.CommandResult toggleWifi(boolean enable) {
        return null;
    }
    
    private final com.jarvisai.assistant.core.model.CommandResult toggleBluetooth(boolean enable) {
        return null;
    }
    
    private final com.jarvisai.assistant.core.model.CommandResult adjustVolume(boolean increase) {
        return null;
    }
    
    private final com.jarvisai.assistant.core.model.CommandResult muteVolume() {
        return null;
    }
    
    private final com.jarvisai.assistant.core.model.CommandResult takeScreenshot() {
        return null;
    }
}