package br.com.fabianospdev.bookslist

import br.com.fabianospdev.bookslist.model.book.Book

abstract class AbstractBookFactory {
    abstract fun createBook(book: Book): Book
}