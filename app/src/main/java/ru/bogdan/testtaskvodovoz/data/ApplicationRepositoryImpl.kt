package ru.bogdan.testtaskvodovoz.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.bogdan.testtaskvodovoz.domain.ApplicationRepository
import ru.bogdan.testtaskvodovoz.domain.VodovozResponse
import ru.bogdan.testtaskvodovoz.data.web.ApiHelper
import ru.bogdan.testtaskvodovoz.util.toVodovozResponse

class ApplicationRepositoryImpl(private val apiHelper: ApiHelper) : ApplicationRepository {
    override fun getVodovozResponse(): Flow<VodovozResponse> {
        return apiHelper.getResponseVodovoz().map { it.toVodovozResponse() }
    }
}