package br.com.fabianospdev.bookslist.ui

import android.app.Application
import br.com.fabianospdev.bookslist.dao.AppDatabase
import br.com.fabianospdev.bookslist.dao.BookDao
import br.com.fabianospdev.bookslist.rest.api.di.ApplicationComponent
import br.com.fabianospdev.bookslist.rest.api.di.DaggerApplicationComponent


class BookListApplication : Application() {
    val appComponent: ApplicationComponent = DaggerApplicationComponent.factory().create(this)

    val db: suspend () -> BookDao = suspend { AppDatabase.getInstance(context = this.applicationContext).bookDao() }
    //  val d = db
}
