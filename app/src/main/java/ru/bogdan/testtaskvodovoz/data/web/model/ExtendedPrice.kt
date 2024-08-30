package ru.bogdan.testtaskvodovoz.data.web.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class ExtendedPrice(
    @SerializedName("OLD_PRICE")
    val oldPrice: Int,
    @SerializedName("PRICE")
    val price: Int,
    @SerializedName("QUANTITY_FROM")
    val quantityFrom: Int,
    @SerializedName("QUANTITY_TO")
    val quantityTo: Int
) : Parcelable
