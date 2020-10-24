package uz.smd.furor.ui

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mysoftpanda.android.onlinelessonxiihomework.utils.extensions.inflate
import kotlinx.android.synthetic.main.item_task.view.*
import uz.smd.furor.R
import uz.smd.furor.data.entities.Tasks
import uz.smd.furor.utils.*

class ContactAdapter : ListAdapter<Tasks, ContactAdapter.ViewHolder>(DiffUtillCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.item_task))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val leftLayout = itemView.layoutLeft
        val newImage = itemView.imageNew
        val nameText = itemView.textName
        val executorText = itemView.textExecutor
        val statusText = itemView.textStatus
        val typeText = itemView.textType
        val dateText = itemView.textDate

        @SuppressLint("SetTextI18n")
        fun bind() = bindItem {
            val d = getItem(adapterPosition)
            when (d.task_priorities_id) {
                1 -> {
                    leftLayout.setBackgroundColor(Color.GREEN)
                }
                2 -> {
                    leftLayout.setBackgroundColor(Color.YELLOW)
                }
                3 -> {
                    leftLayout.setBackgroundColor(Color.RED)
                }
                else -> {
                    leftLayout.setBackgroundColor(Color.BLACK)
                }
            }

            if (d.task_statuses_id == 1) {
                newImage.visible()
            } else {
                newImage.gone()
            }
            nameText.text = d.name ?: "Nomalum"
            executorText.text = d.curr_executor_name ?: "Nomalum"
            statusText.text = d.task_statuses_name
            typeText.text = d.task_types_name
            dateText.text = convertLongToTime(d.created_date ?: 1602498517000)
        }

    }
}

class DiffUtillCallBack : DiffUtil.ItemCallback<Tasks>() {
    override fun areItemsTheSame(oldItem: Tasks, newItem: Tasks): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Tasks, newItem: Tasks): Boolean {
        return oldItem == newItem && oldItem.name == newItem.name && oldItem.task_types_id == newItem.task_types_id
                && oldItem.task_statuses_id == newItem.task_statuses_id
                && oldItem.task_priorities_id == newItem.task_priorities_id

    }

}