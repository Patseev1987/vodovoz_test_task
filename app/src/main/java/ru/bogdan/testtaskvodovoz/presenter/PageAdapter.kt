package ru.bogdan.testtaskvodovoz.presenter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.bogdan.testtaskvodovoz.domain.Goods
import ru.bogdan.testtaskvodovoz.domain.VodovozResponse

class PageAdapter(private val goods:List<Goods>, fragment: FragmentActivity) :
    FragmentStateAdapter(fragment) {


    override fun getItemCount(): Int {
        return goods.size
    }

    override fun createFragment(position: Int): Fragment {
        return GoodsRecycleViewFragment.newInstance(position)
    }
}