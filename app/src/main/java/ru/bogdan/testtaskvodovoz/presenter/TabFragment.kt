package ru.bogdan.testtaskvodovoz.presenter

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import ru.bogdan.testtaskvodovoz.R
import ru.bogdan.testtaskvodovoz.databinding.FragmentTabBinding
import ru.bogdan.testtaskvodovoz.domain.Goods

class TabFragment : Fragment(R.layout.fragment_tab) {
    private val binding by viewBinding(FragmentTabBinding::bind)
    private lateinit var goods: List<Goods>
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PageAdapter(goods = goods, this.requireActivity())
        binding.apply {
            viewPager.adapter = adapter
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = goods[position].categoryTitle
            }.attach()
        }
    }
    
    private fun parseArgs() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            goods =
                requireArguments().getParcelableArray(GOODS, Goods::class.java)?.toList()
                    ?: listOf()
        } else {
            goods = requireArguments().getParcelableArray(GOODS)?.toList() as List<Goods>
        }
    }
    
    companion object {
        private const val GOODS = "goods"
        fun getFragment(goods: List<Goods>) = TabFragment().apply {
            arguments = Bundle().apply {
                putParcelableArray(GOODS, goods.toTypedArray())
            }
        }
    }
    
}