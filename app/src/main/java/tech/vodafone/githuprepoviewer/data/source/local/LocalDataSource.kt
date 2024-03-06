package tech.vodafone.githuprepoviewer.data.source.local

import kotlinx.coroutines.flow.Flow
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponseModel

interface LocalDataSource{

    fun getCash(): Flow<List<RepositoriesResponseModel>>

    suspend fun insertCash(cash: RepositoriesResponseModel)

    fun getCashCount(): Int

}