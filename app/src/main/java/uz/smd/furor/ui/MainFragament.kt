package uz.smd.furor.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_contact.*
//import com.mysoftpanda.android.onlineexam.R
//import com.mysoftpanda.android.onlineexam.contact.CardVerifyFragment
//import com.mysoftpanda.android.onlineexam.contact.utils.ExpiryDateTextWatcher
//import com.mysoftpanda.android.onlineexam.data.entities.AddCardData
//import com.mysoftpanda.android.onlineexam.data.local.LocalStorage
//import com.mysoftpanda.android.onlineexam.data.retrofit.addCard
//import com.mysoftpanda.android.onlineexam.data.retrofit.showMessage
//import com.mysoftpanda.android.onlineexam.utils.*
//import com.mysoftpanda.android.onlineexam.utils.extensions.didClickButton
//import kotlinx.android.synthetic.main.fragment_add_card.*
//import kotlinx.android.synthetic.main.fragment_add_card.indicator
//import kotlinx.android.synthetic.main.fragment_add_card.pager
import uz.smd.furor.R
import uz.smd.furor.app.App
import uz.smd.furor.data.entities.Tasks
import uz.smd.furor.data.local.AppDatabase
import uz.smd.furor.data.local.LocalStorage
import uz.smd.furor.data.retrofit.extensions.showDialog
import uz.smd.furor.utils.*

class MainFragament : Fragment(R.layout.fragment_contact) {

    private val viewModel: MainViewModel by lazy { MainViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        animateSlide()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textNoData.gone()
        clickListener()
    }

    fun loadView() {
        viewModel.loadView {
            var adapter = IntoPagerAdapter(requireActivity(), it)
            pager.adapter = adapter
            indicator.setViewPager2(pager)
        }
    }

    private fun clickListener() {
        btnFilter.setOnClickListener { next(FilterFragment(), "ok") }
    }

    fun setData(priority: List<Int>, type: List<Int>, status: List<Int>) {
        viewModel.setData(priority, type, status) {
            if (it.isEmpty()) {
                textNoData.visible()
            } else
                textNoData.gone()
            var adapter = IntoPagerAdapter(requireActivity(), it)
            pager.adapter = adapter
            indicator.setViewPager2(pager)
        }
    }
}