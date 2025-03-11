package com.brentcodes.colesrecipes

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.brentcodes.colesrecipes.ui.Screen
import com.brentcodes.colesrecipes.ui.screens.RecipeDetailView
import com.brentcodes.colesrecipes.ui.screens.RecipeDetailViewModel
import com.brentcodes.colesrecipes.ui.screens.RecipeListView
import com.brentcodes.colesrecipes.ui.screens.RecipeListViewModel
import com.brentcodes.colesrecipes.ui.theme.ColesRecipesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ColesRecipesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val navController = rememberNavController()
                    val recipeListViewModel: RecipeListViewModel = hiltViewModel()
                    val recipeDetailViewModel: RecipeDetailViewModel = hiltViewModel()

                    var orientation by remember { mutableIntStateOf(Configuration.ORIENTATION_PORTRAIT) }
                    val configuration = LocalConfiguration.current

                    LaunchedEffect(configuration) {
                        snapshotFlow { configuration.orientation }
                            .collect { orientation = it }
                    }

                    NavHost(navController = navController, startDestination = Screen.List.route, modifier = Modifier.fillMaxSize().padding(innerPadding)) {
                        composable(route = Screen.List.route) {
                            RecipeListView(
                                orientation = orientation,
                                viewModel = recipeListViewModel,
                                onNavigateToDetails = {
                                    navController.navigate(route = Screen.Details.route)
                                }
                            )
                        }
                        composable(route = Screen.Details.route) {
                            RecipeDetailView(
                                viewModel = recipeDetailViewModel
                            )
                        }
                    }
                }
            }
        }
    }
}