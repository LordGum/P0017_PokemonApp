package com.example.pokemonapp.presentation.main

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

    private val _pokemonList = MutableLiveData<MainScreenState>()
    val pokemonList: LiveData<MainScreenState> = _pokemonList

    private var offset = 0

    init {
        getList()
    }

    private fun getList() {
        viewModelScope.launch(exceptionHandler) {
            _pokemonList.value = MainScreenState.Loading
            try {
                val list = getListUseCase(offset++)
                _pokemonList.postValue( MainScreenState.Success(
                    posts = list,
                    nextDataIsLoading = false
                ))
            } catch (e: Exception) {
                _pokemonList.value = MainScreenState.Error(e)
            }
        }
    }

    fun addList() {
        val currentValue = _pokemonList.value
        if( currentValue is MainScreenState.Success) {
            viewModelScope.launch(exceptionHandler) {
                try {
                    val oldList = currentValue.posts as ArrayList<Pokemon>
                    _pokemonList.value = MainScreenState.Success(
                        posts = oldList,
                        nextDataIsLoading = true
                    )

                    val newList = getListUseCase(offset++)
                    oldList.addAll(newList)
                    _pokemonList.value = MainScreenState.Success(
                        posts = oldList,
                        nextDataIsLoading = false
                    )
                    Log.d("MATAG", "size = ${oldList.size}")
                } catch (e: Exception) {
                    _pokemonList.value = MainScreenState.Error(e)
                }
            }
        }
    }
}