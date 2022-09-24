package br.com.seventh.bookslist

import br.com.seventh.bookslist.model.book.Book

abstract class AbstractBookFactory {
    abstract fun createBook(book: Book): Book
}