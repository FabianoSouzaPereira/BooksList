package br.com.fabianospdev.bookslist.rest.api

import android.content.Context
import br.com.fabianospdev.bookslist.model.book.Recording

class ApiClient {

    fun getBooks(
        context: Context,
        aParam: String,
        success: (response: Recording) -> Unit,
        failure: (error: Error) -> Unit
    ) {

        val call = RetrofitInitializer().userService().getBooks(aParam)

        call.enqueue(callback({ response ->

            if (response?.code() == 200) {
                success(response.body() ?: return@callback)
            }
        }, { error ->
            print(error)
        }))
    }
}