package br.com.fabianospdev.bookslist.rest.api

import br.com.fabianospdev.bookslist.model.book.Recording
import br.com.fabianospdev.bookslist.ui.home.HomeViewModel

class ApiClient {

    fun getBooks(
        context: HomeViewModel,
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