package com.example.pokemonapp.data.network.model

import com.google.gson.annotations.SerializedName

data class TypeDnt (
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
)