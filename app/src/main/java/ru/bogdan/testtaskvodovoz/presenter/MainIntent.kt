package ru.bogdan.testtaskvodovoz.presenter

import ru.bogdan.testtaskvodovoz.domain.Product

sealed interface MainIntent {
    data class ProductClicked(val product:Product) : MainIntent

}