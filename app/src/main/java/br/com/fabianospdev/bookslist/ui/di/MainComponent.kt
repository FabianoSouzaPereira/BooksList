package br.com.fabianospdev.bookslist.ui.di

import br.com.fabianospdev.bookslist.ui.MainActivity
import br.com.fabianospdev.bookslist.ui.home.HomeFragment
import br.com.fabianospdev.bookslist.ui.notifications.NotificationsFragment
import dagger.Subcomponent


@Subcomponent(modules = [MainModule::class])
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: HomeFragment)
    fun inject(fragment: NotificationsFragment)

}