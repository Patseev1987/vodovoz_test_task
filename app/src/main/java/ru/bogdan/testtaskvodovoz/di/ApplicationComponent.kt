package ru.bogdan.testtaskvodovoz.di

import dagger.Component
import ru.bogdan.testtaskvodovoz.presenter.mainFragment.MainFragment
import ru.bogdan.testtaskvodovoz.presenter.tabFragment.TabFragment

@ApplicationScope
@Component(modules = [ViewModelsModule::class, DataModule::class])
interface ApplicationComponent {
    
    fun inject(mainFragment: MainFragment)
    fun inject(tabFragment: TabFragment)
}