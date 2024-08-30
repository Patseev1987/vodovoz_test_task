package ru.bogdan.testtaskvodovoz.data.web

import retrofit2.http.*
import ru.bogdan.testtaskvodovoz.data.web.model.ResponseVodovoz


interface ApiService {
    @GET("super_top.php?action=topglav")
    suspend fun gerResponseVodovoz(): ResponseVodovoz
}

