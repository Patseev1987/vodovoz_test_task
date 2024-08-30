package ru.bogdan.testtaskvodovoz.presenter

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.bogdan.testtaskvodovoz.R
import ru.bogdan.testtaskvodovoz.databinding.FragmentGoodsRecycleViewBinding
import ru.bogdan.testtaskvodovoz.domain.Product
import ru.bogdan.testtaskvodovoz.presenter.adapter.ProductAdapter


class GoodsRecycleViewFragment : Fragment(R.layout.fragment_goods_recycle_view) {
    private val binding by viewBinding(FragmentGoodsRecycleViewBinding::bind)
    private var products: List<Product> = listOf()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArg()
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
    
    private fun initView() {
        val adapter = ProductAdapter {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .replace(
                    R.id.fragment_container,
                    PhotosFragment.getFragment(it.photos?.photos ?: listOf())
                )
                .commit()
        }
        binding.apply {
            goodsRc.adapter = adapter
        }
        adapter.submitList(products)
    }
    
    private fun parseArg() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            products =
                requireArguments().getParcelableArray(PRODUCTS, Product::class.java)?.toList()
                    ?: listOf()
        } else {
            products = requireArguments().getParcelableArray(PRODUCTS)?.toList() as List<Product>
        }
    }
    
    companion object {
        private const val PRODUCTS = "products"
        
        @JvmStatic
        fun newInstance(products: List<Product>) =
            GoodsRecycleViewFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArray(PRODUCTS, products.toTypedArray())
                }
            }
    }
}