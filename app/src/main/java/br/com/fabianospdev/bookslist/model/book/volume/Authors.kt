package br.com.fabianospdev.bookslist.model.book.volume

import com.google.gson.annotations.SerializedName

/* This is in VolumeInfo Object */
data class Authors(
    @SerializedName("authors")
    var authors: MutableList<String>
)