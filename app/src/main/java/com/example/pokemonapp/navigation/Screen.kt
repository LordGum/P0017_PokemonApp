package com.example.pokemonapp.navigation

import android.net.Uri
import com.example.pokemonapp.domain.entities.Pokemon
import com.google.gson.Gson

sealed class Screen(
    val route: String
) {
    object MainScreen: Screen(ROUTE_MAIN)
    object DetailScreen: Screen(ROUTE_DETAIL) {
        private const val ROUTE_FOR_ARGS = "route_detail"

        fun getArgs(pokemon: Pokemon): String {
            val pokemonJson = Gson().toJson(pokemon)
            return "$ROUTE_FOR_ARGS/${pokemonJson.encode()}"
        }
    }

    companion object {
        const val POKEMON = "id"

        private const val ROUTE_MAIN = "route_main"
        private const val ROUTE_DETAIL = "route_detail/{$POKEMON}"
    }
}

fun String.encode(): String {
    return Uri.encode(this)
}