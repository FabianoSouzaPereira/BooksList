package br.com.fabianospdev.bookslist

import android.app.Application
import br.com.fabianospdev.bookslist.rest.api.data.di.DaggerApplicationComponent

class BookListApplication: Application() {
    val appComponent = DaggerApplicationComponent.factory().create(this)
}