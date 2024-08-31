package ru.bogdan.testtaskvodovoz.presenter.mainFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.launch
import ru.bogdan.testtaskvodovoz.R
import ru.bogdan.testtaskvodovoz.databinding.FragmentMainBinding
import ru.bogdan.testtaskvodovoz.di.DaggerApplicationComponent
import ru.bogdan.testtaskvodovoz.domain.Goods
import ru.bogdan.testtaskvodovoz.presenter.ViewModelFactory
import ru.bogdan.testtaskvodovoz.presenter.tabFragment.TabFragment
import javax.inject.Inject


class MainFragment : Fragment(R.layout.fragment_main) {
    private val binding by viewBinding(FragmentMainBinding::bind)
    
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    
    private val component = DaggerApplicationComponent.create()
    
    
    private val viewModel by lazy {
        ViewModelProvider(this, factory = viewModelFactory)[MainViewModel::class.java]
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        component.inject(this)
        observeViewModel()
    }
    
    private fun observeViewModel() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.state.collect {
                    with(binding) {
                        fakeData1.text = it.fakeData
                        fakeData2.text = it.fakeData
                        
                        if (it.isSuccess) {
                            placeHolder.visibility = View.VISIBLE
                            initView(it.goods)
                            btnChange.text = getString(R.string.error)
                            btnChange.setOnClickListener {
                                viewModel.makeError()
                            }
                        } else {
                            placeHolder.visibility = View.GONE
                            btnChange.text = getString(R.string.success)
                            btnChange.setOnClickListener {
                                viewModel.updateData()
                            }
                        }
                    }
                }
            }
        }
    }
    
    private fun initView(goods: List<Goods>) {
        requireActivity().supportFragmentManager.beginTransaction().replace(
            R.id.placeHolder,
            TabFragment.getFragment(goods)
        ).commit()
    }
    
}