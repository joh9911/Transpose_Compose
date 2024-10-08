package com.example.transpose.navigation.navhost

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.transpose.MainViewModel
import com.example.transpose.MediaViewModel
import com.example.transpose.navigation.navgraph.mainNavGraph
import com.example.transpose.navigation.viewmodel.NavigationViewModel

@Composable
fun MainNavHost(
    navController: NavHostController,
    startDestination: String,
    navigationViewModel: NavigationViewModel,
    mediaViewModel: MediaViewModel,
    mainViewModel: MainViewModel,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        mainNavGraph(
            mainViewModel = mainViewModel,
            navigationViewModel = navigationViewModel,
            mediaViewModel = mediaViewModel,
            onBackButtonClick =
            { navController.popBackStack() }
        )
    }
}