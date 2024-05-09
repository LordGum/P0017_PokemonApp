package com.example.pokemonapp.presentation

import com.example.pokemonapp.domain.entities.Pokemon

sealed class MainScreenState {

    object Initial: MainScreenState()

    object Loading: MainScreenState()

    data class Success(val posts: List<Pokemon>): MainScreenState()

    data class Error(val exception: Exception): MainScreenState()
}