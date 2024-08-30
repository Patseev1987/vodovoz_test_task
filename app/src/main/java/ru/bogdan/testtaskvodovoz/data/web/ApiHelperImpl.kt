package ru.bogdan.testtaskvodovoz.data.web

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.bogdan.testtaskvodovoz.data.web.model.ResponseVodovoz

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {
    override fun getResponseVodovoz(): Flow<ResponseVodovoz> {
        return flow{
          val response = apiService.gerResponseVodovoz()
            emit(response)
        }
    }
}