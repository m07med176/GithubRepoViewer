package tech.vodafone.githuprepoviewer.data.source.remote

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import tech.vodafone.githuprepoviewer.data.source.NetworkResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryDetailsResponse
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoryIssuesResponse
import tech.vodafone.githuprepoviewer.domain.entities.BadeResponse

@ExperimentalCoroutinesApi
class RemoteDataSourceTest{
    @Mock
    lateinit var remoteDataSource: RemoteDataSource

    lateinit var fakeRemoteDataSource: FakeRemoteDataSource
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        fakeRemoteDataSource = FakeRemoteDataSource(remoteDataSource)
    }

    @Test
    fun `test getRepositories`() = runBlockingTest {
        // Mock your repository or any dependencies
        val response: NetworkResponse<RepositoriesResponse, BadeResponse> = mock()

        // Stubbing the behavior of the suspending function
        `when`(remoteDataSource.getRepositories()).thenReturn(response)

        // Call the function under test
        val fakeClass = FakeRemoteDataSource(remoteDataSource)
        val result = fakeClass.getRepositories()

        // Verify the result
        assertEquals(response, result)
    }


    @Test
    fun `test getRepositoryIssues`() = runBlockingTest {
        // Mock your repository or any dependencies
        val remoteDataSource: RemoteDataSource = mock()
        val owner = "owner"
        val repo = "repo"
        val response: NetworkResponse<RepositoryIssuesResponse, BadeResponse> = mock()

        // Stubbing the behavior of the suspending function
        `when`(remoteDataSource.getRepositoryIssues(owner, repo)).thenReturn(response)

        // Call the function under test
        val fakeClass = FakeRemoteDataSource(remoteDataSource)
        val result = fakeClass.getRepositoryIssues(owner, repo)

        // Verify the result
        assertEquals(response, result)
    }

    @Test
    fun `test getRepositoryDetails`() = runBlockingTest {
        // Mock your repository or any dependencies
        val remoteDataSource: RemoteDataSource = mock()
        val owner = "owner"
        val repo = "repo"
        val response: NetworkResponse<RepositoryDetailsResponse, BadeResponse> = mock()

        // Stubbing the behavior of the suspending function
        `when`(remoteDataSource.getRepositoryDetails(owner, repo)).thenReturn(response)

        // Call the function under test
        val fakeClass = FakeRemoteDataSource(remoteDataSource)
        val result = fakeClass.getRepositoryDetails(owner, repo)

        // Verify the result
        assertEquals(response, result)
    }

}