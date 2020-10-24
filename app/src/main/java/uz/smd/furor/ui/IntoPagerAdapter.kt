package uz.smd.furor.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.smd.furor.data.entities.Tasks


class IntoPagerAdapter(activity: FragmentActivity, val value: List<Tasks>?) :
    FragmentStateAdapter(activity) {

    private val fragments = ArrayList<ItemFragment>().apply {
        for (i in value!!.chunked(10).indices) {
            add(ItemFragment())
        }
    }

    override fun getItemCount(): Int = value!!.chunked(10).size
    override fun createFragment(position: Int): Fragment = fragments[position].apply {
        this.setdata(value!!.chunked(10)[position])

    }


}