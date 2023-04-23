package com.example.mvvmapp.data

import com.example.mvvmapp.data.model.QuoteModel
import com.example.mvvmapp.data.model.QuoteProvider
import com.example.mvvmapp.data.network.QuoteService

class QuoteRepository {

    private  val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quotes=response
        return response

    }
}