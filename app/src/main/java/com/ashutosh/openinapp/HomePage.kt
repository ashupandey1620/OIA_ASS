package com.ashutosh.openinapp

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.unit.dp
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
            route = "link",
            title = "Links",
            selectedIcon = R.drawable.mail,
            hasNews = false,
        ),
        BottomNavigationItem(
            route = "course",
            title = "Courses",
            selectedIcon = R.drawable.magazine,
            hasNews = false,
        ),


        BottomNavigationItem(
            route = "add",
            title = "Add",
            selectedIcon = R.drawable.mail,
            hasNews = false,
        ),

        BottomNavigationItem(
            route = "campaign",
            title = "Campaign",
            selectedIcon = R.drawable.media,
            hasNews = false,
        ),

        BottomNavigationItem(
            route = "profile",
            title = "Profile",
            selectedIcon = R.drawable.profile,
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

            val bottomDestination = ((currentDestination?.route == "link")
                    || (currentDestination?.route == "course")
                    || (currentDestination?.route == "add")
                    || (currentDestination?.route == "campaign")
                    || (currentDestination?.route == "profile"))

            if (bottomDestination) {
                NavigationBar(containerColor = Color.White) {

                    items.forEachIndexed { index, item ->

                        NavigationBarItem(


                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color.Black,
                                selectedTextColor = Color.Black,
                                indicatorColor = Color.Transparent ,
                                unselectedIconColor = Color.Black,
                                unselectedTextColor = Color.Black
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
                                        color = Color.Black
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
        startDestination = "link"
    ) {

        composable(route = "link") {
            LinkScreen(navController, activity)
        }
        composable(route = "course") {
            CourseScreen(navController)
        }
        composable(route = "add") {
            AddScreen(navController)
        }
        composable(route = "campaign") {
            CampaignScreen(navController)
        }
        composable(route = "profile") {
            ProfileScreen(navController)
        }

    }
}
