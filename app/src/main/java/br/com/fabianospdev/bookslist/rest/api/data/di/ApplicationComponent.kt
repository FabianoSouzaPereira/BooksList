package br.com.fabianospdev.bookslist.rest.api.data.di

import android.content.Context
import br.com.fabianospdev.bookslist.ui.di.MainComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module

@Component(modules =  [DataModule::class, ViewModelBuilder::class, SubComponentsModule::class, StringModule::class])
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationComponent: Context): ApplicationComponent
    }

    fun mainComponent(): MainComponent.Factory
}

@Module(subcomponents = [MainComponent::class])
object SubComponentsModule
