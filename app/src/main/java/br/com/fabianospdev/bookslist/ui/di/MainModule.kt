package br.com.fabianospdev.bookslist.ui.di

import androidx.lifecycle.ViewModel
import br.com.fabianospdev.bookslist.rest.api.data.di.ViewModelKey
import br.com.fabianospdev.bookslist.ui.home.HomeViewModel
import br.com.fabianospdev.bookslist.ui.notifications.NotificationsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NotificationsViewModel::class)
    fun bindNotificationsViewModel(viewModel: NotificationsViewModel): ViewModel
}