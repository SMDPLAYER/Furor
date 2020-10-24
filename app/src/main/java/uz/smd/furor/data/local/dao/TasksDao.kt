package uz.smd.furor.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import uz.smd.furor.data.entities.Tasks

@Dao
interface TasksDao : BaseDao<Tasks> {
    @Query("SELECT * FROM Tasks order by id desc")
    fun getAllTasks(): List<Tasks>

    @Query("DELETE FROM Tasks")
    fun clearDB()

}