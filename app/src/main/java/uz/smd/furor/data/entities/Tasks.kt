package uz.smd.furor.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Tasks(
    @PrimaryKey
    var id: Int ,
    var name_ru: String?,
    var name_uk: String?,
    var name_uz: String?,
    var name: String ?,
    var parent_id: Int?,
    var description: String?,
    var task_statuses_id: Int?,
    var task_types_id: Int ?,
    var task_priorities_id: Int ?,
    var task_platforms_id: Int ?,
    var curr_executor_id: Int?,
    var expired_date: Long?,
    var created_date: Long ?,
    var created_users_id: Int ?,
    var date_end: Long?,
    var ordering: Int?,
    var is_editable: Int ?,
    var task_ranks_id: Int?,
    var task_ranks_name: String?,
    var task_ranks_color: String?,
    var task_ranks_icon: String?,
    var task_statuses_ids: Int?,
    var task_code: String ?,
    var projects_id: Int ?,
    var projects_name: String ?,
    var projects_short_name: String ?,
    var projects_color: String ?,
    var parent_name: String ?,
    var task_statuses_name: String ?,
    var task_statuses_icon: String ?,
    var task_statuses_color: String ?,
    var task_types_name: String ?,
    var task_types_icon: String ?,
    var task_types_color: String ?,
    var task_priorities_name: String ?,
    var task_priorities_icon: String ?,
    var task_priorities_color: String ?,
    var task_platforms_name: String ?,
    var task_platforms_icon: String ?,
    var task_platforms_color: String?,
    var curr_executor_name: String?,
    var curr_executor_resources_id: String?,
    var created_users_name: String?,
    var created_user_resources_id: Int ?,
    var is_late: Int?,
    var left_days: Int?,
    var hard_index: Int = 1,
    var undone_tasks: Int = 0,
    var status_description: String?,
    var parent_task_code: String?,
    var parent_task_name: String?,
    var task_status_date: Long ?,
    var start_date: Long?,
    var active_days: Int?,
    var is_set_executor: String?,
    var is_done_task: String?,
    var project_categories_name: String ?,
    var project_categories_icon: String ?,
    var project_categories_color: String ?,
    var file_ids: Int?
)