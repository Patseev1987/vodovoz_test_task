package ru.bogdan.testtaskvodovoz.util

import ru.bogdan.testtaskvodovoz.BuildConfig
import ru.bogdan.testtaskvodovoz.data.web.model.Data
import ru.bogdan.testtaskvodovoz.data.web.model.MorePhoto
import ru.bogdan.testtaskvodovoz.data.web.model.ResponseVodovoz
import ru.bogdan.testtaskvodovoz.data.web.model.Tovary
import ru.bogdan.testtaskvodovoz.domain.Goods
import ru.bogdan.testtaskvodovoz.domain.Photos
import ru.bogdan.testtaskvodovoz.domain.Product
import ru.bogdan.testtaskvodovoz.domain.VodovozResponse

fun ResponseVodovoz.toVodovozResponse(): VodovozResponse {
    return VodovozResponse(
        status = this.status,
        message = this.message,
        goods = this.tovary.map { it.toGoods() }
    )
}

fun Tovary.toGoods(): Goods {
    return Goods(
        id = this.id,
        categoryTitle = this.name,
        goods = this.data.map { it.toProduct() }
    )
}

fun Data.toProduct(): Product {
    return Product(
        price = this.eXTENDEDPRICE.first(),
        rating = this.pROPERTYRATINGVALUE,
        picture = BuildConfig.BASE_URL + this.dETAILPICTURE.substring(1, this.dETAILPICTURE.length),
        photos = this.mOREPHOTO?.toPhotos(),
        isFavorite = this.fAVORITE
    )
}

fun MorePhoto.toPhotos(): Photos {
    return Photos(
        photos = this.value.map { url -> BuildConfig.BASE_URL + url.substring(1, url.length) }
    )
}
