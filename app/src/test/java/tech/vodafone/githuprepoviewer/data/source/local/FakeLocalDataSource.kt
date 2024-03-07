package tech.vodafone.githuprepoviewer.data.source.local

import org.junit.Assert.*

import org.junit.Test
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponseModel

class FakeLocalDataSource(private val localDataSource: LocalDataSource) {

    fun getPagingCash(limit: Int, offset: Int):  List<RepositoriesResponseModel> = localDataSource.getPagingCash(limit,offset)

    fun searchReposByName(searchQuery: String, limit: Int, offset: Int): List<RepositoriesResponseModel> = localDataSource.searchReposByName(searchQuery,limit,offset)

    suspend fun insertCash(cash: List<RepositoriesResponseModel>) {
        localDataSource.insertCash(cash)
    }

    fun getCashCount(): Int = localDataSource.getCashCount()
}