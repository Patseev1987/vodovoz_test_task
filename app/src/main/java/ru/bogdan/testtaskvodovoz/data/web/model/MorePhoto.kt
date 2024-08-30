package ru.bogdan.testtaskvodovoz.data.web.model


import com.google.gson.annotations.SerializedName

data class MorePhoto(
    @SerializedName("VALUE")
    val value: List<String>
)