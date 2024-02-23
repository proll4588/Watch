package com.example.watch.pages.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.watch.pages.MyMoviesPage
import com.example.watch.pages.ObserveSearchMoviesPage
import com.example.watch.pages.SearchMoviesPage

@Composable
fun AppNavigationHost(navController: NavHostController) {
    NavHost(navController, startDestination = INIT_ROUTE) {
        composable(Routes.MY_MOVIES.route) {
            MyMoviesPage(onNavigationToSearchMoviesPage = {
                navController.navigate(
                    Routes.SEARCH_MOVIES.route
                )
            })
        }
        composable(Routes.SEARCH_MOVIES.route) {
            SearchMoviesPage(
                onNavigateBack = {
                    navController.navigate(Routes.MY_MOVIES.route)
                },
                onNavigateToObserveSearchMoviesPage = {
                    navController.navigate(Routes.OBSERVE_SEARCH_MOVIES.route)
                }
            )
        }
        composable(Routes.OBSERVE_SEARCH_MOVIES.route) {
            ObserveSearchMoviesPage(onNavigateBack = {
                navController.navigate(Routes.SEARCH_MOVIES.route)
            })
        }
    }
}