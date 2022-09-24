package br.com.seventh.bookslist.utils

import br.com.seventh.bookslist.model.book.Book
import br.com.seventh.bookslist.model.book.access.AccessInfo
import br.com.seventh.bookslist.model.book.access.Epub
import br.com.seventh.bookslist.model.book.sale.SaleInfo
import br.com.seventh.bookslist.model.book.sale.offers.ListPrice
import br.com.seventh.bookslist.model.book.sale.offers.Offers
import br.com.seventh.bookslist.model.book.sale.offers.RetailPrice
import br.com.seventh.bookslist.model.book.search.SearchInfo
import br.com.seventh.bookslist.model.book.volume.*

class Shared {
    companion object {
        @JvmStatic
        var instance = Shared()
    }

    init {
        instance = this
    }

    var booksList: MutableList<Book> = ArrayList()
    var authors: Authors = Authors(arrayListOf())
    var industryIdentifiers: ArrayList<IndustryIdentifiers> = arrayListOf(IndustryIdentifiers(type = "", identifier = ""))
    var panelizationSummary: PanelizationSummary = PanelizationSummary(containsEpubBubbles = false, containsImageBubbles = false)
    var readingModes: ReadingModes = ReadingModes(text = false, image = true)
    var imageLinks: ImageLinks = ImageLinks(smallThumbnail = null, thumbnail = null)
    var offers: Offers = Offers(arrayListOf())
    var listPrice: ListPrice = ListPrice(amount = 0.0, currencyCode = "")
    var retailPrice: RetailPrice = RetailPrice(amount = 0.0, "")
    var epub: Epub = Epub(
        isAvailable = false,
        acsTokenLink = "",
        webReaderLink = "",
        accessViewStatus =  "",
        quoteSharingAllowed = false
    )
    var accessInfo: AccessInfo = AccessInfo(country = "country",
        viewability = "viewability",
        embeddable = false,
        publicDomain = false,
        textToSpeechPermission = "",
        epub = epub
    )
    var searchInfo: SearchInfo = SearchInfo(textSnippet = "text")
    var saleInfo: SaleInfo = SaleInfo(
        country = "",
        saleability = "",
        isEbook = false,
        listPrice = listPrice,
        retailPrice = retailPrice,
        buyLink = "",
        offers = offers
    )


    val volumeInfo = VolumeInfo(
        title = "title",
        subtitle = "subtitle",
        authors = authors,
        publisher = "publisher",
        publishedDate = "publishedDate",
        description = "description",
        industryIdentifiers = industryIdentifiers,
        readingModes = readingModes,
        pageCount = 0,
        printType = "printType",
        categories = arrayListOf(),
        maturityRating = "maturityRating",
        allowAnonLogging = true,
        contentVersion = "contentVersion",
        panelizationSummary = panelizationSummary,
        containsEpubBubbles = true,
        containsImageBubbles = false,
        imageLinks = imageLinks,
        language = "language",
        previewLink = "previewLink",
        infoLink = "infoLink",
        canonicalVolumeLink = "canonicalVolumeLink"
    )

    val populate = Book(
        kind = "kind",
        id = "id",
        etag = null,
        selfLink = "selfLink",
        volumeInfo = volumeInfo,
        saleInfo = saleInfo,
        accessInfo = accessInfo,
        searchInfo = searchInfo
    )


}