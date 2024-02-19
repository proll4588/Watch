package com.example.watch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.watch.components.IconWithText
import com.example.watch.ui.theme.WatchTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WatchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        floatingActionButton = {
                            FloatingActionButton(onClick = { }) {
                                Icon(Icons.Default.Add, contentDescription = "Add")
                            }
                        },
                        topBar = {
                            TopAppBar(
                                colors = topAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    titleContentColor = MaterialTheme.colorScheme.primary
                                ),
                                actions = {
                                    IconButton(onClick = { /* do something */ }) {
                                        Icon(
                                            imageVector = Icons.Filled.Delete,
                                            contentDescription = "Localized description",
                                            tint = MaterialTheme.colorScheme.primary
                                        )
                                    }
                                },
                                title = {
                                    Text("Movies to Watch")
                                }
                            )
                        },
                    ) { innerPadding ->
                        Column(
                            modifier = Modifier
                                .padding(innerPadding)
                                .fillMaxHeight(),
                            verticalArrangement = Arrangement.Center,
                        ) {
//                            VoidFilmList()
//                            TestMovieCard()
                            AppNavigationHost()
                        }
                    }
                }
            }
        }
    }
}

@Preview(name = "Void list")
@Composable
fun VoidFilmList() {
    IconWithText(
        imageVector = Icons.Default.Movie,
        text = "There are currently no movies in your watch list. Tap the button below to get started!"
    )
}


val testImgUrl =
    "https://m.media-amazon.com/images/M/MV5BNjRiNmNjMmMtN2U2Yi00ODgxLTk3OTMtMmI1MTI1NjYyZTEzXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_SX300.jpg"

@Composable
fun MovieCard(imgUrl: String, title: String, year: Int) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(all = 0.dp)
            .clickable { /* Do */ },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Row {
            AsyncImage(
                model = imgUrl,
                contentDescription = "Movie $title",
                modifier = Modifier
                    .width(90.dp)
                    .fillMaxHeight(),
                alignment = Alignment.TopStart
            )
            Column {
                Text(text = title, style = MaterialTheme.typography.headlineMedium)
                Text(text = year.toString())
            }
        }
    }
}

@Preview(name = "test Movie card")
@Composable
fun TestMovieCard() {
    MovieCard(imgUrl = testImgUrl, title = "Test title", year = 2048)
}


// 3 страницы
// MyMoviesPage
// SearchMoviesPage
// ObserveSearchMoviesPage

@Composable
fun MyMoviesPage(onNavigationToSearchMoviesPage: () -> Unit) {
    Column {
        Text(text = "MyMoviesPage")
        Button(onClick = onNavigationToSearchMoviesPage) {
            Text(text = "Navigate to SearchMoviesPage")
        }
    }

}

@Composable
fun SearchMoviesPage(
    onNavigateBack: () -> Unit,
    onNavigateToObserveSearchMoviesPage: () -> Unit
) {
    Column {
        Text(text = "SearchMoviesPage")
        Button(onClick = onNavigateBack) {
            Text(text = "Navigate back")
        }
        Button(onClick = onNavigateToObserveSearchMoviesPage) {
            Text(text = "Navigate to ObserveSearchMoviesPage")
        }
    }

}

@Composable
fun ObserveSearchMoviesPage(
    onNavigateBack: () -> Unit
) {
    Column {
        Text(text = "ObserveSearchMoviesPage")
        Button(onClick = onNavigateBack) {
            Text(text = "Navigate back")
        }
    }
}


enum class ROUTE_NAMES(val route: String) {
    MY_MOVIES("MyMoviesPage"),
    SEARCH_MOVIES("SearchMoviesPage"),
    OBSERVE_SEARCH_MOVIES("ObserveSearchMoviesPage")
}

val INIT_ROUTE = ROUTE_NAMES.MY_MOVIES.route

@Composable
fun AppNavigationHost() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = INIT_ROUTE) {
        composable(ROUTE_NAMES.MY_MOVIES.route) {
            MyMoviesPage(onNavigationToSearchMoviesPage = {
                navController.navigate(
                    ROUTE_NAMES.SEARCH_MOVIES.route
                )
            })
        }
        composable(ROUTE_NAMES.SEARCH_MOVIES.route) {
            SearchMoviesPage(
                onNavigateBack = {
                    navController.navigate(ROUTE_NAMES.MY_MOVIES.route)
                },
                onNavigateToObserveSearchMoviesPage = {
                    navController.navigate(ROUTE_NAMES.OBSERVE_SEARCH_MOVIES.route)
                }
            )
        }
        composable(ROUTE_NAMES.OBSERVE_SEARCH_MOVIES.route) {
            ObserveSearchMoviesPage(onNavigateBack = {
                navController.navigate(ROUTE_NAMES.SEARCH_MOVIES.route)
            })
        }
    }
}