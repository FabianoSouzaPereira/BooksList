package br.com.fabianospdev.bookslist.model.book.sale.offers

import com.google.gson.annotations.SerializedName


data class Offers(
    @SerializedName("offers")
    val offers: MutableList<Offer>
)