package ru.bogdan.testtaskvodovoz.data.web


import kotlinx.coroutines.flow.Flow
import ru.bogdan.testtaskvodovoz.data.web.model.ResponseVodovoz


interface ApiHelper {

    fun getResponseVodovoz(): Flow<ResponseVodovoz>

}