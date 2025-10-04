package com.jarvisai.data.entity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\tH\u00c6\u0003J\t\u0010\"\u001a\u00020\tH\u00c6\u0003J\t\u0010#\u001a\u00020\fH\u00c6\u0003J\t\u0010$\u001a\u00020\tH\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003Jq\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\'\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010)\u001a\u00020*H\u00d6\u0001J\t\u0010+\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0015R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\r\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006,"}, d2 = {"Lcom/jarvisai/data/entity/UserPreferences;", "", "id", "", "assistantName", "", "userNickname", "selectedVoice", "isSerEnabled", "", "isBatterySaverEnabled", "wakeWordSensitivity", "", "voiceCloneEnabled", "voiceClonePath", "isOnboardingComplete", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZFZLjava/lang/String;Z)V", "getAssistantName", "()Ljava/lang/String;", "getId", "()J", "()Z", "getSelectedVoice", "getUserNickname", "getVoiceCloneEnabled", "getVoiceClonePath", "getWakeWordSensitivity", "()F", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "data_debug"})
public final class UserPreferences {
    private final long id = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String assistantName = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String userNickname = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String selectedVoice = null;
    private final boolean isSerEnabled = false;
    private final boolean isBatterySaverEnabled = false;
    private final float wakeWordSensitivity = 0.0F;
    private final boolean voiceCloneEnabled = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String voiceClonePath = null;
    private final boolean isOnboardingComplete = false;
    
    public final long component1() {
        return 0L;
    }
    
    public final boolean component10() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final float component7() {
        return 0.0F;
    }
    
    public final boolean component8() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.data.entity.UserPreferences copy(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String assistantName, @org.jetbrains.annotations.Nullable()
    java.lang.String userNickname, @org.jetbrains.annotations.NotNull()
    java.lang.String selectedVoice, boolean isSerEnabled, boolean isBatterySaverEnabled, float wakeWordSensitivity, boolean voiceCloneEnabled, @org.jetbrains.annotations.Nullable()
    java.lang.String voiceClonePath, boolean isOnboardingComplete) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    public UserPreferences(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String assistantName, @org.jetbrains.annotations.Nullable()
    java.lang.String userNickname, @org.jetbrains.annotations.NotNull()
    java.lang.String selectedVoice, boolean isSerEnabled, boolean isBatterySaverEnabled, float wakeWordSensitivity, boolean voiceCloneEnabled, @org.jetbrains.annotations.Nullable()
    java.lang.String voiceClonePath, boolean isOnboardingComplete) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAssistantName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUserNickname() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSelectedVoice() {
        return null;
    }
    
    public final boolean isSerEnabled() {
        return false;
    }
    
    public final boolean isBatterySaverEnabled() {
        return false;
    }
    
    public final float getWakeWordSensitivity() {
        return 0.0F;
    }
    
    public final boolean getVoiceCloneEnabled() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getVoiceClonePath() {
        return null;
    }
    
    public final boolean isOnboardingComplete() {
        return false;
    }
    
    public UserPreferences() {
        super();
    }
}