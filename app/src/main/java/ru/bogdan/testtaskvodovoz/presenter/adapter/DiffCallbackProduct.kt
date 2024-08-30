package ru.bogdan.testtaskvodovoz.presenter.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.bogdan.testtaskvodovoz.domain.Product

class DiffCallbackProduct : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(p0: Product, p1: Product): Boolean {
        return p0 == p1
    }

    override fun areContentsTheSame(p0: Product, p1: Product): Boolean {
        return p0 == p1
    }

}