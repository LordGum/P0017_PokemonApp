package com.example.pokemonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.pokemonapp.presentation.MainScreen
import com.example.pokemonapp.presentation.MainViewModel
import com.example.pokemonapp.ui.theme.PokemonAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonAppTheme {
                val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
                MainScreen(viewModel)
            }
        }
    }
}
