package br.com.fabianospdev.bookslist.model.book

import androidx.lifecycle.LiveData
import br.com.fabianospdev.bookslist.model.book.access.AccessInfo
import br.com.fabianospdev.bookslist.model.book.sale.SaleInfo
import br.com.fabianospdev.bookslist.model.book.search.SearchInfo
import br.com.fabianospdev.bookslist.model.book.volume.VolumeInfo
import com.google.gson.annotations.SerializedName
import java.util.*

/* Main Object Book */
data class Book(
    @SerializedName("kind")
    var kind: String?,
    @SerializedName("id")
    var id: String?,
    @SerializedName("etag")
    var etag: String?,
    @SerializedName("selfLink")
    var selfLink: String?,
    @SerializedName("volumeInfo")
    var volumeInfo: VolumeInfo?,
    @SerializedName("saleInfo")
    var saleInfo: SaleInfo?,
    @SerializedName("accessInfo")
    var accessInfo: AccessInfo?,
    @SerializedName("searchInfo")
    var searchInfo: SearchInfo?
) : LiveData<Book>()