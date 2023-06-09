package com.example.mvvmapp.domain

import com.example.mvvmapp.data.QuoteRepository
import com.example.mvvmapp.data.model.QuoteModel
import com.example.mvvmapp.data.model.QuoteProvider

class GetRandomQuoteUseCase {


    operator fun invoke(): QuoteModel?{
        val quotes: List<QuoteModel> = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (0..quotes.size -1).random()
            return quotes[randomNumber]
        }
            return  null
    }
}