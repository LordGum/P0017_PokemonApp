package com.example.pokemonapp.data

import com.example.pokemonapp.data.mapper.toEntity
import com.example.pokemonapp.data.mapper.toEntityList
import com.example.pokemonapp.data.network.ApiFactory
import com.example.pokemonapp.domain.entities.PokemonContainer
import com.example.pokemonapp.domain.Repository
import com.example.pokemonapp.domain.entities.Pokemon

class RepositoryImpl: Repository {
    private val apiService = ApiFactory.apiService
    override suspend fun getList(): List<PokemonContainer> {
        return apiService.loadList(0).responseList.toEntityList()
    }

    override suspend fun getPokemonInfo(id: Int): Pokemon {
        return apiService.loadDetails(id+1).toEntity()
    }
}