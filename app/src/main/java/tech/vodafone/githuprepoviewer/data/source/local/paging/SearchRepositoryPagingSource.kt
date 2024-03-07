package tech.vodafone.githuprepoviewer.data.source.local.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import tech.vodafone.githuprepoviewer.data.source.dto.toDomainModel
import tech.vodafone.githuprepoviewer.data.source.local.LocalDataSource
import tech.vodafone.githuprepoviewer.domain.entities.ReposEntity

class SearchRepositoryPagingSource(
    private val db: LocalDataSource,
    private val ioDataSource: CoroutineDispatcher,
    private val searchQuery: String
) : PagingSource<Int, ReposEntity>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ReposEntity> {
        val page = params.key ?: 0

        return try {
            withContext(ioDataSource) {
                val entities = db.searchReposByName(
                    searchQuery = searchQuery,
                    limit = params.loadSize,
                    offset = page * params.loadSize
                )
                    .map { it.toDomainModel() }
                if (page != 0) delay(1000)

                LoadResult.Page(
                    data = entities,
                    prevKey = if (page == 0) null else page - 1,
                    nextKey = if (entities.isEmpty()) null else page + 1
                )
            }

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ReposEntity>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}