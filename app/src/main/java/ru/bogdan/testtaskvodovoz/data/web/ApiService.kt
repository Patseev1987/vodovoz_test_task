package ru.bogdan.testtaskvodovoz.data.web

import retrofit2.http.GET
import ru.bogdan.testtaskvodovoz.data.web.model.ResponseVodovoz


interface ApiService {
    @GET("newmobile/glavnaya/super_top.php?action=topglav")
    suspend fun gerResponseVodovoz(): ResponseVodovoz
}

