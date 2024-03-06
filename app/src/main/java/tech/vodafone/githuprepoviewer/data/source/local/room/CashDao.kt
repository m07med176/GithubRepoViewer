package tech.vodafone.githuprepoviewer.data.source.local.room

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponseModel

@Dao
interface CashDao {

    @Query("SELECT * FROM cash_table")
    fun getCash(): Flow<List<RepositoriesResponseModel>>

    @Upsert
    suspend fun insertCash(cash: RepositoriesResponseModel)

    @Query("DELETE FROM cash_table")
    suspend fun deleteCash()

    @Query("SELECT COUNT(*) FROM cash_table")
    fun getCashCount(): Int

}