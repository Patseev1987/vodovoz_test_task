package ru.bogdan.testtaskvodovoz.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Goods(
    val goods: List<Product>,
    val id: Long,
    val categoryTitle: String
):Parcelable
