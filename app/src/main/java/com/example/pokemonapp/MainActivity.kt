package com.example.pokemonapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pokemonapp.data.RepositoryImpl
import com.example.pokemonapp.ui.theme.PokemonAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonAppTheme {

            }
        }
        test()
    }

    fun test () {
        val repositoryImpl = RepositoryImpl()
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            val list = repositoryImpl.getList()
            val item = repositoryImpl.getPokemonInfo(1).stats[0].name
            Log.d("MATAG", "response: ${item}")
        }

    }

}
