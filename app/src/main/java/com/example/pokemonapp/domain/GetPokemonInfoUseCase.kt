package com.example.pokemonapp.domain

class GetPokemonInfoUseCase(
    private val repository: Repository
) {
    operator fun invoke(id: Int) = repository.getPokemonInfo(id)
}