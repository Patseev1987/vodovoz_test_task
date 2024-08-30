package ru.bogdan.testtaskvodovoz.data.web.model


import com.google.gson.annotations.SerializedName

data class Nalichie(
    @SerializedName("CVET")
    val cvet: String,
    @SerializedName("NAME")
    val name: String,
    @SerializedName("X")
    val x: String,
    @SerializedName("Y")
    val y: String,
    @SerializedName("Z")
    val z: String
)