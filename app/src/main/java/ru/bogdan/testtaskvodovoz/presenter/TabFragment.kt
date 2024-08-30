package ru.bogdan.testtaskvodovoz.presenter

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import ru.bogdan.testtaskvodovoz.R
import ru.bogdan.testtaskvodovoz.databinding.FragmentTabBinding
import ru.bogdan.testtaskvodovoz.domain.Goods
import ru.bogdan.testtaskvodovoz.domain.Product

class TabFragment : Fragment(R.layout.fragment_tab) {
    private val binding by viewBinding(FragmentTabBinding::bind)
    private lateinit var goods: List<Goods>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PageAdapter(goods = goods, this.requireActivity())
        binding.apply {
            parseArgs()
            viewPager.adapter = adapter
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = goods[position].categoryTitle
            }.attach()
        }
    }

    private fun parseArgs(){
        goods = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
             requireArguments().getParcelableArray(GOODS,Goods::class.java)?.toList() ?: listOf()
        else requireArguments().getParcelableArray(GOODS)?.toList() as List<Goods>
    }

    companion object {
        private const val GOODS = "goods"
        fun getFragment(goods:List<Goods>) = TabFragment().apply {
            requireArguments().putParcelableArray(GOODS,goods.toTypedArray())
        }
    }

}