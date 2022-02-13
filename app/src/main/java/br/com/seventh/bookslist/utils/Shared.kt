package br.com.seventh.bookslist.utils

import br.com.seventh.bookslist.model.book.Book

class Shared {
    companion object {
        @JvmStatic
        var instance = Shared()
    }

    init {
        instance = this
    }

    var booksList: MutableList<Book> = ArrayList()


}