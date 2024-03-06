package tech.vodafone.githuprepoviewer.data.source.local

import tech.vodafone.githuprepoviewer.data.source.local.room.CashDao
import kotlinx.coroutines.flow.Flow
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponseModel

class LocalDataSourceImpl(
    private val db: CashDao,
    ) : LocalDataSource {

    override fun getCash(): Flow<List<RepositoriesResponseModel>> = db.getCash()
    override suspend fun insertCash(cash: RepositoriesResponseModel) {
        db.insertCash(cash)
    }

    override fun getCashCount(): Int  = db.getCashCount()


}