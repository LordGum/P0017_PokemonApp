package com.example.pokemonapp.presentation.main

import com.example.pokemonapp.domain.entities.Pokemon

sealed class MainScreenState {

    object Initial: MainScreenState()

    object Loading: MainScreenState()

    data class Success(
        val posts: List<Pokemon>,
        val nextDataIsLoading: Boolean = false
    ): MainScreenState()

    data class Error(val exception: Exception): MainScreenState()
}