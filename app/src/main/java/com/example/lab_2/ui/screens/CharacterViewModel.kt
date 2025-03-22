package com.example.lab_2.ui.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab_2.model.data.Character
import com.example.lab_2.model.network.RickAndMortyApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {
    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters: StateFlow<List<Character>> = _characters

    fun fetchCharacters() {
        val pageNumber: Int = (0..42).random()
        viewModelScope.launch {
            try {
                Log.d("CharacterViewModel", "Загрузка персонажей...")
                val response = RickAndMortyApi.retrofitService.getCharacters(pageNumber)
                _characters.value = response.results
                Log.d("CharacterViewModel", "Персонажи загружены: ${response.results.size}")
            } catch (e: Exception) {
                Log.e("CharacterViewModel", "Ошибка при загрузке персонажей", e)
            }
        }
    }

    init {
        fetchCharacters()
    }
}