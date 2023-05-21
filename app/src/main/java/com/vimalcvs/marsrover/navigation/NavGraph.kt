package com.vimalcvs.marsrover.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vimalcvs.marsrover.navigation.Destinations.Home
import com.vimalcvs.marsrover.navigation.Destinations.Manifest
import com.vimalcvs.marsrover.ui.view.ManifestScreen
import com.vimalcvs.marsrover.ui.view.RoverList

@SuppressLint("RememberReturnType")
@Composable
fun SetupNavGraph(navController: NavHostController) {
    val actions = remember(navController) {
        Action(navController)
    }
    NavHost(
        navController = navController,
        startDestination = Home
    ) {
        composable(Home) {
            RoverList() { roverName ->
                actions.manifest(roverName)

            }
        }
        composable(Manifest) { backStackEntry ->
            ManifestScreen(
                roverName = backStackEntry.arguments?.getString("roverName"),
                marsRoverManifestViewModel = hiltViewModel()
            )
        }
    }
}