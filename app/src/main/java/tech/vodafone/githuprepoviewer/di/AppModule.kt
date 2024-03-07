package tech.vodafone.githuprepoviewer.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import tech.vodafone.githuprepoviewer.data.source.local.LocalDataSource
import tech.vodafone.githuprepoviewer.data.source.local.LocalDataSourceImpl
import tech.vodafone.githuprepoviewer.data.source.local.room.RoomDB
import tech.vodafone.githuprepoviewer.data.source.remote.ConnectivityManagerNetworkMonitor
import tech.vodafone.githuprepoviewer.data.source.remote.NetworkMonitor
import tech.vodafone.githuprepoviewer.data.source.remote.RemoteDataSource
import tech.vodafone.githuprepoviewer.data.source.remote.RemoteDataSourceImpl
import tech.vodafone.githuprepoviewer.data.source.remote.retrofit.RetrofitInstance
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /**
     * # Network
     */
    @Provides
    @Singleton
    fun provideNetworkMonitor(@ApplicationContext context: Context): NetworkMonitor {
        return ConnectivityManagerNetworkMonitor(context)
    }

    /**
     * # Retrofit Network
     */
    @Provides
    @Singleton
    fun provideRemoteSource(): RemoteDataSource {
        return RemoteDataSourceImpl(RetrofitInstance.api)
    }

    /**
     * # Room DB
     */
    @Provides
    @Reusable
    fun provideLocalDataSource(@ApplicationContext context: Context): LocalDataSource {
        val db = RoomDB.invoke(context).cashDao()
        return LocalDataSourceImpl(db)
    }

}
