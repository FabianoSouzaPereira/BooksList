package br.com.fabianospdev.bookslist.utils

import br.com.fabianospdev.bookslist.model.book.Book
import br.com.fabianospdev.bookslist.model.book.Recording
import br.com.fabianospdev.bookslist.model.book.access.AccessInfo
import br.com.fabianospdev.bookslist.model.book.access.Epub
import br.com.fabianospdev.bookslist.model.book.sale.SaleInfo
import br.com.fabianospdev.bookslist.model.book.sale.offers.Offers
import br.com.fabianospdev.bookslist.model.book.sale.offers.RetailPrice
import br.com.fabianospdev.bookslist.model.book.sale.offers.SaleInfoListPrice
import br.com.fabianospdev.bookslist.model.book.search.SearchInfo
import br.com.fabianospdev.bookslist.model.book.volume.*

@Suppress("MemberVisibilityCanBePrivate")
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
    var industryIdentifiers: ArrayList<IndustryIdentifiers> =
        arrayListOf(IndustryIdentifiers(type = "", identifier = ""))
    var panelizationSummary: PanelizationSummary =
        PanelizationSummary(containsEpubBubbles = false, containsImageBubbles = false)
    var readingModes: ReadingModes = ReadingModes(text = false, image = true)
    var imageLinks: ImageLinks = ImageLinks(smallThumbnail = null, thumbnail = null)
    var offers: Offers = Offers(arrayListOf())
    var listPrice: SaleInfoListPrice = SaleInfoListPrice(amount = 0.0, currencyCode = "")
    var retailPrice: RetailPrice = RetailPrice(amount = 0.0, "")
    var epub: Epub = Epub(
        isAvailable = false,
        acsTokenLink = ""
    )
    var accessInfo: AccessInfo = AccessInfo(
        country = "country",
        viewability = "viewability",
        embeddable = false,
        publicDomain = false,
        textToSpeechPermission = "",
        epub = epub,
        pdf = epub,
        webReaderLink = "",
        accessViewStatus = "",
        quoteSharingAllowed = false
    )
    var searchInfo: SearchInfo = SearchInfo(textSnippet = "text")
    var saleInfoListPrice = SaleInfoListPrice(0.0, "")
    var saleInfo: SaleInfo = SaleInfo(
        country = "",
        saleability = "",
        isEbook = false,
        listPrice = saleInfoListPrice,
        retailPrice = retailPrice,
        buyLink = "",
        offers = arrayListOf()
    )


    val volumeInfo = VolumeInfo(
        title = "title",
        subtitle = "subtitle",
        authors = arrayListOf(),
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


    var recording = Recording(
        kind = "kind",
        totalItems = 0,
        items = arrayListOf()
    )
}