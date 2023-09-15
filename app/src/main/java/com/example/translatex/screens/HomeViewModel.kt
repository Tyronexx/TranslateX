package com.example.translatex.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.translatex.models.BaseModel
import com.example.translatex.models.Translation
import com.example.translatex.repositories.TranslationRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel:ViewModel(), KoinComponent {

    private val repo: TranslationRepo by inject()

    private val _translation:MutableStateFlow<BaseModel<Translation>?> = MutableStateFlow(null)
    val translation = _translation.asStateFlow()

    fun translate(query: String, source:String, target: String){
        _translation.update { BaseModel.Loading }
        viewModelScope.launch {
            repo.translate(
                query = query,
                from = source,
                to = target
            ).also { response ->
                _translation.update { response }
            }
        }
    }

    fun clear(){
        _translation.update { null }
    }

}