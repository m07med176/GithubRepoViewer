package tech.vodafone.githuprepoviewer.data.source.local

import androidx.paging.PagingSource
import kotlinx.coroutines.flow.Flow
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponseModel

interface LocalDataSource{

    fun getPagingCash(limit: Int, offset: Int):  List<RepositoriesResponseModel>

    fun searchReposByName(searchQuery: String, limit: Int, offset: Int): List<RepositoriesResponseModel>

    suspend fun insertCash(cash: List<RepositoriesResponseModel>)

    fun getCashCount(): Int

}