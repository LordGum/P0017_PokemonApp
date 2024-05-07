package com.example.pokemonapp.data.mapper

import com.example.pokemonapp.data.network.model.PokemonContainerDtn
import com.example.pokemonapp.data.network.model.PokemonDtn
import com.example.pokemonapp.data.network.model.StatsDtn
import com.example.pokemonapp.data.network.model.TypesDnt
import com.example.pokemonapp.domain.entities.Pokemon
import com.example.pokemonapp.domain.entities.PokemonContainer
import com.example.pokemonapp.domain.entities.Stat

fun PokemonContainerDtn.toEntity(): PokemonContainer {
    return PokemonContainer(this.name, this.url)
}

fun List<PokemonContainerDtn>.toEntityList(): List<PokemonContainer> {
    return this.map { it.toEntity() }
}

fun PokemonDtn.toEntity(): Pokemon {
    return Pokemon(
        id = this.id,
        name = this.name,
        weight = this.weight,
        height = this.height,
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
    return this.type.name
}

fun ArrayList<TypesDnt>.toEntityList(): ArrayList<String> {
    val list = ArrayList<String>()
    for (type in this) {
        list.add(type.toEntity())
    }
    return list
}