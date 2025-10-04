package com.jarvisai.assistant.core.backend;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0007\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0018H\u0086@\u00a2\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0007\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/jarvisai/assistant/core/backend/BackendClient;", "", "()V", "TAG", "", "generateMockChatResponse", "Lcom/jarvisai/assistant/core/backend/ChatResponse;", "request", "Lcom/jarvisai/assistant/core/backend/ChatRequest;", "generateMockResearchResults", "", "Lcom/jarvisai/assistant/core/backend/ResearchResult;", "Lcom/jarvisai/assistant/core/backend/ResearchRequest;", "generateMockSERResponse", "Lcom/jarvisai/assistant/core/backend/SERResponse;", "generateMockVoiceCloneResponse", "Lcom/jarvisai/assistant/core/backend/VoiceCloneResponse;", "Lcom/jarvisai/assistant/core/backend/VoiceCloneRequest;", "isHealthy", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "llmChat", "(Lcom/jarvisai/assistant/core/backend/ChatRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ser", "Lcom/jarvisai/assistant/core/backend/SERRequest;", "(Lcom/jarvisai/assistant/core/backend/SERRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "voiceCloneSynthesis", "(Lcom/jarvisai/assistant/core/backend/VoiceCloneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "webResearch", "(Lcom/jarvisai/assistant/core/backend/ResearchRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "assistant-core_debug"})
public final class BackendClient {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "BackendClient";
    
    @javax.inject.Inject()
    public BackendClient() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object llmChat(@org.jetbrains.annotations.NotNull()
    com.jarvisai.assistant.core.backend.ChatRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.jarvisai.assistant.core.backend.ChatResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object webResearch(@org.jetbrains.annotations.NotNull()
    com.jarvisai.assistant.core.backend.ResearchRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.jarvisai.assistant.core.backend.ResearchResult>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object ser(@org.jetbrains.annotations.NotNull()
    com.jarvisai.assistant.core.backend.SERRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.jarvisai.assistant.core.backend.SERResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object voiceCloneSynthesis(@org.jetbrains.annotations.NotNull()
    com.jarvisai.assistant.core.backend.VoiceCloneRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.jarvisai.assistant.core.backend.VoiceCloneResponse> $completion) {
        return null;
    }
    
    private final com.jarvisai.assistant.core.backend.ChatResponse generateMockChatResponse(com.jarvisai.assistant.core.backend.ChatRequest request) {
        return null;
    }
    
    private final java.util.List<com.jarvisai.assistant.core.backend.ResearchResult> generateMockResearchResults(com.jarvisai.assistant.core.backend.ResearchRequest request) {
        return null;
    }
    
    private final com.jarvisai.assistant.core.backend.SERResponse generateMockSERResponse() {
        return null;
    }
    
    private final com.jarvisai.assistant.core.backend.VoiceCloneResponse generateMockVoiceCloneResponse(com.jarvisai.assistant.core.backend.VoiceCloneRequest request) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object isHealthy(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
}