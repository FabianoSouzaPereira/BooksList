package br.com.fabianospdev.bookslist.model.book.sale.offers

import com.google.gson.annotations.SerializedName

data class OfferListPrice(
    @SerializedName("amountInMicros")
    val amountInMicros: Long,
    @SerializedName("currencyCode")
    val currencyCode: String
)