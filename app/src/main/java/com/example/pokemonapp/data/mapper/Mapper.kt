package com.example.pokemonapp.data.mapper

import com.example.pokemonapp.data.network.model.PokemonDtn
import com.example.pokemonapp.data.network.model.StatsDtn
import com.example.pokemonapp.data.network.model.TypesDnt
import com.example.pokemonapp.domain.entities.Pokemon
import com.example.pokemonapp.domain.entities.Stat

fun PokemonDtn.toEntity(): Pokemon {
    return Pokemon(
        id = this.id,
        name = this.name,
        weight = this.weight.toString() + " kg",
        height = this.height.toString() + " m",
        stats = this.stats.toEntityList1(),
        imageUrl = this.spitesDnt.other.home.frontDefault,
        types = this.types.toEntityList()
    )
}

fun StatsDtn.toEntity(): Stat {
    return Stat(
        name = this.stat.name,
        score = this.baseState
    )
}

fun List<StatsDtn>.toEntityList1(): List<Stat> {
    return this.map { it.toEntity() }
}

fun TypesDnt.toEntity(): String {
    return this.type.name.uppercase()
}

fun ArrayList<TypesDnt>.toEntityList(): ArrayList<String> {
    val list = ArrayList<String>()
    for (type in this) {
        list.add(type.toEntity())
    }
    return list
}