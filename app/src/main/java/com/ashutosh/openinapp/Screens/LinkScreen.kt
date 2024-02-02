package com.ashutosh.openinapp.Screens

import android.app.Activity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.PlotType
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.LineType
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import com.ashutosh.openinapp.Data.tabs
import com.ashutosh.openinapp.R
import java.time.Month


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

            ViewAllLinks()

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
            )

            TalkWithUs()

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
            )

            FAQ()

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )


        }
    }
}

@Composable
fun FAQ() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .padding(horizontal = 20.dp)
            .padding(vertical = 3.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(
                Color.Green
            ) ,
        colors = CardDefaults.cardColors(Color(0xFFe8f1ff)),
        border = BorderStroke(2.dp,Color(0xFFc4ddff))
    ) {

        Row(modifier=Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {

            Icon(modifier = Modifier
                .padding(horizontal = 20.dp)
                .size(30.dp)
                ,painter = painterResource(id = R.drawable.faq) , contentDescription = "ok",
               )

            Text(
                text = "Frequently Asked Questions" ,
                modifier = Modifier
                    .wrapContentWidth()
                    ,
                color = Black ,
                textAlign = TextAlign.Start ,
                fontSize = 18.sp ,
                fontWeight = FontWeight.Medium
            )

        }

    }
}

@Composable
fun TalkWithUs() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .padding(horizontal = 20.dp)
            .padding(vertical = 3.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(
                Green
            ) ,
        colors = CardDefaults.cardColors(Color(0xFFe0f0e2)),
        border = BorderStroke(2.dp,Color(0xFFdbefde))
    ) {

        Row(modifier=Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {

            Icon(modifier = Modifier
                .padding(horizontal = 20.dp)
                .size(30.dp)
                ,painter = painterResource(id = R.drawable.whatsapp) , contentDescription = "ok",
            )

            Text(
                text = "Talk With Us" ,
                modifier = Modifier
                    .wrapContentWidth() ,
                color = Black ,
                textAlign = TextAlign.Start ,
                fontSize = 18.sp ,
                fontWeight = FontWeight.Medium
            )

        }

    }
}

@Composable
fun ViewAllLinks() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 20.dp)
            .padding(vertical = 3.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(
                Green
            ),

        colors = CardDefaults.cardColors(Color.White),
        border = BorderStroke(1.dp,Color.Gray)
    ) {

        Row(modifier=Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {

            Icon(modifier = Modifier.size(30.dp)
                ,painter = painterResource(id = R.drawable.mail) , contentDescription = "ok",
            )

            Text(
                text = "View All Links" ,
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(start = 10.dp),
                color = Black ,
                textAlign = TextAlign.Start ,
                fontSize = 18.sp ,
                fontWeight = FontWeight.Medium
            )

        }

    }
}
@Preview
@Composable
fun LinkSection() {


    var selectedIndex by remember {
        mutableStateOf(0)
    }

    Row (modifier = Modifier
        .fillMaxWidth()
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {


        Column(
            modifier = Modifier
                .width(300.dp)
                .padding(horizontal = 20.dp)
                .padding(vertical = 3.dp) ,
            verticalArrangement = Arrangement.Top ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            TabRow(selectedTabIndex = selectedIndex ,
                modifier = Modifier.fillMaxWidth() ,
                contentColor = Blue ,
                indicator = {} ,
                divider = {}
            ) {

                tabs.forEachIndexed { index , tabData ->


                    if (index == selectedIndex) {
                        Tab(
                            selected = index == selectedIndex ,
                            onClick = { selectedIndex = index } ,
                            text = {
                                Text(
                                    text = tabData.title ,
                                    style = TextStyle(fontSize = 14.sp)
                                )
                            } ,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(25.dp))
                                .background(Color(0xFF0e6fff)) ,
                            selectedContentColor = White ,
                            unselectedContentColor = Gray

                        )
                    } else {
                        Tab(
                            selected = index == selectedIndex ,
                            onClick = { selectedIndex = index } ,
                            text = {
                                Text(
                                    text = tabData.title ,
                                    style = TextStyle(fontSize = 14.sp)
                                )
                            } ,
                            selectedContentColor = White ,
                            unselectedContentColor = Gray

                        )
                    }
                }
            }


        }

        Column(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White) ,
            verticalArrangement = Arrangement.Center ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(imageVector = Icons.Filled.Search
                , contentDescription = "ok")

        }
    }
}

@Composable
fun ViewAnalytics() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 20.dp)
            .padding(vertical = 3.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(
                Color.Green
            ) ,
        colors = CardDefaults.cardColors(Color.White),
        border = BorderStroke(1.dp,Color.Gray)
    ) {

        Row(modifier=Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {

            Icon(modifier = Modifier.size(30.dp)
                ,painter = painterResource(id = R.drawable.arrows) , contentDescription = "ok",
            )

            Text(
                text = "View Analytics" ,
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(start = 10.dp),
                color = Black ,
                textAlign = TextAlign.Start ,
                fontSize = 18.sp ,
                fontWeight = FontWeight.Bold
            )

        }

    }

}

