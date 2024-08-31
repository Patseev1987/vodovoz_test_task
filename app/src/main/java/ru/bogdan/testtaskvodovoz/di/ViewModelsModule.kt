package ru.bogdan.testtaskvodovoz.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.bogdan.testtaskvodovoz.presenter.mainFragment.MainViewModel
import ru.bogdan.testtaskvodovoz.presenter.tabFragment.ViewModelTabLayout


@Module
interface ViewModelsModule {
    @Binds
    @ViewModelKey(value = MainViewModel::class)
    @IntoMap
    fun bindViewModel(mainViewModel: MainViewModel): ViewModel
    
    @Binds
    @ViewModelKey(value = ViewModelTabLayout::class)
    @IntoMap
    fun bindViewModelTabLayout(viewModelTabLayout: ViewModelTabLayout): ViewModel
}