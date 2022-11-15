package br.com.fabianospdev.bookslist.ui

import android.app.Application
import br.com.fabianospdev.bookslist.rest.api.data.di.ApplicationComponent
import br.com.fabianospdev.bookslist.rest.api.data.di.DaggerApplicationComponent

class NavigationApp : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.factory().create(this)
    }
}