package com.example.photoeditor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.home.HomeScreen
import com.example.photoeditor.navigation.HomeRoute
import com.example.photoeditor.navigation.SplashRoute
import com.example.photoeditor.ui.theme.PhotoEditorTheme
import com.example.splash.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PhotoEditorTheme {
                val navController = rememberNavController()
                
                NavHost(
                    navController = navController,
                    startDestination = SplashRoute
                ) {
                    composable<SplashRoute> {
                        SplashScreen(
                            onSplashComplete = {
                                navController.navigate(HomeRoute) {
                                    popUpTo<SplashRoute> { inclusive = true }
                                }
                            }
                        )
                    }
                    composable<HomeRoute> {
                        HomeScreen()
                    }
                }
            }
        }
    }
}