package com.example.pokemonapp.domain

import com.example.pokemonapp.domain.entities.Pokemon

interface Repository {

    suspend fun getList(): List<Pokemon>

    suspend fun getPokemonInfo(id: Int): Pokemon
}