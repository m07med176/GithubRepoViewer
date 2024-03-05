//package tech.vodafone.githuprepoviewer.data.source.local.room
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import androidx.room.TypeConverters
//import tech.vodafone.githuprepoviewer.data.source.dto.CashEntity
//import tech.vodafone.githuprepoviewer.data.source.local.LocalConstant
//
//@Database(
//    entities = [CashEntity::class],
//    version = LocalConstant.DB_VERSION,
//    exportSchema = false
//)
//@TypeConverters(CashConverters::class)
//abstract class RoomDB : RoomDatabase() {
//    abstract fun cashDao(): CashDao
//
//    companion object {
//        @Volatile
//        private var instance: RoomDB? = null
//        private val LOCK = Any()
//
//        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
//            instance ?: createDatabase(context).also { instance = it }
//        }
//
//        private fun createDatabase(context: Context) =
//            Room.databaseBuilder(
//                context.applicationContext,
//                RoomDB::class.java,
//                LocalConstant.DB_NAME
//            )
//                .fallbackToDestructiveMigration()
//                .build()
//    }
//}