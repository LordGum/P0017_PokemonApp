package com.example.pokemonapp.domain.entities

data class Pokemon (
    val id: Int,
    val name: String,
    val weight: Double,
    val height: Double,
    val stats: List<Stat>,
    val imageUrl: String,
    val types: ArrayList<String> = ArrayList()
)