package com.example.mvvmapp.domain

import com.example.mvvmapp.data.QuoteRepository
import com.example.mvvmapp.data.model.QuoteModel
import com.example.mvvmapp.data.model.QuoteProvider

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()
}