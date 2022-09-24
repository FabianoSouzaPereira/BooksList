package br.com.seventh.bookslist.model.book

import br.com.seventh.bookslist.model.book.access.AccessInfo
import br.com.seventh.bookslist.model.book.sale.SaleInfo
import br.com.seventh.bookslist.model.book.search.SearchInfo
import br.com.seventh.bookslist.model.book.volume.VolumeInfo

/* Main Object Book */
data class Book (
    var kind: String?,
    var id: String?,
    var etag: String?,
    var selfLink: String?,
    var volumeInfo: VolumeInfo?,
    var saleInfo: SaleInfo?,
    var accessInfo: AccessInfo?,
    var searchInfo: SearchInfo?
)