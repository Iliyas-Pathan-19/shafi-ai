# Consumer ProGuard rules for data module
# These rules will be applied to any module that depends on this library

# Keep all public classes and methods
-keep public class com.jarvisai.data.** { *; }

# Keep Hilt generated classes
-keep class com.jarvisai.data.di.** { *; }

# Keep repository classes
-keep class com.jarvisai.data.repository.** { *; }

# Keep entity classes
-keep class com.jarvisai.data.entity.** { *; }
