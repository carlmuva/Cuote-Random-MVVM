package com.example.mvvmapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmapp.data.model.QuoteModel
import com.example.mvvmapp.data.model.QuoteProvider
import com.example.mvvmapp.domain.GetQuotesUseCase
import com.example.mvvmapp.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    var getOutesUseCase = GetQuotesUseCase()
    var getRandomQuoteUseCase = GetRandomQuoteUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result: List<QuoteModel>? = getOutesUseCase()

            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }

        }

    }

    fun randomQuote(){
        isLoading.postValue(true)

        val quote = getRandomQuoteUseCase()
        if(quote!= null){
            quoteModel.postValue(quote!!)
        }

        isLoading.postValue(false)
    }




}