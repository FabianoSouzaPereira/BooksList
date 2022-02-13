package br.com.seventh.bookslist.model.book.sale.offers

data class Offer(
    var finskyOfferType: Int,
    var listPrice: MutableList<ListPrice>,
    var retailPrice: MutableList<RetailPrice>,
    var giftable: Boolean
)