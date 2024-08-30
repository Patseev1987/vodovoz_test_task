package ru.bogdan.testtaskvodovoz.presenter

import ru.bogdan.testtaskvodovoz.domain.Product

sealed interface MainUIAction {

    data class RedirectToProduct(val product: Product): MainUIAction

}