package ru.bogdan.testtaskvodovoz.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.bogdan.testtaskvodovoz.data.web.ApiHelper
import ru.bogdan.testtaskvodovoz.domain.ApplicationRepository
import ru.bogdan.testtaskvodovoz.domain.VodovozResponse
import ru.bogdan.testtaskvodovoz.util.toVodovozResponse
import javax.inject.Inject

class ApplicationRepositoryImpl @Inject constructor(private val apiHelper: ApiHelper) :
    ApplicationRepository {
    override fun getVodovozResponse(): Flow<VodovozResponse> {
        return apiHelper.getResponseVodovoz().map { it.toVodovozResponse() }
    }
    
    override fun updateData() {
        apiHelper.updateData()
    }
}