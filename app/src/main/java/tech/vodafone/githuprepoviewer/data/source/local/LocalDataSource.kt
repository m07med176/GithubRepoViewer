package tech.vodafone.githuprepoviewer.data.source.local

import androidx.paging.PagingSource
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponseModel

interface LocalDataSource{

    fun getPagingCash(): PagingSource<Int, RepositoriesResponseModel>

    suspend fun insertCash(cash: List<RepositoriesResponseModel>)

    fun getCashCount(): Int

}