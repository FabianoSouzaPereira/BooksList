package br.com.fabianospdev.bookslist.model.book.search

import com.google.gson.annotations.SerializedName

data class SearchInfo(
    @SerializedName("textSnippet")
    var textSnippet: String
)