package com.vimalcvs.marsrover

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vimalcvs.marsrover.navigation.SetupNavGraph
import com.vimalcvs.marsrover.ui.theme.MarsRoversTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarsRoversTheme {

                navController = rememberNavController()

                SetupNavGraph(navController = navController)
            }
        }
    }
}
