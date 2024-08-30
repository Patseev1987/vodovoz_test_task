package ru.bogdan.testtaskvodovoz.domain

import ru.bogdan.testtaskvodovoz.data.web.model.ExtendedPrice
import ru.bogdan.testtaskvodovoz.data.web.model.MorePhoto

data class Product(
    val price: ExtendedPrice,
    val rating: Double,
    val picture: String,
    val morePhoto: MorePhoto
)