package br.com.fabianospdev.bookslist.model.book.volume

import com.google.gson.annotations.SerializedName

/* This is in VolumeInfo Object */
data class IndustryIdentifiers(
    @SerializedName("type")
    var type: String,
    @SerializedName("identifier")
    var identifier: String
)