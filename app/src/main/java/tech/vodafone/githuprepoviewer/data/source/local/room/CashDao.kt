package tech.vodafone.githuprepoviewer.data.source.local.room

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponseModel

@Dao
interface CashDao {

    @Query("SELECT * FROM cash_table")
    fun getPagingCash(): PagingSource<Int,RepositoriesResponseModel>

//    @Upsert
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCash(cash: List<RepositoriesResponseModel>)

    @Query("DELETE FROM cash_table")
    suspend fun deleteCash()

    @Query("SELECT COUNT(*) FROM cash_table")
    fun getCashCount(): Int

}