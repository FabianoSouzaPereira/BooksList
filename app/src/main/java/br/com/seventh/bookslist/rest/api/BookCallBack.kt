package br.com.seventh.bookslist.rest.api

import br.com.seventh.bookslist.model.book.Book

interface BookCallBack {
    fun onBookCallBack(list: MutableList<Book>){}
}