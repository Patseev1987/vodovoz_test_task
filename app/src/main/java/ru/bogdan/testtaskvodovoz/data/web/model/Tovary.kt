package ru.bogdan.testtaskvodovoz.data.web.model


import com.google.gson.annotations.SerializedName

data class Tovary(
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("ID")
    val id: Long,
    @SerializedName("NAME")
    val name: String
)