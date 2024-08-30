package ru.bogdan.testtaskvodovoz.data.web.model


import com.google.gson.annotations.SerializedName

data class ResponseVodovoz(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("TOVARY")
    val tovary: List<Tovary>
){
    companion object{
        const val SUCCESS = "Success"
        const val ERROR = "Error"
    }
}