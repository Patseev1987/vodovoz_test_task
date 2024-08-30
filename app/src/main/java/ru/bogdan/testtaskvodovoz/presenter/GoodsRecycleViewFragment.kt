package ru.bogdan.testtaskvodovoz.presenter

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
import ru.bogdan.testtaskvodovoz.databinding.FragmentGoodsRecycleViewBinding
import ru.bogdan.testtaskvodovoz.presenter.adapter.ProductAdapter


class GoodsRecycleViewFragment : Fragment(R.layout.fragment_goods_recycle_view) {
    private val binding by viewBinding(FragmentGoodsRecycleViewBinding::bind)
    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }
    private val adapter by lazy {
        ProductAdapter()
    }
    private var position = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        position = requireArguments().getInt(POSITION)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeViewModel(viewModel)
    }

    private fun initView() {
        binding.apply {
            goodsRc.adapter = adapter
        }
    }

    private fun observeViewModel(viewModel: MainViewModel) {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.state.collect { state ->
                    with(binding) {
                        goodsRc.visibility = View.VISIBLE
                        adapter.submitList(state.goods[position].goods)
                        adapter.onClickListener = {
                        }
                    }
                }
            }
        }
    }


    companion object {
        private const val POSITION = "position"

        @JvmStatic
        fun newInstance(position: Int) =
            GoodsRecycleViewFragment().apply {
                arguments = Bundle().apply {
                    putInt(POSITION, position)
                }
            }
    }
}