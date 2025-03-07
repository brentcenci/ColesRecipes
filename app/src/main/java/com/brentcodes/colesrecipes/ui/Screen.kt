package com.brentcodes.colesrecipes.ui

sealed class Screen(val route: String) {
    data object List : Screen("list")
    data object Details : Screen("details")
}