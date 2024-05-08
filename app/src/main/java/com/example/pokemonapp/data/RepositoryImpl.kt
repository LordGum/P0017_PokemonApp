package com.example.pokemonapp.data

import com.example.pokemonapp.data.mapper.toEntity
import com.example.pokemonapp.data.network.ApiFactory
import com.example.pokemonapp.domain.Repository
import com.example.pokemonapp.domain.entities.Pokemon

class RepositoryImpl: Repository {
    private val apiService = ApiFactory.apiService
    override suspend fun getList(): List<Pokemon> {
        val responseList = apiService.loadList(0).responseList
        return responseList.map {getPokemonInfo( trimUrlId(it.url) )}
    }

    override suspend fun getPokemonInfo(id: Int): Pokemon {
        return apiService.loadDetails(id).toEntity()
    }

    private fun trimUrlId(url: String): Int {
        val lastIndex = url.length - 1
        return url.substring(34, lastIndex).toInt()
    }
}