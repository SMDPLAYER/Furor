package uz.smd.furor.ui

import uz.smd.furor.app.App
import uz.smd.furor.data.entities.Tasks
import uz.smd.furor.data.local.AppDatabase
import uz.smd.furor.utils.runOnUIThread

import uz.smd.furor.utils.runOnWorkerThread

class MainViewModel  {
    val tasksDao = AppDatabase.getDatabase(App.instance).taskDao()

    fun setData(
        priority: List<Int>,
        type: List<Int>,
        status: List<Int>,
        block: (List<Tasks>) -> Unit
    ) {
        runOnWorkerThread {
            val tasks = tasksDao.getAllTasks()
            val typed = tasks.filter { task ->
                if (task.task_priorities_id == null) {
                    when {
                        type.isEmpty() && status.isEmpty() && priority.isEmpty() -> {
                            true
                        }
                        type.isEmpty() && status.isEmpty() -> {
                            false
                        }
                        type.isEmpty() -> {
                            status.contains(2131230838 + task.task_statuses_id!!)
                        }
                        status.isEmpty() -> {
                            type.contains(2131230834 + task.task_types_id!!)
                        }
                        else -> type.contains(2131230834 + task.task_types_id!!)
                                && status.contains(2131230838 + task.task_statuses_id!!)
                    }

                } else {
                    when {
                        type.isEmpty() && status.isEmpty() && priority.isEmpty() -> {
                            true
                        }
                        type.isEmpty() && status.isEmpty() -> {
                            priority.contains(2131230724 + task.task_priorities_id!!)
                        }
                        type.isEmpty() && priority.isEmpty() -> {
                            status.contains(2131230838 + task.task_statuses_id!!)
                        }
                        status.isEmpty() && priority.isEmpty() -> {
                            type.contains(2131230834 + task.task_types_id!!)
                        }
                        type.isEmpty() -> {
                            status.contains(2131230838 + task.task_statuses_id!!)
                                    && priority.contains(2131230724 + task.task_priorities_id!!)
                        }
                        status.isEmpty() -> {
                            type.contains(2131230834 + task.task_types_id!!)
                                    && priority.contains(2131230724 + task.task_priorities_id!!)
                        }
                        priority.isEmpty() -> {
                            type.contains(2131230834 + task.task_types_id!!)
                                    && status.contains(2131230838 + task.task_statuses_id!!)
                        }
                        else -> {
                            type.contains(2131230834 + task.task_types_id!!)
                                    && status.contains(2131230838 + task.task_statuses_id!!)
                                    && priority.contains(2131230724 + task.task_priorities_id!!)
                        }
                    }
                }
            }
            runOnUIThread {    block(typed) }

        }
    }

    fun loadView(block: (List<Tasks>) -> Unit) {
        runOnWorkerThread {
            val tasks = tasksDao.getAllTasks()
            runOnUIThread {
                block(tasks)
            }
        }
    }

}