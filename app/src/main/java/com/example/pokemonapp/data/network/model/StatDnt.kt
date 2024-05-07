package com.example.pokemonapp.data.network.model

import com.google.gson.annotations.SerializedName

data class StatDnt (
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)