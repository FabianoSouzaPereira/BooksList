package br.com.fabianospdev.bookslist.model.book.volume

import com.google.gson.annotations.SerializedName

/* This is in VolumeInfo */
data class Categories(
    @SerializedName("Religion")
    var Religion: String
)