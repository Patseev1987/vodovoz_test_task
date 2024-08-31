package ru.bogdan.testtaskvodovoz.presenter.tabFragment

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import kotlinx.coroutines.launch
import ru.bogdan.testtaskvodovoz.R
import ru.bogdan.testtaskvodovoz.databinding.FragmentTabBinding
import ru.bogdan.testtaskvodovoz.di.DaggerApplicationComponent
import ru.bogdan.testtaskvodovoz.domain.Goods
import ru.bogdan.testtaskvodovoz.presenter.ViewModelFactory
import ru.bogdan.testtaskvodovoz.presenter.adapter.ProductAdapter
import ru.bogdan.testtaskvodovoz.presenter.photoFragment.PhotosFragment
import javax.inject.Inject

class TabFragment : Fragment(R.layout.fragment_tab) {
    private val binding by viewBinding(FragmentTabBinding::bind)
    private lateinit var goods: List<Goods>
    private lateinit var adapter: ProductAdapter
    private val component by lazy {
        DaggerApplicationComponent.create()
    }
    
    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, factory)[ViewModelTabLayout::class.java]
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)
        parseArgs()
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeViewModel(binding, viewModel)
    }
    
    private fun parseArgs() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            goods =
                requireArguments().getParcelableArray(GOODS, Goods::class.java)?.toList()
                    ?: listOf()
        } else {
            goods = requireArguments().getParcelableArray(GOODS)?.toList() as List<Goods>
        }
        viewModel.setData(goods)
    }
    
    private fun initView() {
        adapter = ProductAdapter {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .replace(
                    R.id.fragment_container,
                    PhotosFragment.getFragment(it.photos?.photos ?: listOf())
                )
                .commit()
        }
        adapter.submitList(listOf())
        with(binding) {
            goodsRc.adapter = adapter
            
            viewModel.getCategoryName().forEach() { title ->
                tabLayout.addTab(tabLayout.newTab().setText(title))
            }
            
            tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    val title =
                        tab?.text.toString() ?: throw IllegalArgumentException("Unknown tab title")
                    viewModel.getProductsInCategory(title)
                }
                
                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }
                
                override fun onTabReselected(tab: TabLayout.Tab?) {
                }
                
            })
        }
    }
    
    private fun observeViewModel(
        binding: FragmentTabBinding,
        viewModelTabLayout: ViewModelTabLayout
    ) {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModelTabLayout.state.collect {
                    when (val state = it) {
                        TabLayoutState.Loading -> {
                            binding.progressbar.visibility = View.VISIBLE
                        }
                        
                        is TabLayoutState.Result -> {
                            binding.progressbar.visibility = View.GONE
                            adapter.submitList(state.products)
                        }
                    }
                }
            }
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