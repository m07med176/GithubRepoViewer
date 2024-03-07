package tech.vodafone.githuprepoviewer.data.source.local.room

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponseModel

@Dao
interface CashDao {

    @Query("SELECT * FROM cash_table ORDER BY id ASC LIMIT :limit OFFSET :offset")
    fun getRepos(limit: Int, offset: Int): List<RepositoriesResponseModel>

    @Query("SELECT * FROM cash_table WHERE name LIKE '%' || :searchQuery || '%' ORDER BY id ASC LIMIT :limit OFFSET :offset")
    fun searchReposByName(searchQuery: String, limit: Int, offset: Int): List<RepositoriesResponseModel>
    @Query("SELECT * FROM cash_table")
    fun getPagingCash2(): PagingSource<Int,RepositoriesResponseModel>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCash(cash: List<RepositoriesResponseModel>)

    @Query("DELETE FROM cash_table")
    suspend fun deleteCash()

    @Query("SELECT COUNT(*) FROM cash_table")
    fun getCashCount(): Int

}