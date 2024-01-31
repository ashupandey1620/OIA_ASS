package com.ashutosh.openinapp.Screens

import android.content.Context
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavHostController
import com.ashutosh.openinapp.MainActivity
import com.ashutosh.openinapp.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController , context: MainActivity) {



    val alpha = remember {
        Animatable(0f)
    }


    LaunchedEffect(key1 = true) {
        alpha.animateTo(1f,
            animationSpec = tween(300)
        )
        delay(1000)


            navController.popBackStack()
            navController.navigate("HomeGraph")



    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF1E1E1E) ,
                        Color(0xFF1E1E1E)
                    ) ,
                    start = Offset(0.0979f , 0f) ,
                    end = Offset(0.2064f , 0f)
                )
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {




        Text(
            text ="OpenInApp",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .padding(horizontal = 30.dp),
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
            fontWeight = FontWeight.ExtraBold
        )

    }
}



private fun onBoardingIsFinished(context: MainActivity): Boolean {
    val sharedPreferences = context.getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
    return sharedPreferences.getBoolean("isFinished", false)

}