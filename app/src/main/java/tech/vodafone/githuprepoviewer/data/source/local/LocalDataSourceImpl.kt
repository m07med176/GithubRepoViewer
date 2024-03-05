package tech.vodafone.githuprepoviewer.data.source.local

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import tech.vodafone.githuprepoviewer.data.source.local.room.CashDao
import kotlinx.coroutines.flow.Flow
import tech.vodafone.githuprepoviewer.data.source.dto.CashEntity

class LocalDataSourceImpl(
    private val db: CashDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : LocalDataSource {

    override fun getCash(city:String): Flow<CashEntity>  = db.getCash(city)

    override suspend fun insertCash(cash: CashEntity) {
        db.insertCash(cash)
    }

}