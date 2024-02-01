package com.ashutosh.openinapp.Screens

import android.app.Activity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashutosh.openinapp.R


//

@Composable
fun LinkScreen(navController: NavHostController , activity: Activity) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(0xFF0E6FFF)
            )
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        )


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 20.dp) ,
            horizontalArrangement = Arrangement.SpaceBetween ,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "DashBoard" ,
                modifier = Modifier
                    .wrapContentWidth() ,
                color = Color.White ,
                textAlign = TextAlign.Center ,
                fontSize = 27.sp ,
                fontWeight = FontWeight.ExtraBold
            )


            Column(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White) ,
                verticalArrangement = Arrangement.Center ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Icon(painter = painterResource(id = R.drawable.mail) , contentDescription = "ok")

            }

        }


        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )




        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topEnd = 30.dp , topStart = 30.dp))
                .background(
                    Color.White
                ) ,
            verticalArrangement = Arrangement.Top ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            )

            GreetingSection()

            GraphSection()

            ModelDataList()


            ViewAnalytics()

            LinkSection()

        }
    }
}

@Composable
fun LinkSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(600.dp)
            .padding(20.dp)
            .background(
                Color.Cyan
            ) ,
        verticalArrangement = Arrangement.Top ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {



    }
}

@Composable
fun ViewAnalytics() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .padding(20.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(
                Color.Green
            ) ,
        colors = CardDefaults.cardColors(Color.White),
        border = BorderStroke(1.dp,Color.Gray)
    ) {



    }

}

@Composable
fun ModelDataList() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(20.dp)
            .background(
                Color.Blue
            ) ,
        verticalArrangement = Arrangement.Top ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {



    }

}


@Composable
fun GraphSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(20.dp)
            .clip(RoundedCornerShape(topEnd = 30.dp , topStart = 30.dp))
            .background(
                Color.Yellow
            ) ,
        verticalArrangement = Arrangement.Top ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {



    }

}


@Composable
fun GreetingSection() {
    Text(
        text = "Good Morning" ,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 20.dp),
        color = Color.Gray ,
        textAlign = TextAlign.Start ,
        fontSize = 22.sp ,
        fontWeight = FontWeight.Bold
    )


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = 20.dp) ,
        horizontalArrangement = Arrangement.Start ,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "Ajay Manva" ,
            modifier = Modifier
                .wrapContentWidth()
                .padding(end = 10.dp),
            color = Color.Black ,
            textAlign = TextAlign.Start ,
            fontSize = 26.sp ,
            fontWeight = FontWeight.ExtraBold
        )

        Icon(painter = painterResource(id = R.drawable.mail) , contentDescription = "ok",
            tint = Color.Black)


    }
}