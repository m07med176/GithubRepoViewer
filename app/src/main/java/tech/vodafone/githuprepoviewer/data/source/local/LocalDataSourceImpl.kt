package tech.vodafone.githuprepoviewer.data.source.local

import androidx.paging.PagingSource
import tech.vodafone.githuprepoviewer.data.source.local.room.CashDao
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponseModel

class LocalDataSourceImpl(
    private val db: CashDao,
    ) : LocalDataSource {

    override fun getPagingCash(limit: Int, offset: Int) = db.getRepos(
        limit = limit,
        offset = offset
    )

    override fun searchReposByName(
        searchQuery: String,
        limit: Int,
        offset: Int
    ): List<RepositoriesResponseModel> = db.searchReposByName(
        limit = limit,
        offset = offset,
        searchQuery = searchQuery
    )
    override suspend fun insertCash(cash: List<RepositoriesResponseModel>) {
        db.insertCash(cash)
    }

    override fun getCashCount(): Int  = db.getCashCount()


}