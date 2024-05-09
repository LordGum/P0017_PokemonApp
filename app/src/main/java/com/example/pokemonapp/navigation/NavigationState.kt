package com.example.pokemonapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pokemonapp.domain.entities.Pokemon

class NavigationState(
    val navHostController: NavHostController
) {
    fun navigateToDetailScreen(pokemon: Pokemon) {
        navHostController.navigate(Screen.DetailScreen.getArgs(pokemon))
    }
}

@Composable
fun rememberNavigationState(
    navHostController: NavHostController = rememberNavController()
): NavigationState {
    return remember {
        NavigationState(navHostController)
    }
}