@Composable
fun ModelDataList() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(horizontal = 20.dp)
            .padding(vertical = 3.dp)
            ,
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        var clicks = "293"
        var topLocation = "Kanpur"
        var social  = "Instagram"
        var bestTime = "Best Time"

        Row(modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())) {

            ModelDataListItem(R.drawable.click, clicks,   "Todays Click")
            ModelDataListItem(R.drawable.location, topLocation,"Top Location")
            ModelDataListItem(R.drawable.social, social,  "Top Source")
            ModelDataListItem(R.drawable.click, bestTime,   "Best Time")

        }


    }

}


@Composable
fun ModelDataListItem(icon: Int , data: String , str: String) {

    Column(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .padding(vertical = 3.dp)
            .width(100.dp)
            .fillMaxHeight()
            .clip(RoundedCornerShape(5.dp))

        ,
        verticalArrangement = Arrangement.SpaceAround ,
        horizontalAlignment = Alignment.Start
    ) {

        Icon(modifier = Modifier
            .padding(start = 20.dp)
            .size(30.dp)

            ,painter = painterResource(id = icon) , contentDescription = "ok",
        )



            Text(
                text = data ,
                modifier = Modifier
                    .padding(start = 15.dp)
                    .wrapContentWidth() ,
                color = Black ,
                textAlign = TextAlign.Start ,
                fontSize = 16.sp ,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = str ,
                modifier = Modifier
                    .padding(start = 15.dp)
                    .wrapContentWidth()
                    ,
                color = Gray ,
                textAlign = TextAlign.Start ,
                fontSize = 12.sp ,
                fontWeight = FontWeight.Bold
            )

    }

    }



@Composable
fun GraphSection() {

//    val refreshDataset = remember{ mutableIntStateOf(0) }
//
//    val modelProducer = remember {ChartEntryModelProducer()}
//
//    val dataSetForModel = remember {
//        mutableStateListOf(listOf<FloatEntry>())
//    }
//
//    val dataSetLineSpec = remember {
//        arrayListOf<LineChart.LineSpec>()
//    }
//
//    val scrollStater = rememberChartScrollState()




//    LaunchedEffect(key1 = refreshDataset.intValue){
//        dataSetForModel.clear()
//        dataSetLineSpec.clear()
//        var xPos = 0f
//        val dataPoints = arrayListOf<FloatEntry>()
//
//        dataSetLineSpec.add(
//            LineChart.LineSpec(
//                lineColor = Green.toArgb(),
//                lineBackgroundShader = DynamicShaders.fromBrush(
//                    brush = Brush.verticalGradient(
//                        listOf(
//                            Green.copy(com.patrykandpatrick.vico.core.DefaultAlpha.LINE_BACKGROUND_SHADER_START),
//                            Green.copy(com.patrykandpatrick.vico.core.DefaultAlpha.LINE_BACKGROUND_SHADER_END)
//                        )
//                    )
//                )
//            )
//        )
//
//        for (i in 1..100){
//            val randomFloat = (1..1000).random().toFloat()
//            dataPoints.add(FloatEntry(x=xPos,y=randomFloat))
//            xPos+=1f
//        }
//
//
//            dataSetForModel.add(dataPoints)
//
//        modelProducer.setEntries(dataSetForModel)
//
//    }


//    val chartEntryModel = entryModelOf(4f, 12f, 8f, 16f)


    val pointsData: List<Point> =
        listOf(Point(0f, 40f), Point(1f, 90f), Point(2f, 0f), Point(3f, 60f), Point(4f, 10f),
            Point(5f, 40f), Point(6f, 90f), Point(7f, 0f), Point(8f, 60f), Point(9f, 10f),
            Point(10f, 90f), Point(11f, 0f), Point(12f, 60f))


    val yAxisData = AxisData.Builder()
        .axisStepSize(50.dp)
        .steps(4)
        .labelData { i -> (i*25).toString() }
        .labelAndAxisLinePadding(30.dp)
        .build()



    val xAxisData = AxisData.Builder()
        .axisStepSize(35.dp)
        .steps(12)
        .labelAndAxisLinePadding(20.dp)
        .labelData { i ->
            if(i==0)
                "0"
            else
                Month.values()[i-1].toString().take(3)
        }.build()


    val lineChartData = LineChartData(
        linePlotData = LinePlotData(
            lines = listOf(
                Line(
                    dataPoints = pointsData,
                    lineStyle = LineStyle(color = Color(0xFF3184ff),
                        blendMode = BlendMode.Lighten,
                        width = 1f,

                        ) ,
                    IntersectionPoint(radius = 0.dp) ,
                    SelectionHighlightPoint() ,
                    ShadowUnderLine(color = Blue) ,
                    SelectionHighlightPopUp(labelSize = 10.sp,
                        labelColor = Blue)
                )
            ),
            plotType = PlotType.Line
        ) ,
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines(enableHorizontalLines = true,
            enableVerticalLines = false) ,
        backgroundColor = Color.White
    )


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            ,
        verticalArrangement = Arrangement.Top ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card( modifier = Modifier
            .fillMaxWidth()
            .height(300.dp))
        {



//            if (dataSetForModel.isNotEmpty()){

            LineChart(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                lineChartData = lineChartData
            )
//            }






        }

//        TextButton(modifier = Modifier.fillMaxWidth()
//            ,onClick = { refreshDataset.intValue++ }) {
//
//            Text(text = "Refresh")
            
//        }




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