package br.com.fabianospdev.bookslist.rest.api

import br.com.fabianospdev.bookslist.model.book.Book

interface BookCallBack {
    fun onBookCallBack(list: MutableList<Book>){}
}