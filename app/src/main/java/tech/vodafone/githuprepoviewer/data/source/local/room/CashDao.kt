//package tech.vodafone.githuprepoviewer.data.source.local.room
//
//import androidx.room.Dao
//import androidx.room.Query
//import androidx.room.Upsert
//import kotlinx.coroutines.flow.Flow
//import tech.vodafone.githuprepoviewer.data.source.dto.CashEntity
//
//@Dao
//interface CashDao {
//
//    @Query("SELECT * FROM cash_table WHERE cityName =:cityName")
//    fun getCash(cityName:String): Flow<CashEntity>
//
//    @Upsert
//    suspend fun insertCash(cash: CashEntity)
//
//    @Query("DELETE FROM cash_table WHERE createdAt < :createdAt")
//    suspend fun deleteCash(createdAt: Long)
//
//
//}