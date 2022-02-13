package br.com.seventh.bookslist.model.book.access

data class AccessInfo (
    var country: String,
    var viewability: String,
    var embeddable: Boolean,
    var publicDomain: Boolean,
    var textToSpeechPermission: String,
    var epub: Epub
)

    data class Epub(
        var isAvailable: Boolean,
        var acsTokenLink: String,
        var webReaderLink: String,
        var accessViewStatus: String,
        var quoteSharingAllowed: Boolean
    )

    data class pdf(
        var isAvailable: Boolean,
        var acsTokenLink: String
    )
