package ru.bogdan.testtaskvodovoz.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.bogdan.testtaskvodovoz.data.ApplicationRepositoryImpl
import ru.bogdan.testtaskvodovoz.data.web.ApiFactory
import ru.bogdan.testtaskvodovoz.data.web.ApiHelper
import ru.bogdan.testtaskvodovoz.data.web.ApiHelperImpl
import ru.bogdan.testtaskvodovoz.domain.ApplicationRepository

@Module
interface DataModule {
    @ApplicationScope
    @Binds
    fun bindApplicationRepository(impl: ApplicationRepositoryImpl): ApplicationRepository
    @ApplicationScope
    @Binds
    fun bindApiHelper(impl: ApiHelperImpl): ApiHelper

    companion object{
        @Provides
        fun provideApiService() = ApiFactory.apiService
    }
}