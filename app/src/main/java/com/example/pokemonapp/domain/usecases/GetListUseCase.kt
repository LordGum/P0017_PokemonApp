package com.example.pokemonapp.domain.usecases

import com.example.pokemonapp.domain.Repository

class GetListUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(offset: Int) = repository.getList(offset)
}