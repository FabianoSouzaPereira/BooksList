package br.com.fabianospdev.bookslist.model.book.sale

import br.com.fabianospdev.bookslist.model.book.sale.offers.Offer
import br.com.fabianospdev.bookslist.model.book.sale.offers.RetailPrice
import br.com.fabianospdev.bookslist.model.book.sale.offers.SaleInfoListPrice
import com.google.gson.annotations.SerializedName

data class SaleInfo(
    @SerializedName("country")
    var country: String,
    @SerializedName("saleability")
    var saleability: String,
    @SerializedName("isEbook")
    var isEbook: Boolean,
    @SerializedName("listPrice")
    var listPrice: SaleInfoListPrice?,
    @SerializedName("retailPrice")
    var retailPrice: RetailPrice,
    @SerializedName("buyLink")
    var buyLink: String,
    @SerializedName("offers")
    var offers: List<Offer>?,
)







