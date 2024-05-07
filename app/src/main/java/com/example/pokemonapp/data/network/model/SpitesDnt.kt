package com.example.pokemonapp.data.network.model

import com.google.gson.annotations.SerializedName

data class SpitesDnt (
    @SerializedName("other") val other: OtherDnt
)

data class OtherDnt (
    @SerializedName("home") val home: HomeDnt
)

data class HomeDnt (
    @SerializedName("front_default") val frontDefault: String
)