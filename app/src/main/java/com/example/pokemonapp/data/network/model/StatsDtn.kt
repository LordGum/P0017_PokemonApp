package com.example.pokemonapp.data.network.model

import com.google.gson.annotations.SerializedName

data class StatsDtn (
    @SerializedName("base_stat") val baseState: Int,
    @SerializedName("effort") val effort: Int,
    @SerializedName("stat") val stat: StatDnt
)