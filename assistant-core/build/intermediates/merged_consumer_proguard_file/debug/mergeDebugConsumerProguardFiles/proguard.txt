# Consumer ProGuard rules for assistant-core module
# These rules will be applied to any module that depends on this library

# Keep all public classes and methods
-keep public class com.jarvisai.assistant.core.** { *; }

# Keep Hilt generated classes
-keep class com.jarvisai.assistant.core.di.** { *; }

# Keep service classes
-keep class com.jarvisai.assistant.core.service.** { *; }

# Keep model classes
-keep class com.jarvisai.assistant.core.model.** { *; }
