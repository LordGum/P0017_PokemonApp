package com.example.pokemonapp.domain

import com.example.pokemonapp.domain.entities.Pokemon
import com.example.pokemonapp.domain.entities.PokemonContainer

interface Repository {

    suspend fun getList(): List<PokemonContainer>

    suspend fun getPokemonInfo(id: Int): Pokemon
}