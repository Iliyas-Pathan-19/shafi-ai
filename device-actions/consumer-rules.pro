# Consumer ProGuard rules for device-actions module
# These rules will be applied to any module that depends on this library

# Keep all public classes and methods
-keep public class com.jarvisai.deviceactions.** { *; }

# Keep Hilt generated classes
-keep class com.jarvisai.deviceactions.di.** { *; }

# Keep handler classes
-keep class com.jarvisai.deviceactions.handler.** { *; }
