package ru.bogdan.testtaskvodovoz.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.bogdan.testtaskvodovoz.R
import ru.bogdan.testtaskvodovoz.databinding.FragmentMainBinding
import ru.bogdan.testtaskvodovoz.domain.Goods


class MainFragment : Fragment(R.layout.fragment_main) {
    private val binding by viewBinding(FragmentMainBinding::bind)
    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       observeViewModel()
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED){
                viewModel.state.collect{
                    if (it.isSuccess){
                        binding.placeHolder.visibility = View.VISIBLE
                        initView(it.goods)
                    }else {
                        binding.placeHolder.visibility = View.GONE
                    }
                }
            }
        }
    }

    private fun initView(goods:List<Goods>) {
        requireActivity().supportFragmentManager.beginTransaction().add(
            R.id.placeHolder,
            TabFragment.getFragment(goods)
        ).commit()
    }

}