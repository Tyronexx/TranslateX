package com.example.translatex.network

import com.example.translatex.models.Translation
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TranslationApi {
    @GET("get")
    suspend fun translate(
        @Query("q") query:String,
        @Query("langpair") langPair:String
    ):Response<Translation>
}