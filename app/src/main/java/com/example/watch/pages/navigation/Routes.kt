package com.example.watch.pages.navigation

enum class Routes(val route: String) {
    MY_MOVIES("MyMoviesPage"),
    SEARCH_MOVIES("SearchMoviesPage"),
    OBSERVE_SEARCH_MOVIES("ObserveSearchMoviesPage")
}

val INIT_ROUTE = Routes.MY_MOVIES.route