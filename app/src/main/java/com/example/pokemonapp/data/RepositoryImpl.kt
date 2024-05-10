package com.example.pokemonapp.data

import com.example.pokemonapp.data.mapper.toEntity
import com.example.pokemonapp.data.network.ApiFactory
import com.example.pokemonapp.domain.Repository
import com.example.pokemonapp.domain.entities.Pokemon

class RepositoryImpl: Repository {
    private val apiService = ApiFactory.apiService
    override suspend fun getList(offset: Int): List<Pokemon> {
        val responseList = apiService.loadList(offset * LIMIT_PARAMETER).responseList
        return responseList.map {getPokemonInfo( trimUrlId(it.url) )}
    }

    override suspend fun getPokemonInfo(id: Int): Pokemon {
        return apiService.loadDetails(id).toEntity()
    }

    private fun trimUrlId(url: String): Int {
        val lastIndex = url.length - 1
        return url.substring(34, lastIndex).toInt()
    }

    companion object {
        private const val LIMIT_PARAMETER = 20
    }
}