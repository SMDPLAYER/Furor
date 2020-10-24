package uz.smd.furor.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import uz.smd.furor.data.entities.Statuses

@Dao
interface StatusesDao : BaseDao<Statuses> {
    @Query("SELECT * FROM Statuses")
    fun getAllProducts(): List<Statuses>

    @Query("DELETE FROM Statuses")
    fun clearDB()
}