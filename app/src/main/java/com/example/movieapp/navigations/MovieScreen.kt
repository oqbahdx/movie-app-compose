package com.example.movieapp.navigations

enum class MovieScreen {
    HomeScreen,
    DetailsScreen;

    companion object {
        fun fromRoute(route: String?): MovieScreen = when (route?.substringBefore('/')) {
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            null -> HomeScreen
            else -> throw  IllegalArgumentException("Routes : $route is not found")
        }
    }
}