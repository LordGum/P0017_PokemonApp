package com.example.pokemonapp.domain.usecases

import com.example.pokemonapp.domain.Repository

class GetPokemonInfoUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(id: Int) = repository.getPokemonInfo(id)
}