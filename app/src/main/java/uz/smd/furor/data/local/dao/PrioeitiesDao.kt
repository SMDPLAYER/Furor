package uz.smd.furor.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import uz.smd.furor.data.entities.Priorities

@Dao
interface PrioeitiesDao : BaseDao<Priorities> {
    @Query("SELECT * FROM Priorities")
    fun getAllProducts(): List<Priorities>

    @Query("DELETE FROM Priorities")
    fun clearDB()
}