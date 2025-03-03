package com.example.lab_2.model.network

import retrofit2.http.GET
import com.example.lab_2.model.CharacterResponse
import retrofit2.http.Query

interface RickAndMortyApiService {
    @GET("character")
    suspend fun getCharacters(
        @Query("page") pageNumber: Int
    ): CharacterResponse
}