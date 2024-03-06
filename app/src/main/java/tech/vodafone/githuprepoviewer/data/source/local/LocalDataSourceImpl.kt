package tech.vodafone.githuprepoviewer.data.source.local

import androidx.paging.PagingSource
import tech.vodafone.githuprepoviewer.data.source.local.room.CashDao
import kotlinx.coroutines.flow.Flow
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponseModel

class LocalDataSourceImpl(
    private val db: CashDao,
    ) : LocalDataSource {

    override fun getPagingCash(): PagingSource<Int,RepositoriesResponseModel> = db.getPagingCash()
    override suspend fun insertCash(cash: List<RepositoriesResponseModel>) {
        db.insertCash(cash)
    }

    override fun getCashCount(): Int  = db.getCashCount()


}