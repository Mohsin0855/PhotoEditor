package com.example.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class FeatureItem(val name: String, val icon: ImageVector, val color: List<Color>)

val featureList = listOf(
    FeatureItem("Transformation", Icons.Rounded.Transform, listOf(Color(0xFFFFA726), Color(0xFFFF7043))),
    FeatureItem("Edit", Icons.Rounded.Edit, listOf(Color(0xFF42A5F5), Color(0xFF1E88E5))),
    FeatureItem("Reshape", Icons.Rounded.Face, listOf(Color(0xFFAB47BC), Color(0xFF8E24AA))),
    FeatureItem("Makeup", Icons.Rounded.FaceRetouchingNatural, listOf(Color(0xFFEC407A), Color(0xFFD81B60))),
    FeatureItem("Retouch", Icons.Rounded.AutoFixHigh, listOf(Color(0xFF26A69A), Color(0xFF00897B))),
    FeatureItem("Filters", Icons.Rounded.FilterVintage, listOf(Color(0xFF5C6BC0), Color(0xFF3949AB))),
    FeatureItem("Adjust", Icons.Rounded.Tune, listOf(Color(0xFF8D6E63), Color(0xFF6D4C41))),
    FeatureItem("Blur", Icons.Rounded.BlurOn, listOf(Color(0xFF29B6F6), Color(0xFF039BE5))),
    FeatureItem("Background", Icons.Rounded.Image, listOf(Color(0xFF9CCC65), Color(0xFF7CB342))),
    FeatureItem("Ratios", Icons.Rounded.AspectRatio, listOf(Color(0xFFFFCA28), Color(0xFFFFB300))),
    FeatureItem("Draw", Icons.Rounded.Brush, listOf(Color(0xFFEF5350), Color(0xFFE53935))),
    FeatureItem("Text", Icons.Rounded.TextFields, listOf(Color(0xFF78909C), Color(0xFF546E7A))),
    FeatureItem("Stickers", Icons.Rounded.EmojiEmotions, listOf(Color(0xFFFFEE58), Color(0xFFFDD835))),
    FeatureItem("Glitch", Icons.Rounded.GraphicEq, listOf(Color(0xFFD4E157), Color(0xFFC0CA33))),
    FeatureItem("Collage", Icons.Rounded.Dashboard, listOf(Color(0xFFBCAAA4), Color(0xFFA1887F)))
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("PhotoEditor", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1E1E2C),
                    titleContentColor = Color.White
                )
            )
        },
        containerColor = Color(0xFF1E1E2C)
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(featureList) { feature ->
                FeatureCard(feature)
            }
        }
    }
}

@Composable
fun FeatureCard(feature: FeatureItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable { /* Handle click */ }
            .background(Color(0xFF2A2A3D))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Brush.linearGradient(feature.color)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = feature.icon,
                contentDescription = feature.name,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = feature.name,
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            maxLines = 1
        )
    }
}
