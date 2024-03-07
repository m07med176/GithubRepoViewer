package tech.vodafone.githuprepoviewer.presentation.feature.issues

import androidx.test.runner.AndroidJUnit4
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import tech.vodafone.githuprepoviewer.domain.entities.IssuesRepoEntity
import tech.vodafone.githuprepoviewer.domain.usecases.GetRepositoryIssuesUsecase
import tech.vodafone.githuprepoviewer.domain.utils.ResourceState

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class RepoIssuesViewModelTest{
    @Mock
    lateinit var getRepositoryIssuesUsecase: GetRepositoryIssuesUsecase

    private lateinit var viewModel: RepoIssuesViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = RepoIssuesViewModel(getRepositoryIssuesUsecase)
    }


    @Test
    fun `test getIssuesOfRepository`() = runBlockingTest {
        // Mock data
        val owner = "owner"
        val repo = "repo"
        val issuesList = listOf(
            IssuesRepoEntity("issue1",null,null),
            IssuesRepoEntity("issue2",null,null)
        )
        val event = IssuesRepoEvents.GetRepoIssues(owner, repo)

        // Stub the behavior of the use case
        `when`(getRepositoryIssuesUsecase(owner, repo)).thenReturn(flowOf(ResourceState.Success(issuesList)))

        // Trigger the event
        viewModel.onEvent(event)

        // Verify the data state after success
        assertEquals(issuesList, viewModel.dataState)
    }

}