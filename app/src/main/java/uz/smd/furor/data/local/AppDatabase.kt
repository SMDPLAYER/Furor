package uz.smd.furor.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.smd.furor.data.entities.Priorities
import uz.smd.furor.data.entities.Statuses
import uz.smd.furor.data.entities.Tasks
import uz.smd.furor.data.entities.Types
import uz.smd.furor.data.local.dao.*

@Database(
    entities = [Priorities::class, Statuses::class, Tasks::class, Types::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun balanceDao(): StatusesDao
    abstract fun productDao(): PrioeitiesDao
    abstract fun taskDao(): TasksDao
    abstract fun userDao(): TypesDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}