package tech.vodafone.githuprepoviewer.data.source.local

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponseModel

@ExperimentalCoroutinesApi
class LocalDataSourceImplTest{
    @Mock
    lateinit var localDataSource: LocalDataSource

    lateinit var fakeLocalDataSource: FakeLocalDataSource
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        fakeLocalDataSource = FakeLocalDataSource(localDataSource)
    }

    @Test
    fun testGetTotalCashCount() {
        // Define the behavior of the mock object
        `when`(localDataSource.getCashCount()).thenReturn(100)

        // Perform the test
        val result = fakeLocalDataSource.getCashCount()

        // Verify the result
        assertEquals(100, result)
    }

    @Test
    fun `test insertCash`() = runBlockingTest {
        // Mock your repository or any dependencies
        val cashList = listOf(
            RepositoriesResponseModel(id = 0,name = "repo1"),
            RepositoriesResponseModel(id = 2,name = "repo2")
        )

        // Stubbing the behavior of the suspending function
        `when`(localDataSource.insertCash(cashList)).thenReturn(Unit)

        // Call the function under test
        fakeLocalDataSource.insertCash(cashList)

        // Verify the interactions and assertions
        verify(localDataSource).insertCash(cashList)
    }

    @Test
    fun `test getPagingCash`() {
        // Mock your repository or any dependencies
        val limit = 10
        val offset = 0
        val expectedList = listOf(
            RepositoriesResponseModel(id = 0,name = "repo1"),
            RepositoriesResponseModel(id = 2,name = "repo2")
        )

        // Stubbing the behavior of the function
        `when`(localDataSource.getPagingCash(limit, offset)).thenReturn(expectedList)

        // Call the function under test
        val result = fakeLocalDataSource.getPagingCash(limit, offset)

        // Verify the result
        assertEquals(expectedList, result)
    }

    @Test
    fun `test searchReposByName`() {
        // Mock your repository or any dependencies
        val searchQuery = "query"
        val limit = 10
        val offset = 0
        val expectedList = listOf(
            RepositoriesResponseModel(id = 0,name = "repo1"),
            RepositoriesResponseModel(id = 2,name = "repo2")
        )

        // Stubbing the behavior of the function
        `when`(localDataSource.searchReposByName(searchQuery, limit, offset)).thenReturn(expectedList)

        // Call the function under test
        val result = fakeLocalDataSource.searchReposByName(searchQuery, limit, offset)

        // Verify the result
        assertEquals(expectedList, result)
    }
}