package br.com.fabianospdev.bookslist.model.book

import com.google.gson.annotations.SerializedName

data class Recording(
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("totalItems")
    val totalItems: Long?,
    @SerializedName("items")
    val items: List<Book>?
)
