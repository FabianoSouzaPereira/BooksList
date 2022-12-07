package br.com.fabianospdev.bookslist.rest.api.repository

import br.com.fabianospdev.bookslist.model.book.Recording
import br.com.fabianospdev.bookslist.ui.home.HomeViewModel

interface Repository {

    fun login()
    fun getBooks(
        context: HomeViewModel,
        aParam: String,
        success: (response: Recording) -> Unit,
        failure: (error: Error) -> Unit
    )
}