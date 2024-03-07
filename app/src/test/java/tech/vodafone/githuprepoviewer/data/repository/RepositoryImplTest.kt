package tech.vodafone.githuprepoviewer.data.repository

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponseModel
import tech.vodafone.githuprepoviewer.data.source.dto.toDomainModel
import tech.vodafone.githuprepoviewer.data.source.local.LocalDataSource
import tech.vodafone.githuprepoviewer.data.source.remote.RemoteDataSource
import tech.vodafone.githuprepoviewer.di.IoDispatcher
import tech.vodafone.githuprepoviewer.domain.repositories.Repository
import javax.inject.Inject

@ExperimentalCoroutinesApi
class RepositoryImplTest {
    @Mock
    lateinit var repository: Repository


    lateinit var fakeRepository:FakeRepository
    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        fakeRepository = FakeRepository(repository)
    }

    @Test
    fun testGetTotalCashCount() {
        // Define the behavior of the mock object
        Mockito.`when`(fakeRepository.getCashCount()).thenReturn(100)

        // Perform the test
        val result = fakeRepository.getCashCount()

        // Verify the result
        assertEquals(100, result)
    }

    @Test
    fun `test insertCash`() = runBlockingTest {
        // Mock your repository or any dependencies
        val cashList = listOf(
            RepositoriesResponseModel(id = 0,name = "repo1"),
            RepositoriesResponseModel(id = 2,name = "repo2")
        ).map { it.toDomainModel() }

        // Stubbing the behavior of the suspending function
        Mockito.`when`(repository.insertCash(cashList)).thenReturn(Unit)

        // Call the function under test
        fakeRepository.insertCash(cashList)

        // Verify the interactions and assertions
        Mockito.verify(repository).insertCash(cashList)
    }

}