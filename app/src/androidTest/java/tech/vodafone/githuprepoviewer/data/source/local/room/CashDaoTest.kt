package tech.vodafone.githuprepoviewer.data.source.local.room

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.PrimaryKey
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Matchers
import tech.vodafone.githuprepoviewer.data.source.dto.Owner
import tech.vodafone.githuprepoviewer.data.source.dto.RepositoriesResponseModel
import tech.vodafone.githuprepoviewer.di.RepositoryModule

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class CashDaoTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var cashDao: CashDao
    private lateinit var database: RoomDB
    private lateinit var fakeData: RepositoriesResponseModel

    @Before
    fun setUp() {
        fakeData = RepositoriesResponseModel(
            id = 5,
            fullName = "Mohamed",
            name = "Mohamed",
            description = "This is fake data",
            owner = Owner(login = "Mohamed"),
        )
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            RoomDB::class.java
        ).allowMainThreadQueries().build()
        cashDao = database.cashDao()
    }

    @Test
    fun getRepos()  = runTest {
        // Given: fake data
        val sizeData = 30
        val fakeListData = mutableListOf<RepositoriesResponseModel>().apply {
            repeat(sizeData){
                add(fakeData.copy(id = it,name = "Mohamed$it" ))
            }
        }
        cashDao.insertCash(fakeListData)

        // When: get all data
        val item  = cashDao.getRepos(sizeData,0)

        // Then: count of data equal inserted data
        val count  = cashDao.getCashCount()
        assertEquals(count,item.size)
    }

    @Test
    fun searchReposByName() = runTest {
        // Given: fake data
        val sizeData = 30
        val fakeListData = mutableListOf<RepositoriesResponseModel>().apply {
            repeat(sizeData){
                add(fakeData.copy(id = it,name = "Mohamed$it" ))
            }
        }
        cashDao.insertCash(fakeListData)

        // When: get all data
        val item  = cashDao.searchReposByName(searchQuery = "Mohamed",sizeData,0)

        // Then: count of data equal inserted data
        val count  = cashDao.getCashCount()
        assertEquals(count,item.size)
    }
    @Test
    fun insertCash() = runTest {
        // Given: fake data
        val sizeData = 30
        val fakeListData = mutableListOf<RepositoriesResponseModel>().apply {
                repeat(sizeData){
                    add(fakeData.copy(id = it,name = "Mohamed$it" ))
                }
        }
        // When: insert fake data to room
        cashDao.insertCash(fakeListData)

        // Then: get last inserted data from room
        val item  = cashDao.getCashCount()
        assertEquals(item,fakeListData)
    }


    @Test
    fun deleteCash() = runTest {
        // Given: fake data
        val sizeData = 30
        val fakeListData = mutableListOf<RepositoriesResponseModel>().apply {
            repeat(sizeData){
                add(fakeData.copy(id = it,name = "Mohamed$it" ))
            }
        }
        cashDao.insertCash(fakeListData)

        // When: delete all data
        val item  = cashDao.deleteCash()

        // Then: check size
        val count  = cashDao.getCashCount()
        assertEquals(item,fakeListData)
    }
    @Test
    fun getCashCount() = runTest {
        // Given: fake data
        val sizeData = 30
        val fakeListData = mutableListOf<RepositoriesResponseModel>().apply {
            repeat(sizeData){
                add(fakeData.copy(id = it,name = "Mohamed$it" ))
            }
        }
        cashDao.insertCash(fakeListData)

        // When: request count in room
        val item  = cashDao.getCashCount()

        // Then: check size
        assertEquals(item,fakeListData)
    }

    @After
    fun closeDB() = database.close()
}