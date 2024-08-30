package ru.bogdan.testtaskvodovoz.domain

data class VodovozResponse(
    val status: String,
    val message: String,
    val goods: List<Goods>
) {
    companion object {
        const val SUCCESS = "Success"
        const val ERROR = "Error"
    }
}
