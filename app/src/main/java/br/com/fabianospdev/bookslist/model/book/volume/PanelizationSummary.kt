package br.com.fabianospdev.bookslist.model.book.volume

import com.google.gson.annotations.SerializedName

/* This is in VolumeInfo */
data class PanelizationSummary(
    @SerializedName("ontainsEpubBubbles")
    var containsEpubBubbles: Boolean,
    @SerializedName("containsImageBubbles")
    var containsImageBubbles: Boolean
)