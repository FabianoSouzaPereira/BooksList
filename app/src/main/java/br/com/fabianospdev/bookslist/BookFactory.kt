package br.com.fabianospdev.bookslist

import br.com.fabianospdev.bookslist.model.book.Book

class BookFactory: AbstractBookFactory() {
    override fun createBook(book: Book): Book {
        return Book(book.kind,book.id,book.etag,book.selfLink,book.volumeInfo,book.saleInfo,book.accessInfo,book.searchInfo)
    }
}