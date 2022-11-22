package br.com.fabianospdev.bookslist.rest.api.repository

import android.content.Context
import br.com.fabianospdev.bookslist.model.book.Book
import br.com.fabianospdev.bookslist.model.book.Recording

interface Repository {

    fun login()
    fun getBooks(
        context: Context,
        aParam: String,
        success: (response: Recording) -> MutableList<Book>,
        failure: (error: Error) -> Unit
    )
}