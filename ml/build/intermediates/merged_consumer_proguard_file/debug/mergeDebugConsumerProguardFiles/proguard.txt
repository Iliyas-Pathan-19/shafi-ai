# Consumer ProGuard rules for ml module
# These rules will be applied to any module that depends on this library

# Keep all public classes and methods
-keep public class com.jarvisai.ml.** { *; }

# Keep Hilt generated classes
-keep class com.jarvisai.ml.di.** { *; }

# Keep emotion analysis classes
-keep class com.jarvisai.ml.emotion.** { *; }
