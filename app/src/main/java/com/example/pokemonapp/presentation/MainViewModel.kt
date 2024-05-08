package com.example.pokemonapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.data.RepositoryImpl
import com.example.pokemonapp.domain.entities.Pokemon
import com.example.pokemonapp.domain.usecases.GetListUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val repository = RepositoryImpl()
    private val getListUseCase = GetListUseCase(repository)

    private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
        Log.d("MainViewModel", "Exception caught by exception handler")
    }

    private val _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList: LiveData<List<Pokemon>>
        get() = _pokemonList
    fun getList() = viewModelScope.launch(exceptionHandler) {
        _pokemonList.value = getListUseCase()
    }
}