package br.com.fabianospdev.bookslist.rest.api.data.di

import br.com.fabianospdev.bookslist.rest.api.repository.DefaultRepository
import br.com.fabianospdev.bookslist.rest.api.repository.Repository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DataModule {

    @Singleton
    @Binds
    abstract fun provideDefaultDataSource(repository: DefaultRepository): Repository
}