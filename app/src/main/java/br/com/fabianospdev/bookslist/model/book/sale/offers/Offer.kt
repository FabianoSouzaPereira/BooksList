package br.com.fabianospdev.bookslist.model.book.sale.offers

import com.google.gson.annotations.SerializedName

data class Offer(
    @SerializedName("finskyOfferType")
    var finskyOfferType: Int,
    @SerializedName("listPrice")
    var listPrice: OfferListPrice,
    @SerializedName("retailPrice")
    var retailPrice: OfferListPrice,
    @SerializedName("giftable")
    var giftable: Boolean
)