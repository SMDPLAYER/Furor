package uz.smd.furor.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.item_recycle.*
import uz.smd.furor.R
import uz.smd.furor.data.entities.Tasks
import uz.smd.furor.utils.animateSlide


class ItemFragment : Fragment(R.layout.item_recycle) {

    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        animateSlide()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val llm = LinearLayoutManager(requireContext())
        llm.orientation = LinearLayoutManager.VERTICAL
        list.layoutManager = llm
        list.adapter = adapter
    }
    fun setdata(list: List<Tasks>) {
        adapter.submitList(list)}

}