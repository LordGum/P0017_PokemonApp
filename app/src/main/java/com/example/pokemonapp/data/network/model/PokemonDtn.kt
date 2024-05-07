package com.example.pokemonapp.data.network.model

import com.google.gson.annotations.SerializedName

data class PokemonDtn (
    @SerializedName("id")       val id: Int,
    @SerializedName("name")     val name: String,
    @SerializedName("weight")   val weight: Double,
    @SerializedName("height")   val height: Double,
    @SerializedName("stats")    val stats: List<StatsDtn>,
    @SerializedName("sprites")  val spitesDnt: SpitesDnt,
    @SerializedName("types")    val types: ArrayList<TypesDnt> = ArrayList()
)