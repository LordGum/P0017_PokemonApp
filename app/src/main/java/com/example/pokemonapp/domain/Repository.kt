package com.example.pokemonapp.domain

interface Repository {

    fun getList(): List<Pokemon>

    fun getPokemonInfo(id: Int): Pokemon
}