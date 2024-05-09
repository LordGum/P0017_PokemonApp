package com.example.pokemonapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.data.RepositoryImpl
import com.example.pokemonapp.domain.usecases.GetListUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val repository = RepositoryImpl()
    private val getListUseCase = GetListUseCase(repository)

    private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
        Log.d("MainViewModel", "Exception caught by exception handler")
    }

    private val _pokemonList = MutableLiveData<MainScreenState>()
    val pokemonList: LiveData<MainScreenState> = _pokemonList

    init {
        getList()
    }

    private fun getList() {
        viewModelScope.launch(exceptionHandler) {
            _pokemonList.value = MainScreenState.Loading
            try {
                val list = getListUseCase()
                _pokemonList.value = MainScreenState.Success(list)
            } catch (e: Exception) {
                _pokemonList.value = MainScreenState.Error(e)
            }
        }
    }
}