package ru.bogdan.testtaskvodovoz.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Photos(
    val photos: List<String>
) : Parcelable
