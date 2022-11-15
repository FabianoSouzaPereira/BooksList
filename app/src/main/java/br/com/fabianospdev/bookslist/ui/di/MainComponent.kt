package br.com.fabianospdev.bookslist.ui.di

import br.com.fabianospdev.bookslist.MainActivity
import br.com.fabianospdev.bookslist.ui.home.HomeFragment
import dagger.Subcomponent


@Subcomponent(modules = [MainModule::class])
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: HomeFragment)

}