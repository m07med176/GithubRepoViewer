package tech.vodafone.githuprepoviewer.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponseModel
import tech.vodafone.githuprepoviewer.data.source.local.LocalConfig

@Database(
    entities = [RepositoriesResponseModel::class],
    version = LocalConfig.DB_VERSION,
    exportSchema = false
)
@TypeConverters(CashConverters::class)
abstract class RoomDB : RoomDatabase() {
    abstract fun cashDao(): CashDao

    companion object {
        @Volatile
        private var instance: RoomDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                RoomDB::class.java,
                LocalConfig.DB_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
    }
}