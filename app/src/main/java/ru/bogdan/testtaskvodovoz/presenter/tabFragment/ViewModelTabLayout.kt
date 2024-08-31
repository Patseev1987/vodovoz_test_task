package ru.bogdan.testtaskvodovoz.presenter.tabFragment

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.bogdan.testtaskvodovoz.domain.Goods
import ru.bogdan.testtaskvodovoz.domain.Product
import javax.inject.Inject

class ViewModelTabLayout @Inject constructor() : ViewModel() {
    private var goods: List<Goods> = listOf()
    private val _state: MutableStateFlow<TabLayoutState> = MutableStateFlow(TabLayoutState.Loading)
    val state = _state.asStateFlow()
    
    fun setData(goods: List<Goods>) {
        this.goods = goods
        getProductInFirstCategory()
    }
    
    fun getCategoryName(): List<String> = goods.map { it.categoryTitle }
    
    fun getProductsInCategory(title: String, position: Int? = null) {
        _state.value = TabLayoutState.Loading
        val products = goods.first { it.categoryTitle == title }.goods
        _state.value = TabLayoutState.Result(products, position)
    }
    
    private fun getProductInFirstCategory() {
        _state.value = TabLayoutState.Loading
        val products = goods[0].goods
        _state.value = TabLayoutState.Result(products)
    }
    
    fun changeFavoriteIcon(product: Product, position: Int) {
        var ctg = ""
        goods = goods.map {
            it.goods.map { prd ->
                if (prd == product) {
                    ctg = it.categoryTitle
                    prd.isFavorite = !prd.isFavorite
                }
                prd
            }
            it
        }
        getProductsInCategory(ctg, position)
        
    }
    
}