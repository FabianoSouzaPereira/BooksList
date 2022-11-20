package br.com.fabianospdev.bookslist.rest.api

import br.com.fabianospdev.bookslist.model.book.Recording
import br.com.fabianospdev.bookslist.utils.Constants.Endpoint.GET_BOOKS
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(GET_BOOKS)
    fun getBooks(
        @Query("q") aParam: String?
    ): Call<Recording>

}