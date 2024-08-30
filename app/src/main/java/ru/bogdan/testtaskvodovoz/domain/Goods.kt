package ru.bogdan.testtaskvodovoz.domain



data class Goods(
    val goods: List<Product>,
    val id: Long,
    val categoryTitle: String
)
