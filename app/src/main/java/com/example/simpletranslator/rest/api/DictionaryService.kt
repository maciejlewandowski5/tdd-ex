package com.example.simpletranslator.rest.api

import com.example.simpletranslator.model.DefinitionItem
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryService {
    @GET("/{word}")
    fun translate(@Path("word") word: String): Observable<List<DefinitionItem>>
}
