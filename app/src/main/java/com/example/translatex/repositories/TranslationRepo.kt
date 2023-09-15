package com.example.translatex.repositories

import com.example.translatex.models.BaseModel
import com.example.translatex.models.Translation

interface TranslationRepo {

    suspend fun translate(
        query: String,
        from: String,
        to: String
    ):BaseModel<Translation>

}