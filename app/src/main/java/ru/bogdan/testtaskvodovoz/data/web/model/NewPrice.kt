package ru.bogdan.testtaskvodovoz.data.web.model


import com.google.gson.annotations.SerializedName

data class NewPrice(
    @SerializedName("DescPrice")
    val descPrice: String,
    @SerializedName("Price")
    val price: String
)