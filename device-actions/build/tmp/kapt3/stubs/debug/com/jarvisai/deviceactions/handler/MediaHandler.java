package com.jarvisai.deviceactions.handler;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/jarvisai/deviceactions/handler/MediaHandler;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "handlePlayMedia", "Lcom/jarvisai/assistant/core/model/CommandResult;", "command", "Lcom/jarvisai/assistant/core/model/Command$PlayMedia;", "isAppInstalled", "", "packageName", "", "playAnyMedia", "playMusic", "playOnYouTube", "query", "playPodcast", "playVideo", "device-actions_debug"})
public final class MediaHandler {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    @javax.inject.Inject()
    public MediaHandler(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.assistant.core.model.CommandResult handlePlayMedia(@org.jetbrains.annotations.NotNull()
    com.jarvisai.assistant.core.model.Command.PlayMedia command) {
        return null;
    }
    
    private final com.jarvisai.assistant.core.model.CommandResult playMusic(com.jarvisai.assistant.core.model.Command.PlayMedia command) {
        return null;
    }
    
    private final com.jarvisai.assistant.core.model.CommandResult playVideo(com.jarvisai.assistant.core.model.Command.PlayMedia command) {
        return null;
    }
    
    private final com.jarvisai.assistant.core.model.CommandResult playPodcast(com.jarvisai.assistant.core.model.Command.PlayMedia command) {
        return null;
    }
    
    private final com.jarvisai.assistant.core.model.CommandResult playAnyMedia(com.jarvisai.assistant.core.model.Command.PlayMedia command) {
        return null;
    }
    
    private final com.jarvisai.assistant.core.model.CommandResult playOnYouTube(java.lang.String query) {
        return null;
    }
    
    private final boolean isAppInstalled(java.lang.String packageName) {
        return false;
    }
}