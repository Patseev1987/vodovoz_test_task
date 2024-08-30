package ru.bogdan.testtaskvodovoz.di

import dagger.Component
import ru.bogdan.testtaskvodovoz.presenter.MainFragment

@ApplicationScope
@Component(modules = [ViewModelsModule::class, DataModule::class])
interface ApplicationComponent {
    
    fun inject(mainFragment: MainFragment)
}