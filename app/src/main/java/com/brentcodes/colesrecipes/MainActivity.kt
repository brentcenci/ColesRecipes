package com.brentcodes.colesrecipes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.brentcodes.colesrecipes.data.Repository
import com.brentcodes.colesrecipes.ui.screens.RecipeDetailView
import com.brentcodes.colesrecipes.ui.screens.RecipeListView
import com.brentcodes.colesrecipes.ui.screens.RecipeViewModel
import com.brentcodes.colesrecipes.ui.theme.ColesRecipesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ColesRecipesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val navController = rememberNavController()
                    val viewModel = RecipeViewModel(repository = Repository(context = LocalContext.current))

                    NavHost(navController = navController, startDestination = "list", modifier = Modifier.padding(innerPadding)) {
                        composable(route = "list") {
                            RecipeListView(
                                modifier = Modifier,
                                navController = navController,
                                viewModel = viewModel
                            )
                        }
                        composable(route = "details") {
                            RecipeDetailView(
                                modifier = Modifier,
                                navController = navController,
                                viewModel = viewModel
                            )
                        }
                    }
                }
            }
        }
    }
}