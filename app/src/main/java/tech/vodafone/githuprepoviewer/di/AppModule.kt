//package tech.vodafone.githuprepoviewer.di
//
//import android.content.Context
//import dagger.Module
//import dagger.Provides
//import dagger.Reusable
//import dagger.hilt.InstallIn
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
//import tech.vodafone.githuprepoviewer.data.source.local.LocalDataSource
//import tech.vodafone.githuprepoviewer.data.source.local.LocalDataSourceImpl
//import tech.vodafone.githuprepoviewer.data.source.local.room.RoomDB
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule {
//
////    @Provides
////    @Singleton
////    fun provideRemoteSource(): IRemoteDataSource {
////        return RemoteDataSource(RetrofitInstance().api)
////    }
//
//    /**
//     * # Room DB
//     */
//    @Provides
//    @Reusable
//    fun provideLocalDataSource(@ApplicationContext context: Context): LocalDataSource {
//        val db = RoomDB.invoke(context).cashDao()
//        return LocalDataSourceImpl(db)
//    }
//
//}
