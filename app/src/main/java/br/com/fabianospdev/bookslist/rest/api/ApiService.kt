package br.com.fabianospdev.bookslist.rest.api

import br.com.fabianospdev.bookslist.model.book.Book
import br.com.fabianospdev.bookslist.utils.Constants.Endpoint.GET_BOOKS
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET(GET_BOOKS)
    fun getBooks(
        @Header("Accept") applicationjson: String,
        @Header("Content-Type") contentType: String,
        @Query("q") aParam: String?
    ): Call<List<Book>>

}