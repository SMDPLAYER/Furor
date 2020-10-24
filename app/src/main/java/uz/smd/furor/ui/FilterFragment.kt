package uz.smd.furor.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.chips_layout.*
import uz.smd.furor.R
import uz.smd.furor.utils.next

class FilterFragment : Fragment(R.layout.chips_layout) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickHandker()
    }

    private fun clickHandker() {
        btnBack.setOnClickListener {
            next(MainFragament().apply {
                this.loadView()
            })
        }
        buttonFilter.setOnClickListener {
            val type = ChipsType.checkedChipIds
            val status = ChipsStatus.checkedChipIds
            val priority=ChipsPriority.checkedChipIds

            next(MainFragament().apply {
                this.setData(priority,type,status)
            })
        }

    }
}