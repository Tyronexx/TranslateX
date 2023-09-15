package com.example.translatex.repositories

import com.example.translatex.models.BaseModel
import com.example.translatex.models.Translation
import com.example.translatex.network.TranslationApi

class TranslationRepoImpl(
    private val api: TranslationApi
):TranslationRepo {
    override suspend fun translate(
        query: String,
        from: String,
        to: String
    ): BaseModel<Translation> {

        try {
            api.translate(
                query = query,
                langPair = "$from|$to"
            ).also {
                return if (it.isSuccessful){
                    BaseModel.Success(data = it.body()!!)
                }else{
                    BaseModel.Error(error = it.errorBody()?.string().toString())
                }
            }
        }catch (e: Exception){
            return BaseModel.Error(error = e.message.toString())
        }

    }
}