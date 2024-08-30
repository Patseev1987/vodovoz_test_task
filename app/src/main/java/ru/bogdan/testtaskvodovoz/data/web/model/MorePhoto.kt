package ru.bogdan.testtaskvodovoz.data.web.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MorePhoto(
    @SerializedName("VALUE")
    val value: List<String>
):Parcelable