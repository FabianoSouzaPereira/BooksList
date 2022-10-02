package br.com.fabianospdev.bookslist.rest.api

import android.content.Context
import br.com.fabianospdev.bookslist.model.book.Book

class ApiClient {

    fun getBooks(
        context: Context,
        accept: String,
        contentType: String,
        aParam: String,
        success: (response: List<Book>) -> Unit,
        failure: (error: Error) -> Unit
    ) {

        val call = RetrofitInitializer().userService().getBooks(accept, contentType, aParam)

        call.enqueue(callback({ response ->

            if (response?.code() == 200) {
                success(response.body()!!)
            }
        }, {}))
    }
}