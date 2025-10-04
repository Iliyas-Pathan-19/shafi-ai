package com.jarvisai.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person

@Composable
fun JarvisAvatar(
    isListening: Boolean = false,
    isProcessing: Boolean = false,
    modifier: Modifier = Modifier
) {
    val primaryColor = MaterialTheme.colorScheme.primary
    val surfaceColor = MaterialTheme.colorScheme.surface
    
    // Animation for listening state
    val scale by animateFloatAsState(
        targetValue = if (isListening) 1.2f else 1f,
        animationSpec = tween(durationMillis = 300),
        label = "avatar_scale"
    )
    
    // Pulsing animation for processing
    val infiniteTransition = rememberInfiniteTransition(label = "pulse_transition")
    val pulseAlpha by infiniteTransition.animateFloat(
        initialValue = 0.3f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse_alpha"
    )
    
    Box(
        modifier = modifier
            .size(120.dp)
            .scale(scale),
        contentAlignment = Alignment.Center
    ) {
        // Outer ring for listening state
        if (isListening) {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(
                        primaryColor.copy(alpha = 0.2f)
                    )
            )
        }
        
        // Processing ring
        if (isProcessing) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(
                        primaryColor.copy(alpha = pulseAlpha * 0.3f)
                    )
            )
        }
        
        // Main avatar circle
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(
                    if (isListening || isProcessing) primaryColor else surfaceColor
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Jarvis Avatar",
                modifier = Modifier.size(40.dp),
                tint = if (isListening || isProcessing) {
                    MaterialTheme.colorScheme.onPrimary
                } else {
                    MaterialTheme.colorScheme.onSurface
                }
            )
        }
    }
}

@Composable
fun VoiceVisualization(
    isActive: Boolean,
    modifier: Modifier = Modifier
) {
    val primaryColor = MaterialTheme.colorScheme.primary
    
    if (!isActive) return
    
    val infiniteTransition = rememberInfiniteTransition(label = "voice_visualization")
    
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(5) { index ->
            val animationDelay = index * 100
            val height by infiniteTransition.animateFloat(
                initialValue = 4f,
                targetValue = 20f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = 600,
                        delayMillis = animationDelay,
                        easing = EaseInOut
                    ),
                    repeatMode = RepeatMode.Reverse
                ),
                label = "bar_height_$index"
            )
            
            Box(
                modifier = Modifier
                    .width(3.dp)
                    .height(height.dp)
                    .background(
                        color = primaryColor,
                        shape = CircleShape
                    )
            )
        }
    }
}
