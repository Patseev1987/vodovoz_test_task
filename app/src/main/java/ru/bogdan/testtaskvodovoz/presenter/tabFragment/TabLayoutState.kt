package ru.bogdan.testtaskvodovoz.presenter.tabFragment

import ru.bogdan.testtaskvodovoz.domain.Product

sealed interface TabLayoutState {
    
    data object Loading : TabLayoutState
    
    data class Result(val products: List<Product>, val position: Int? = null) : TabLayoutState
    
}