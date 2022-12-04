package br.com.fabianospdev.bookslist.dao.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Books(
    @ColumnInfo(name = "name")
    var name: String?
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}