package com.ashutosh.openinapp.Data

data class TabData (
    val title : String
)

val tabs = listOf(
    TabData(Tabs.TopLinks.value),
    TabData(Tabs.RecentLinks.value)
)

enum class Tabs (val value:String){
    TopLinks("Top Links"),
    RecentLinks("Recent Links")
}