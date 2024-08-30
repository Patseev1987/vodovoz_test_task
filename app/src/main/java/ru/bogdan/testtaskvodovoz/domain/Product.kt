package ru.bogdan.testtaskvodovoz.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ru.bogdan.testtaskvodovoz.data.web.model.ExtendedPrice
import ru.bogdan.testtaskvodovoz.data.web.model.MorePhoto
@Parcelize
data class Product(
    val price: ExtendedPrice,
    val rating: Double,
    val picture: String,
    val morePhoto: MorePhoto?,
    var isFavorite: Boolean = false
):Parcelable