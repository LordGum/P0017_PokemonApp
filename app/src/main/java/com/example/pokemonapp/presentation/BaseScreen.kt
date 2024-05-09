package com.example.pokemonapp.presentation

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import com.example.pokemonapp.navigation.AppNavGraph
import com.example.pokemonapp.navigation.rememberNavigationState
import com.example.pokemonapp.presentation.detail.DetailScreen
import com.example.pokemonapp.presentation.main.MainScreen
import com.example.pokemonapp.presentation.main.MainViewModel

@Composable
fun BaseScreen() {
    val navigationState = rememberNavigationState()

    AppNavGraph(
        navHostController = navigationState.navHostController,
        mainScreenContent = {
            val viewModel: MainViewModel = ViewModelProvider(
                LocalContext.current as ComponentActivity
            )[MainViewModel::class.java]
            MainScreen(
                viewModel = viewModel,
                onPokemonClickListener = {
                    navigationState.navigateToDetailScreen(it)
                }
            )
        },
        detailScreenContent = { pokemon ->
            DetailScreen(pokemon)
        }
    )
}