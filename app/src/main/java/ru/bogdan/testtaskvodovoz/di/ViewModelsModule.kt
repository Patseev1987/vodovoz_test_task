package ru.bogdan.testtaskvodovoz.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.bogdan.testtaskvodovoz.di.ViewModelKey
import ru.bogdan.testtaskvodovoz.presenter.MainViewModel


@Module
interface ViewModelsModule {
    @Binds
    @ViewModelKey(value = MainViewModel::class)
    @IntoMap
    fun bindViewModel(mainViewModel: MainViewModel): ViewModel
}