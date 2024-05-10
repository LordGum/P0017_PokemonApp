package com.example.pokemonapp.domain

import com.example.pokemonapp.domain.entities.Pokemon

interface Repository {

    suspend fun getList(offset: Int): List<Pokemon>

    suspend fun getPokemonInfo(id: Int): Pokemon
}