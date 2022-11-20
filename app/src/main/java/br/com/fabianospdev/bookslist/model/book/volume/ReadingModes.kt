package br.com.fabianospdev.bookslist.model.book.volume

import com.google.gson.annotations.SerializedName

/* This is in VolumeInfo */
data class ReadingModes(
    @SerializedName("text")
    var text: Boolean,
    @SerializedName("image")
    var image: Boolean
)