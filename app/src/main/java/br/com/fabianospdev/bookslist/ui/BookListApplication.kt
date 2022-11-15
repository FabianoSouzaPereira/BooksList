package br.com.fabianospdev.bookslist.ui

import android.app.Application
import br.com.fabianospdev.bookslist.rest.api.di.DaggerApplicationComponent

class BookListApplication: Application() {
    val appComponent = DaggerApplicationComponent.factory().create(this)
}