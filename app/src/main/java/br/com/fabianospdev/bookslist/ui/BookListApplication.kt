package br.com.fabianospdev.bookslist.ui

import android.app.Application
import androidx.room.Room
import br.com.fabianospdev.bookslist.dao.AppDatabase
import br.com.fabianospdev.bookslist.rest.api.di.DaggerApplicationComponent

class BookListApplication : Application() {
    val appComponent = DaggerApplicationComponent.factory().create(this)
    val db = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java, "book_db"
    ).build()

}