package uz.smd.furor.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import uz.smd.furor.data.entities.Types

@Dao
interface TypesDao : BaseDao<Types> {
    @Query("SELECT * FROM Types")
    fun getAllProducts(): List<Types>

    @Query("DELETE FROM Types")
    fun clearDB()
}