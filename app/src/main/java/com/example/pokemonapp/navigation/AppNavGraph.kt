package com.example.pokemonapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.pokemonapp.domain.entities.Pokemon
import com.google.gson.Gson


@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    mainScreenContent: @Composable () -> Unit,
    detailScreenContent: @Composable (Pokemon) -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.MainScreen.route
    ) {

        composable(Screen.MainScreen.route) {
            mainScreenContent()
        }
        composable(
            route = Screen.DetailScreen.route,
            arguments = listOf(
                navArgument(Screen.POKEMON) {
                    type = NavType.StringType
                }
            )
        ) {
            val pokemonJson = it.arguments?.getString(Screen.POKEMON) ?: ""
            val pokemon = Gson().fromJson(pokemonJson, Pokemon::class.java)
            detailScreenContent(pokemon)
        }
    }
}