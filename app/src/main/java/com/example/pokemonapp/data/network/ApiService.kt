package com.example.pokemonapp.data.network

import com.example.pokemonapp.data.network.model.PokemonDtn
import com.example.pokemonapp.data.network.model.ResponseApiDtn
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("?limit=20")
    suspend fun loadList(
        @Query("offset") offset: Int
    ): ResponseApiDtn

    @GET("{id}/")
    suspend fun loadDetails(
        @Path("id") id: Int
    ): PokemonDtn
}