package com.jarvisai.assistant.core.service;

import com.jarvisai.assistant.core.actions.DeviceActionHandler;
import com.jarvisai.assistant.core.asr.VoskASR;
import com.jarvisai.assistant.core.emotion.EmotionAnalyzer;
import com.jarvisai.assistant.core.parser.IntentParser;
import com.jarvisai.assistant.core.tts.JarvisTTS;
import com.jarvisai.assistant.core.wakeword.WakeWordDetector;
import com.jarvisai.data.repository.CommandHistoryRepository;
import com.jarvisai.data.repository.UserPreferencesRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;

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
public final class VoiceAssistantService_MembersInjector implements MembersInjector<VoiceAssistantService> {
  private final Provider<IntentParser> intentParserProvider;

  private final Provider<CommandHistoryRepository> commandHistoryRepositoryProvider;

  private final Provider<UserPreferencesRepository> userPreferencesRepositoryProvider;

  private final Provider<VoskASR> voskASRProvider;

  private final Provider<JarvisTTS> jarvisTTSProvider;

  private final Provider<EmotionAnalyzer> emotionClassifierProvider;

  private final Provider<DeviceActionHandler> deviceActionHandlerProvider;

  private final Provider<WakeWordDetector> wakeWordDetectorProvider;

  private VoiceAssistantService_MembersInjector(Provider<IntentParser> intentParserProvider,
      Provider<CommandHistoryRepository> commandHistoryRepositoryProvider,
      Provider<UserPreferencesRepository> userPreferencesRepositoryProvider,
      Provider<VoskASR> voskASRProvider, Provider<JarvisTTS> jarvisTTSProvider,
      Provider<EmotionAnalyzer> emotionClassifierProvider,
      Provider<DeviceActionHandler> deviceActionHandlerProvider,
      Provider<WakeWordDetector> wakeWordDetectorProvider) {
    this.intentParserProvider = intentParserProvider;
    this.commandHistoryRepositoryProvider = commandHistoryRepositoryProvider;
    this.userPreferencesRepositoryProvider = userPreferencesRepositoryProvider;
    this.voskASRProvider = voskASRProvider;
    this.jarvisTTSProvider = jarvisTTSProvider;
    this.emotionClassifierProvider = emotionClassifierProvider;
    this.deviceActionHandlerProvider = deviceActionHandlerProvider;
    this.wakeWordDetectorProvider = wakeWordDetectorProvider;
  }

  @Override
  public void injectMembers(VoiceAssistantService instance) {
    injectIntentParser(instance, intentParserProvider.get());
    injectCommandHistoryRepository(instance, commandHistoryRepositoryProvider.get());
    injectUserPreferencesRepository(instance, userPreferencesRepositoryProvider.get());
    injectVoskASR(instance, voskASRProvider.get());
    injectJarvisTTS(instance, jarvisTTSProvider.get());
    injectEmotionClassifier(instance, emotionClassifierProvider.get());
    injectDeviceActionHandler(instance, deviceActionHandlerProvider.get());
    injectWakeWordDetector(instance, wakeWordDetectorProvider.get());
  }

  public static MembersInjector<VoiceAssistantService> create(
      Provider<IntentParser> intentParserProvider,
      Provider<CommandHistoryRepository> commandHistoryRepositoryProvider,
      Provider<UserPreferencesRepository> userPreferencesRepositoryProvider,
      Provider<VoskASR> voskASRProvider, Provider<JarvisTTS> jarvisTTSProvider,
      Provider<EmotionAnalyzer> emotionClassifierProvider,
      Provider<DeviceActionHandler> deviceActionHandlerProvider,
      Provider<WakeWordDetector> wakeWordDetectorProvider) {
    return new VoiceAssistantService_MembersInjector(intentParserProvider, commandHistoryRepositoryProvider, userPreferencesRepositoryProvider, voskASRProvider, jarvisTTSProvider, emotionClassifierProvider, deviceActionHandlerProvider, wakeWordDetectorProvider);
  }

  @InjectedFieldSignature("com.jarvisai.assistant.core.service.VoiceAssistantService.intentParser")
  public static void injectIntentParser(VoiceAssistantService instance, IntentParser intentParser) {
    instance.intentParser = intentParser;
  }

  @InjectedFieldSignature("com.jarvisai.assistant.core.service.VoiceAssistantService.commandHistoryRepository")
  public static void injectCommandHistoryRepository(VoiceAssistantService instance,
      CommandHistoryRepository commandHistoryRepository) {
    instance.commandHistoryRepository = commandHistoryRepository;
  }

  @InjectedFieldSignature("com.jarvisai.assistant.core.service.VoiceAssistantService.userPreferencesRepository")
  public static void injectUserPreferencesRepository(VoiceAssistantService instance,
      UserPreferencesRepository userPreferencesRepository) {
    instance.userPreferencesRepository = userPreferencesRepository;
  }

  @InjectedFieldSignature("com.jarvisai.assistant.core.service.VoiceAssistantService.voskASR")
  public static void injectVoskASR(VoiceAssistantService instance, VoskASR voskASR) {
    instance.voskASR = voskASR;
  }

  @InjectedFieldSignature("com.jarvisai.assistant.core.service.VoiceAssistantService.jarvisTTS")
  public static void injectJarvisTTS(VoiceAssistantService instance, JarvisTTS jarvisTTS) {
    instance.jarvisTTS = jarvisTTS;
  }

  @InjectedFieldSignature("com.jarvisai.assistant.core.service.VoiceAssistantService.emotionClassifier")
  public static void injectEmotionClassifier(VoiceAssistantService instance,
      EmotionAnalyzer emotionClassifier) {
    instance.emotionClassifier = emotionClassifier;
  }

  @InjectedFieldSignature("com.jarvisai.assistant.core.service.VoiceAssistantService.deviceActionHandler")
  public static void injectDeviceActionHandler(VoiceAssistantService instance,
      DeviceActionHandler deviceActionHandler) {
    instance.deviceActionHandler = deviceActionHandler;
  }

  @InjectedFieldSignature("com.jarvisai.assistant.core.service.VoiceAssistantService.wakeWordDetector")
  public static void injectWakeWordDetector(VoiceAssistantService instance,
      WakeWordDetector wakeWordDetector) {
    instance.wakeWordDetector = wakeWordDetector;
  }
}
