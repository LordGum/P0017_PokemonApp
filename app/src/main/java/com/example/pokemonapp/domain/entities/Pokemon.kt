package com.example.pokemonapp.domain.entities

data class Pokemon (
    val id: Int,
    val name: String,
    val weight: String,
    val height: String,
    val stats: List<Stat>,
    val imageUrl: String,
    val types: ArrayList<String> = ArrayList()
)