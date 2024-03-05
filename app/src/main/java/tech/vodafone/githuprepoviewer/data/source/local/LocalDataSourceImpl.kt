//package tech.vodafone.githuprepoviewer.data.source.local
//
//import tech.vodafone.githuprepoviewer.data.source.local.room.CashDao
//import kotlinx.coroutines.flow.Flow
//import tech.vodafone.githuprepoviewer.data.source.dto.CashEntity
//
//class LocalDataSourceImpl(
//    private val db: CashDao
//) : LocalDataSource {
//
//    override fun getCash(city:String): Flow<CashEntity>  = db.getCash(city)
//
//    override suspend fun insertCash(cash: CashEntity) {
//        db.insertCash(cash)
//    }
//
//}