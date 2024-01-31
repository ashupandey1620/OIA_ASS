package com.ashutosh.openinapp

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextMotion
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ashutosh.openinapp.Screens.AddScreen
import com.ashutosh.openinapp.Screens.CampaignScreen
import com.ashutosh.openinapp.Screens.CourseScreen
import com.ashutosh.openinapp.Screens.LinkScreen
import com.ashutosh.openinapp.Screens.ProfileScreen


data class BottomNavigationItem(
    val route: String ,
    val title: String ,
    val selectedIcon: Int ,
    val hasNews: Boolean ,
    val badgeCount: Int? = null
)


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomePage(activity: Activity , navController: NavHostController = rememberNavController()) {
    BottomNavigationBar(navController = navController, activity)
}


@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(navController: NavHostController , activity: Activity) {





    val items = listOf(
        BottomNavigationItem(
            route = "home",
            title = "Home",
            selectedIcon = R.drawable.mail,
            hasNews = false,
        ),
        BottomNavigationItem(
            route = "event",
            title = "Events",
            selectedIcon = R.drawable.mail,
            hasNews = false,
        ),


        BottomNavigationItem(
            route = "profile",
            title = "Profile",
            selectedIcon = R.drawable.mail,
            hasNews = false,
        ),
    )

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    Scaffold(
        bottomBar = {

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            val bottomDestination = ((currentDestination?.route == "home")
                    || (currentDestination?.route == "event")
                    || (currentDestination?.route == "profile"))

            if (bottomDestination) {
                NavigationBar(containerColor = Color(0xFF222222)) {
                    items.forEachIndexed { index, item ->

                        NavigationBarItem(

                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color.White,
                                selectedTextColor = Color.White,
                                indicatorColor = Color(0xFF4A4458) ,
                                unselectedIconColor = Color.White,
                                unselectedTextColor = Color.White
                            ),

                            selected = selectedItemIndex == index,

                            alwaysShowLabel = true,

                            onClick = {
                                selectedItemIndex = index
                                navController.navigate(item.route) {
                                    popUpTo(item.route)
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },

                            label = {
                                Text(
                                    text = item.title,
                                    style = TextStyle(
                                        textMotion = TextMotion.Animated,
                                        fontFamily = FontFamily.Default,
                                        fontWeight = FontWeight.W500,
                                        color = Color.White
                                    ) ,
                                )
                            },




                            icon = {
                                BadgedBox(badge = {
                                    if (item.badgeCount != null) {
                                        Badge {
                                            Text(text = item.badgeCount.toString())
                                        }
                                    } else if (item.hasNews) {
                                        Badge()
                                    }
                                }) {
                                    Icon(
                                        painter = painterResource(id = item.selectedIcon) ,
                                        tint = Color.White,
                                        contentDescription = item.title
                                    )
                                }
                            }
                        )
                    }
                }
            }

        }
    ) {
        MainPageNavigation(navController = navController, activity)
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainPageNavigation(navController: NavHostController , activity: Activity) {
    NavHost(
        navController = navController,
        route = "HomeGraph",
        startDestination = "home"
    ) {

        composable(route = "home") {
            LinkScreen(navController, activity)
        }
        composable(route = "event") {
            CourseScreen(navController)
        }
        composable(route = "profile") {
            AddScreen(navController)
        }

        composable(route = "profile") {
            CampaignScreen(navController)
        }

        composable(route = "profile") {
            ProfileScreen(navController)
        }

    }
}
