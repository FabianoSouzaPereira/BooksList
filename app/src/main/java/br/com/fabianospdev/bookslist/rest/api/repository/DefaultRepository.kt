package br.com.fabianospdev.bookslist.rest.api.repository

import android.content.Context
import android.util.Log
import br.com.fabianospdev.bookslist.model.book.Recording
import br.com.fabianospdev.bookslist.rest.api.RetrofitInitializer
import br.com.fabianospdev.bookslist.rest.api.callback
import br.com.fabianospdev.bookslist.ui.home.HomeViewModel
import javax.inject.Inject

class DefaultRepository @Inject constructor(val context: Context) : Repository {
    override fun login() {
        Log.d("DefaultRepository", "Login Done")
    }

    override fun getBooks(
        context: HomeViewModel,
        aParam: String,
        success: (response: Recording) -> Unit,
        failure: (error: Error) -> Unit
    ) {
        val call = RetrofitInitializer().userService().getBooks(aParam)

        call.enqueue(callback({ response ->

            if (response?.code() == 200) {
                success(response.body()!!)
            }
        }, { error ->
            print(error)
        }))
    }
}