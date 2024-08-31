package ru.bogdan.testtaskvodovoz.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.bogdan.testtaskvodovoz.R
import ru.bogdan.testtaskvodovoz.databinding.ItemProductBinding
import ru.bogdan.testtaskvodovoz.domain.Product

class ProductAdapter(
    private val onClickListener: ((Product) -> Unit)? = null,
    private val onFavoriteClickListener: ((Product, Int) -> Unit)? = null
) :
    ListAdapter<Product, ProductAdapter.ProductViewHolder>(
        DiffCallbackProduct()
    ) {
    
    override fun onBindViewHolder(p0: ProductViewHolder, p1: Int) {
        val product = getItem(p1)
        p0.bind(product, onClickListener, p1)
    }
    
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(p0.context)
        val binding = ItemProductBinding.inflate(inflater, p0, false)
        return ProductViewHolder(binding)
    }
    
    inner class ProductViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product, onClickListener: ((Product) -> Unit)? = null, position: Int) {
            with(binding) {
                Glide.with(root)
                    .load(product.picture)
                    .placeholder(R.drawable.vodovoz_icon)
                    .centerInside()
                    .into(image)
                
                tvPrice.text = product.price.price.toString()
                if (product.isFavorite) {
                    favoriteNotPressed.visibility = View.GONE
                    favoritePressed.visibility = View.VISIBLE
                    favoritePressed.setOnClickListener {
                        onFavoriteClickListener?.invoke(product, position)
                    }
                } else {
                    favoriteNotPressed.visibility = View.VISIBLE
                    favoritePressed.visibility = View.GONE
                    favoriteNotPressed.setOnClickListener {
                        onFavoriteClickListener?.invoke(product, position)
                    }
                }
                root.setOnClickListener {
                    onClickListener?.invoke(product)
                }
            }
        }
    }
}