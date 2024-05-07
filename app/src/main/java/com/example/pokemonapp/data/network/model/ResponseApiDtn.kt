package com.example.pokemonapp.data.network.model

import com.google.gson.annotations.SerializedName

data class ResponseApiDtn (
    @SerializedName("results") val responseList: List<PokemonContainerDtn>
)