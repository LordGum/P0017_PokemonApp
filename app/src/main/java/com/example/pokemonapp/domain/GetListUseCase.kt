package com.example.pokemonapp.domain

class GetListUseCase(
    private val repository: Repository
) {
    operator fun invoke() = repository.getList()
}