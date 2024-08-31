package ru.bogdan.testtaskvodovoz.presenter.tabFragment

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.bogdan.testtaskvodovoz.domain.Goods
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
    
    fun getProductsInCategory(title: String) {
        _state.value = TabLayoutState.Loading
        val products = goods.first { it.categoryTitle == title }.goods
        _state.value = TabLayoutState.Result(products)
    }
    
    private fun getProductInFirstCategory() {
        _state.value = TabLayoutState.Loading
        val products = goods[0].goods
        _state.value = TabLayoutState.Result(products)
        Log.d("TAG", "getProductInFirstCategory")
    }
}