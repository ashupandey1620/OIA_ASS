package com.ashutosh.openinapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ashutosh.openinapp.Screens.SplashScreen
import com.ashutosh.openinapp.ui.theme.OpenInAppAssignmentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OpenInAppAssignmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize() ,
                    color = MaterialTheme.colorScheme.background
                ) {


                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "Splash") {

                        composable("Splash") {
                            SplashScreen(navController, this@MainActivity)
                        }

                        composable("HomeGraph") {
                            HomePage(this@MainActivity)
                        }


                    }

                }
            }
        }
    }
}

